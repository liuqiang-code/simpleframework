package demo.pattern.factory.abstractf;

import demo.pattern.factory.entity.HpKeyBoard;
import demo.pattern.factory.entity.HpMouse;
import demo.pattern.factory.entity.KeyBoard;
import demo.pattern.factory.entity.Mouse;

/**
 * User: BigStrong
 * Date: 2021/7/23
 * Description: No Description
 */
public class HpComputerFactory implements ComputerFactory{
    @Override
    public Mouse createMouse() {
        return new HpMouse();
    }

    @Override
    public KeyBoard createKeyBoard() {
        return new HpKeyBoard();
    }
}
