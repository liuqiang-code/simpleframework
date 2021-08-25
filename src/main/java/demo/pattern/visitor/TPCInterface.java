package demo.pattern.visitor;

/**
 * User: BigStrong
 * Date: 2021/8/25
 * Description: No Description
 */
public class TPCInterface extends USBInterface{
    @Override
    public void visitor(VideoCard videoCard) {
        System.out.println("TPC接口显卡 连接处理");
    }
}
