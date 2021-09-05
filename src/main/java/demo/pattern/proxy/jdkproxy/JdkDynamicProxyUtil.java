package demo.pattern.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * User: BigStrong
 * Date: 2021/9/5
 * Description: No Description
 */
public class JdkDynamicProxyUtil {
    public static <T> T newProxyInstance(T targetObject, InvocationHandler invocationHandler) {

        ClassLoader classLoader = targetObject.getClass().getClassLoader();

        Class<?>[] interfaces = targetObject.getClass().getInterfaces();

        return (T)Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
    }
}
