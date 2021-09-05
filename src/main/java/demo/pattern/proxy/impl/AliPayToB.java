package demo.pattern.proxy.impl;

import demo.pattern.proxy.ToBPayment;

/**
 * User: BigStrong
 * Date: 2021/9/5
 * Description: No Description
 */
public class AliPayToB implements ToBPayment {

    private ToBPayment toBPayment;

    public AliPayToB(ToBPayment toBPayment) {
       this.toBPayment = toBPayment;
    }

    @Override
    public void pay() {
        before();
        toBPayment.pay();
        after();
    }

    private void after() {
        System.out.println("转给幕课网");
    }

    private void before() {
        System.out.println("从招商取款");
    }
}
