package demo.pattern.visitor;

/**
 * User: BigStrong
 * Date: 2021/8/25
 * Description: No Description
 */
public class HardDisk extends ComputerPart{
    @Override
    void link(HardwareInterface hardwareInterface) {
        hardwareInterface.visitor(this);
        System.out.println("硬盘以及连接上了，开始存储数据");
    }
}
