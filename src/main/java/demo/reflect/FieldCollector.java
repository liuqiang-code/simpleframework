package demo.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * User: BigStrong
 * Date: 2021/7/31
 * Description: No Description
 */
public class FieldCollector {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // 获取class对象
        Class clazz = Class.forName("demo.reflect.ReflectTarget");

        // 1. 获取所有的公有字段
        System.out.println("---------------------获取所有的公有字段---------------------");
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        // 2. 获取所有的字段
        System.out.println("---------------------获取所有字段---------------------");
        Field[] fields1 = clazz.getDeclaredFields();
        for (Field field : fields1) {
            System.out.println(field);
        }

        // 3.获取单个特定的公有filed
        System.out.println("---------------------获取单个特定的公有字段---------------------");
        Field name = clazz.getField("name");

        // 创建对象
        ReflectTarget reflectTarget = (ReflectTarget) clazz.getDeclaredConstructor().newInstance();

        name.set(reflectTarget, "bigstrong");

        System.out.println(reflectTarget.name);

        // 4. 获取单个私有的filed
        System.out.println("---------------------获取单个私有的字段---------------------");
        Field targetInfo = clazz.getDeclaredField("targetInfo");
        System.out.println(targetInfo);
        targetInfo.setAccessible(true);
        targetInfo.set(reflectTarget, "hello");
        System.out.println(reflectTarget);
    }
}
