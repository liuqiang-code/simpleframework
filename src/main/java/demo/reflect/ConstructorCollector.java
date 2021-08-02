package demo.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * User: BigStrong
 * Date: 2021/7/31
 * Description: No Description
 */
public class ConstructorCollector {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class clazz = Class.forName("demo.reflect.ReflectTarget");

        // 1. 获取所有的公有构造方法
        System.out.println("---------------------所有的公有构造方法---------------------");
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }

        // 2. 获取所有的构造方法
        System.out.println("---------------------所有的构造方法---------------------");
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }

        // 3. 获取单个带参数的构造方法
        System.out.println("---------------------获取单个的构造方法---------------------");
        Constructor constructor = clazz.getConstructor(char.class, int.class);
        System.out.println(constructor);

        // 4. 获取单个私有的构造方法
        System.out.println("---------------------获取单个私有的构造方法---------------------");
        Constructor declaredConstructor = clazz.getDeclaredConstructor(int.class);
        System.out.println(declaredConstructor);

        System.out.println("---------------------获取单个私有的构造方法，创建实例---------------------");
        // 暴力访问 忽略访问修饰符
        declaredConstructor.setAccessible(true);
        declaredConstructor.newInstance(100);
    }
}
