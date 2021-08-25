package demo.pattern.visitor;

/**
 * User: BigStrong
 * Date: 2021/8/25
 * Description: No Description
 */
public class Computer {
    public void useComputer(HardwareInterface hardwareInterface) {
        new CPU().link(hardwareInterface);
        new VideoCard().link(hardwareInterface);
        new HardDisk().link(hardwareInterface);
    }
}
