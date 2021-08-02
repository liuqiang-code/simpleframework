package demo.pattern.factory.entity;

/**
 * User: BigStrong
 * Date: 2021/7/23
 * Description: No Description
 */
public class LenvenMouse implements Mouse{
    @Override
    public void click() {
        System.out.printf("我是联想鼠标");
    }
}
