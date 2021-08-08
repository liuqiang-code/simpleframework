package org.simpleframework.inject;

import lombok.extern.slf4j.Slf4j;
import org.simpleframework.core.BeanContainer;
import org.simpleframework.inject.annotation.Autowired;
import org.simpleframework.util.ClassUtil;
import org.simpleframework.util.ValidationUtil;

import java.lang.reflect.Field;
import java.util.Set;

/**
 * User: BigStrong
 * Date: 2021/8/8
 * Description: No Description
 */
@Slf4j
public class DependencyInjector {

    private BeanContainer beanContainer = BeanContainer.getInstance();

    /**
     * 执行IOC
     */
    public void doIoc() {

        if (ValidationUtil.isEmpty(beanContainer.getClasses())) {
            log.warn("empty classSet in BeanContainer");
            return;
        }

        // 1. 遍历Bean容器中所有Class对象
        for (Class<?> aClass : beanContainer.getClasses()) {
            // 2. 遍历Class对象的所有成员变量
            Field[] declaredFields = aClass.getDeclaredFields();

            if (declaredFields == null || declaredFields.length == 0) {
                continue;
            }

            for (Field declaredField : declaredFields) {
                // 3. 找出被Autowired标记的成员变量
                if (declaredField.isAnnotationPresent(Autowired.class)) {
                    Autowired annotation = declaredField.getAnnotation(Autowired.class);
                    String autowiredValue = annotation.value();
                    // 4. 获取这些变量的类型
                    Class<?> type = declaredField.getType();
                    // 5. 获取这些成员变量的类型在容器里面对应的实例
                    Object fieldValue = getFieldInstance(type, autowiredValue);

                    if (fieldValue == null) {
                        throw new RuntimeException("unable to inject relevant type , target fieldClass is:" + type.getName());
                    } else {
                        // 6. 通过反射将对应的成员变量实例注入到成员变量所在类的实例里
                        Object targetBean = beanContainer.getBean(aClass);
                        ClassUtil.setField(declaredField, targetBean, fieldValue, true);
                    }
                }
            }




        }
    }

    /**
     * 根据Class在BeanContainer里获取其实例或者实现类
     * @param type
     * @return
     */
    private Object getFieldInstance(Class<?> type, String autowiredValue) {

        Object fieldValue = beanContainer.getBean(type);

        if (fieldValue != null) {
            return fieldValue;
        } else {
            Class<?> implementClass = getImplementClass(type, autowiredValue);
            if (implementClass != null) {
                return beanContainer.getBean(implementClass);
            }else {
                return null;
            }
        }
    }

    /**
     * 获取接口的实现类
     * @param type
     * @param autowiredValue
     * @return
     */
    private Class<?> getImplementClass(Class<?> type, String autowiredValue) {

        Set<Class<?>> classesBySuper = beanContainer.getClassesBySuper(type);

        if (!ValidationUtil.isEmpty(classesBySuper)) {
            if (autowiredValue == null || "".equals(autowiredValue)) {
                if (classesBySuper.size() == 1) {
                    return classesBySuper.iterator().next();
                } else {
                    // 如果多于两个实现类并且用户未指定其中一个实现类，则抛出异常
                    throw new RuntimeException("multiple implemented classes for " + type.getName() + "please set @Autowired value to pick one");
                }
            } else {
                for (Class<?> aClass : classesBySuper) {
                    if (autowiredValue.equals(aClass.getSimpleName())) {
                        return aClass;
                    }
                }
            }
        }

        return null;
    }
}
