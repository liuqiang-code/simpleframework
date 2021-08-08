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
import java.util.*;
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

    /**
     * 添加一个class对象及Bean实例
     * @param clazz
     * @param bean
     * @return
     */
    public Object addBean(Class<?> clazz, Object bean) {
        return beanMap.put(clazz, bean);
    }

    /**
     * 移除一个IOC容器管理的对象
     * @param clazz
     * @return 删除bean的实例，没有则返回null
     */
    public Object removeBean(Class<?> clazz) {
        return beanMap.remove(clazz);
    }

    /**
     * 根据Class对象获取bean实例
     * @param clazz
     * @return
     */
    public Object getBean(Class<?> clazz) {
        return beanMap.get(clazz);
    }

    /**
     * 获取容器管理的所有Class对象集合
     * @return
     */
    public Set<Class<?>> getClasses() {
        return beanMap.keySet();
    }

    /**
     * 获取所有Bean集合
     * @return
     */
    public Set<Object> getBeans() {
        return new HashSet<>(beanMap.values());
    }

    /**
     * 根据注解塞选出bean的class集合
     * @param annotation
     * @return
     */
    public Set<Class<?>> getClassesByAnnotation(Class<? extends Annotation> annotation) {
        // 1 获取beanMap里面所有class对象
        Set<Class<?>> classes = getClasses();

        if (ValidationUtil.isEmpty(classes)) {
            log.warn("nothing in beanMap");
            return null;
        }

        // 2 通过注解筛选被注解标记的class对象，并添加到classSet里
        Set<Class<?>> retSet = new HashSet<>();

        for (Class<?> aClass : classes) {
            if (aClass.isAnnotationPresent(annotation)) {
                retSet.add(aClass);
            }
        }

        return retSet.size() > 0 ? retSet : null;
    }

    /**
     * 通过接口或者父类获取实现类或者子类的Class集合，不包含其本身
     * @param interfaceOrClass 接口Class或者父类Class
     * @return
     */
    public Set<Class<?>> getClassesBySuper(Class<?> interfaceOrClass) {
        // 1 获取beanMap里面所有class对象
        Set<Class<?>> classes = getClasses();

        if (ValidationUtil.isEmpty(classes)) {
            log.warn("nothing in beanMap");
            return null;
        }

        // 2 判断classes里的元素是否是传入的接口或者类的子类，如果是，就将其添加到retSet里
        Set<Class<?>> retSet = new HashSet<>();

        for (Class<?> aClass : classes) {
            if (interfaceOrClass.isAssignableFrom(aClass) && !aClass.equals(interfaceOrClass)) {
                retSet.add(aClass);
            }
        }

        return retSet.size() > 0 ? retSet : null;
    }

}
