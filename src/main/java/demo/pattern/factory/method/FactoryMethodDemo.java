package demo.pattern.factory.method;

import demo.pattern.factory.entity.Mouse;

/**
 * User: BigStrong
 * Date: 2021/7/23
 * Description: No Description
 */
public class FactoryMethodDemo {
    public static void main(String[] args) {

        //MouseFactory mouseFactory = new DellMouseFactory();

        HpMouseFactory mouseFactory = new HpMouseFactory();

        Mouse mouse = mouseFactory.createMouse();

        mouse.click();
    }
}
