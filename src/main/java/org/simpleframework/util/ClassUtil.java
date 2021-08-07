package org.simpleframework.util;

import lombok.extern.slf4j.Slf4j;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

/**
 * User: BigStrong
 * Date: 2021/8/2
 * Description: No Description
 */
@Slf4j
public class ClassUtil {

    public static final String FILE_PROTOCOL = "file";

    /**
     * 获取包下类的集合
     * @param packageName
     * @return 类集合
     */
    public static Set<Class<?>> extractPackageClass(String packageName) {
        // 1. 获取到类的加载器
        ClassLoader classLoader = getClassLoader();
        // 2. 通过类加载器获取到加载的资源
        URL resource = classLoader.getResource(packageName.replace(".", "/"));
        if (resource == null) {
            log.warn("unable to retrieve anything from package: " + packageName);
            return null;
        }
        // 3. 依据不同的资源类型，采用不同的方式获取资源的集合
        Set<Class<?>> classSet = null;
        if (resource.getProtocol().equalsIgnoreCase(FILE_PROTOCOL)) {
            classSet = new HashSet<Class<?>>();
            File packageDirectory = new File(resource.getPath());
            extractClassFile(classSet, packageDirectory, packageName);
        }
        return classSet;
    }

    /**
     * 递归获取目标package里面所有class文件(包括子package里面的class文件)
     * @param emptyClassSet 装载目标类的集合
     * @param fileSource 文件或目录
     * @param packageName 包名
     */
    private static void extractClassFile(Set<Class<?>> emptyClassSet, File fileSource, String packageName) {
        if (!fileSource.isDirectory()) {
            return;
        }

        File[] files = fileSource.listFiles(file -> {
            if (file.isDirectory()) {
                return true;
            } else {
                // 获取文件的绝对路径
                String absolutePath = file.getAbsolutePath();
                if (absolutePath.endsWith(".class")) {
                    // 如果是class文件，则直接加载
                    addToClassSet(absolutePath, packageName, emptyClassSet);
                }
            }
            return false;
        });

        if (files != null) {
            for (File f : files) {
                extractClassFile(emptyClassSet, f, packageName);
            }
        }
    }

    // 根据class文件的绝对值路径，获取并生成class对象，并放入classSet中
    private static void addToClassSet(String absolutePath, String packageName, Set<Class<?>> emptyClassSet) {
        // 1. 提取包含了package的类名
        absolutePath = absolutePath.replace(File.separator, ".");
        String className = absolutePath.substring(absolutePath.indexOf(packageName));
        className = className.substring(0, className.lastIndexOf("."));
        // 2. 通过反射机制获取对应的class对象并加入到classSet中
        Class targetClass = loadClass(className);
        emptyClassSet.add(targetClass);
    }

    /**
     * 获取class对象
     * @param className class 全名 = package + 类名
     * @return Class
     */
    public static Class<?> loadClass(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            log.error("load class error", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * 实例化class
     * @param clazz
     * @param <T>
     * @param accessible 是否支持创建出私有class对象的实例
     * @return
     */
    public static <T> T newInstance(Class<T> clazz, boolean accessible) {
        try {
            Constructor<?> declaredConstructor = clazz.getDeclaredConstructor();
            declaredConstructor.setAccessible(accessible);
            return (T) declaredConstructor.newInstance();
        } catch (Exception e) {
            log.error("newInstance error", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取ClassLoader
     * @return 当前的classloader
     */
    public static ClassLoader getClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }

    public static void main(String[] args) {
        Set<Class<?>> classes = extractPackageClass("com.bigstrong");

        for (Class<?> aClass : classes) {
            System.out.println(aClass);
        }
    }
}
