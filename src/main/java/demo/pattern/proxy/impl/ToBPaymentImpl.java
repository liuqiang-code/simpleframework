package demo.pattern.proxy.impl;

import demo.pattern.proxy.ToBPayment;

/**
 * User: BigStrong
 * Date: 2021/9/5
 * Description: No Description
 */
public class ToBPaymentImpl implements ToBPayment {
    @Override
    public void pay() {
        System.out.println("以银行的名义进行支付");
    }
}
