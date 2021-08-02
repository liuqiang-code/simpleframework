package demo.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * User: BigStrong
 * Date: 2021/7/31
 * Description: No Description
 */
public class MethodCollector {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // 获取class对象
        Class clazz = Class.forName("demo.reflect.ReflectTarget");

        // 获取所有的公有方法 包含付父类的public方法
        System.out.println("获取所有的公有方法 包含付父类的public方法");
        Method[] methods = clazz.getMethods();

        for (Method method : methods) {
            System.out.println(method);
        }

        // 获取所有方法 不包含父类方法
        System.out.println("获取所有方法 不包含父类方法");
        Method[] declaredMethods = clazz.getDeclaredMethods();

        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }

        // 获取单个公有方法
        System.out.println("获取单个公有方法");
        Method show1 = clazz.getMethod("show1");
        System.out.println(show1);

        ReflectTarget reflectTarget = (ReflectTarget) clazz.getDeclaredConstructor().newInstance();

        show1.invoke(reflectTarget);

        // 获取单个私有的方法
        System.out.println("获取单个私有的方法");
        Method show4 = clazz.getDeclaredMethod("show4");
        show4.setAccessible(true);
        Object result = show4.invoke(reflectTarget);
        System.out.println(result);
    }
}
