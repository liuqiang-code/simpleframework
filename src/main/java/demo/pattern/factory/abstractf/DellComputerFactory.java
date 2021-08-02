package demo.pattern.factory.abstractf;

import demo.pattern.factory.entity.DellKeyBoard;
import demo.pattern.factory.entity.DellMouse;
import demo.pattern.factory.entity.KeyBoard;
import demo.pattern.factory.entity.Mouse;

/**
 * User: BigStrong
 * Date: 2021/7/23
 * Description: No Description
 */
public class DellComputerFactory implements ComputerFactory{
    @Override
    public Mouse createMouse() {
        return new DellMouse();
    }

    @Override
    public KeyBoard createKeyBoard() {
        return new DellKeyBoard();
    }
}
