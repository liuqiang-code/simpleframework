package demo.pattern.factory.entity;

/**
 * User: BigStrong
 * Date: 2021/7/23
 * Description: No Description
 */
public class DellMouse implements Mouse{
    @Override
    public void click() {
        System.out.println("我是戴尔鼠标");
    }
}
