package demo.pattern.factory.abstractf;

import demo.pattern.factory.entity.KeyBoard;
import demo.pattern.factory.entity.Mouse;

/**
 * User: BigStrong
 * Date: 2021/7/23
 * Description: No Description
 */
public interface ComputerFactory {
    Mouse createMouse();
    KeyBoard createKeyBoard();
}
