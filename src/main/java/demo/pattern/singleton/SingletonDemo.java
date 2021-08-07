package demo.pattern.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * User: BigStrong
 * Date: 2021/8/4
 * Description: No Description
 */
public class SingletonDemo {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        System.out.println(EnumStarvingSingleton.getInstance());

        Class clazz = EnumStarvingSingleton.class;

        Constructor declaredConstructor = clazz.getDeclaredConstructor();

        declaredConstructor.setAccessible(true);

        EnumStarvingSingleton enumStarvingSingleton = (EnumStarvingSingleton) declaredConstructor.newInstance();

        System.out.println(enumStarvingSingleton.getInstance());
    }
}
