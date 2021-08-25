package demo.pattern.visitor;

/**
 * User: BigStrong
 * Date: 2021/8/25
 * Description: 硬件的接口
 */
public interface HardwareInterface {
    // 定义接口，访问硬件用的
    public void visitor(CPU cpu);
    public void visitor(VideoCard videoCard);
    public void visitor(HardDisk hardDisk);
}
