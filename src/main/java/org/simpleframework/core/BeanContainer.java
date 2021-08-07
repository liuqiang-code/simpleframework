package org.simpleframework.core;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.simpleframework.core.annotation.Component;
import org.simpleframework.core.annotation.Controller;
import org.simpleframework.core.annotation.Repository;
import org.simpleframework.core.annotation.Service;
import org.simpleframework.util.ClassUtil;
import org.simpleframework.util.ValidationUtil;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * User: BigStrong
 * Date: 2021/8/7
 * Description: No Description
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BeanContainer {

    /**
     * 存放所有被配置标记的目标对象Map
     */
    private final Map<Class<?>, Object> beanMap = new ConcurrentHashMap<>();

    /**
     * 获取beanMap里面的bean数量
     * @return 数量
     */
    public int size() {
        return beanMap.size();
    }

    /**
     * 加载bean的注解列表
     */
    private static final List<Class<? extends Annotation>> BEAN_ANNOTATION =
            Arrays.asList(Component.class, Controller.class, Service.class, Repository.class);

    /**
     * 获取Bean容器实例
     * @return BeanContainer
     */
    public static BeanContainer getInstance() {
        return ContainerHolder.HOLDER.instance;
    }

    private enum ContainerHolder {
        HOLDER;
        private BeanContainer instance;
        ContainerHolder() {
            instance = new BeanContainer();
        }
    }

    /**
     * 容器是否已经加载过bean
     */
    private boolean loaded = false;

    /**
     * 是否加载过Bean
     * @return 是否已经加载过
     */
    public boolean isLoaded() {
        return loaded;
    }

    /**
     * 扫描加载所有bean
     *
     * @param packageName 包名
     */
    public synchronized void loadBeans(String packageName) {

        if (isLoaded()) {
           log.warn("BeanContainer has been loaded");
           return;
        }

        Set<Class<?>> classes = ClassUtil.extractPackageClass(packageName);

        if (ValidationUtil.isEmpty(classes)) {
            log.warn("extract nothing from packageName " + packageName);
            return;
        }

        for (Class<?> aClass : classes) {
            for (Class<? extends Annotation> annotation : BEAN_ANNOTATION) {
                // 如果类上面标记了定义的注解
                if (aClass.isAnnotationPresent(annotation)) {
                    // 将目标类本身作为键，目标类的实例作为值，放到beanMap中
                    beanMap.put(aClass,  ClassUtil.newInstance(aClass, true));
                }
            }
        }

        loaded = true;
    }

}
