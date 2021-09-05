package demo.pattern.proxy.impl;

import demo.pattern.proxy.ToCPayment;

/**
 * User: BigStrong
 * Date: 2021/9/5
 * Description: No Description
 */
public class AliPayToC implements ToCPayment {

    private ToCPayment toCPayment;

    public AliPayToC(ToCPayment toCPayment) {
       this.toCPayment = toCPayment;
    }

    @Override
    public void pay() {
        beforePay();
        toCPayment.pay();
        afterPay();
    }

    private void beforePay() {
        System.out.println("从招行取款");
    }

    private void afterPay() {
        System.out.println("支付给幕客网");
    }
}
