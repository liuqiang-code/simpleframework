package demo.pattern.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * User: BigStrong
 * Date: 2021/9/25
 * Description: No Description
 */
public class CglibUtil {
    public static<T> T createProxy(T targetObject, MethodInterceptor methodInterceptor) {
        return (T) Enhancer.create(targetObject.getClass(), methodInterceptor);
    }
}
