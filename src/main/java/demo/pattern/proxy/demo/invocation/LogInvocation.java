package demo.pattern.proxy.demo.invocation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * User: BigStrong
 * Date: 2021/9/5
 * Description: No Description
 */
public class LogInvocation implements InvocationHandler {

    private Object targetObject;

    public LogInvocation(Object targetObject) {
        this.targetObject = targetObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("记录日志前输出");
        Object result = method.invoke(targetObject, args);
        System.out.println("记录日志后输出");
        return result;
    }
}
