package demo.pattern.visitor;

/**
 * User: BigStrong
 * Date: 2021/8/25
 * Description: 电脑的零配件的父抽象类
 */
public abstract class ComputerPart {
    abstract void link(HardwareInterface hardwareInterface);
}
