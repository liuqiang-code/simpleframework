package demo.pattern.visitor;

/**
 * User: BigStrong
 * Date: 2021/8/25
 * Description: No Description
 */
public class VideoCard extends ComputerPart{
    @Override
    void link(HardwareInterface hardwareInterface) {
        hardwareInterface.visitor(this);
        System.out.println("连接上显卡之后，显卡开始工作，提供图像");
    }
}
