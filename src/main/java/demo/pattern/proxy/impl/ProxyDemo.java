package demo.pattern.proxy.impl;

import demo.pattern.proxy.ToBPayment;
import demo.pattern.proxy.ToCPayment;
import demo.pattern.proxy.jdkproxy.AlipayInvocationHandler;
import demo.pattern.proxy.jdkproxy.JdkDynamicProxyUtil;

import java.lang.reflect.Proxy;

/**
 * User: BigStrong
 * Date: 2021/9/5
 * Description: No Description
 */
public class ProxyDemo {
    public static void main(String[] args) {

//        ToCPayment aliPayToC = new AliPayToC(new ToCPaymentImpl());
//
//        aliPayToC.pay();
//
//        AliPayToB aliPayToB = new AliPayToB(new ToBPaymentImpl());
//
//        aliPayToB.pay();

//        ToCPaymentImpl toCPayment = new ToCPaymentImpl();
//        AlipayInvocationHandler alipayInvocationHandler = new AlipayInvocationHandler(toCPayment);
//        ToCPayment toCProxy = JdkDynamicProxyUtil.newProxyInstance(toCPayment, alipayInvocationHandler);
//        toCProxy.pay();

        ToBPayment toBPaymentProxy = (ToBPayment) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                ToBPaymentImpl.class.getInterfaces(), new AlipayInvocationHandler(new ToBPaymentImpl()));

        toBPaymentProxy.pay();
    }
}
