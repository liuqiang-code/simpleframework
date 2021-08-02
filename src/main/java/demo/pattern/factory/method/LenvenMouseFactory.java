package demo.pattern.factory.method;

import demo.pattern.factory.entity.LenvenMouse;
import demo.pattern.factory.entity.Mouse;

/**
 * User: BigStrong
 * Date: 2021/7/23
 * Description: No Description
 */
public class LenvenMouseFactory implements MouseFactory{
    @Override
    public Mouse createMouse() {
        return new LenvenMouse();
    }
}
