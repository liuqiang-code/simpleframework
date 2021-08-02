package demo.pattern.factory.method;

import demo.pattern.factory.entity.HpMouse;
import demo.pattern.factory.entity.Mouse;

/**
 * User: BigStrong
 * Date: 2021/7/23
 * Description: No Description
 */
public class HpMouseFactory extends DellMouseFactory{
    @Override
    public Mouse createMouse() {
        return new HpMouse();
    }
}
