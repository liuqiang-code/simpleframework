package demo.pattern.factory.abstractf;

import demo.pattern.factory.entity.KeyBoard;
import demo.pattern.factory.entity.Mouse;

/**
 * User: BigStrong
 * Date: 2021/7/23
 * Description: No Description
 */
public class AbstractFactoryDemo {
    public static void main(String[] args) {

        ComputerFactory computerFactory = new HpComputerFactory();

        Mouse mouse = computerFactory.createMouse();

        KeyBoard keyBoard = computerFactory.createKeyBoard();

        mouse.click();

        keyBoard.touch();
    }
}
