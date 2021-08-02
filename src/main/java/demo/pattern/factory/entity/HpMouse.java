package demo.pattern.factory.entity;

import demo.pattern.factory.method.MouseFactory;

/**
 * User: BigStrong
 * Date: 2021/7/23
 * Description: No Description
 */
public class HpMouse implements Mouse {
    @Override
    public void click() {
        System.out.println("我是惠普鼠标");
    }
}
