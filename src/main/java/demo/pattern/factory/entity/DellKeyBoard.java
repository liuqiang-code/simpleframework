package demo.pattern.factory.entity;

/**
 * User: BigStrong
 * Date: 2021/7/23
 * Description: No Description
 */
public class DellKeyBoard implements KeyBoard{
    @Override
    public void touch() {
        System.out.println("我是戴尔键盘");
    }
}
