package demo.pattern.factory.method;

import demo.pattern.factory.entity.DellMouse;
import demo.pattern.factory.entity.Mouse;

/**
 * User: BigStrong
 * Date: 2021/7/23
 * Description: No Description
 */
public class DellMouseFactory implements MouseFactory{
    @Override
    public Mouse createMouse() {
        return new DellMouse();
    }
}
