package demo.pattern.proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * User: BigStrong
 * Date: 2021/9/25
 * Description: No Description
 */
public class AlipayMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        beforePay();
        Object result = methodProxy.invokeSuper(o, objects);
        afterPay();
        return result;
    }

    private void beforePay() {
        System.out.println("从招行取款");
    }

    private void afterPay() {
        System.out.println("支付给幕客网");
    }

}
