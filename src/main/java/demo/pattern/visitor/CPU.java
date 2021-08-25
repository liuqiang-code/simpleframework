package demo.pattern.visitor;

/**
 * User: BigStrong
 * Date: 2021/8/25
 * Description: 电脑的硬件CPU，用于数据的运算
 */
public class CPU extends ComputerPart{
    @Override
    void link(HardwareInterface hardwareInterface) {
        hardwareInterface.visitor(this);
        System.out.println("连接上了之后，利用cpu进行计算数据");
    }
}
