package demo.pattern.proxy.demo;

import demo.pattern.proxy.demo.impl.LogInterfaceImpl;
import demo.pattern.proxy.demo.invocation.LogInvocation;

import java.lang.reflect.Proxy;

/**
 * User: BigStrong
 * Date: 2021/9/5
 * Description: No Description
 */
public class LogDemo {
    public static void main(String[] args) {

        // 创建调用处理器
        LogInvocation logInvocation = new LogInvocation(new LogInterfaceImpl());

        // 生成代理对象
        LogInterface logInterface = (LogInterface) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), LogInterfaceImpl.class.getInterfaces(),
                logInvocation);

        // 调用代理
        logInterface.log();
    }
}
