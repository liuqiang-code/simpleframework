package demo.pattern.proxy.impl;

import demo.pattern.proxy.ToCPayment;

/**
 * User: BigStrong
 * Date: 2021/9/5
 * Description: No Description
 */
public class ToCPaymentImpl implements ToCPayment {
    @Override
    public void pay() {
        System.out.println("以用户的名义进行支付");
    }
}
