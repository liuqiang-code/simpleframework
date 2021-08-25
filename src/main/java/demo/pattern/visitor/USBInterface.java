package demo.pattern.visitor;

/**
 * User: BigStrong
 * Date: 2021/8/25
 * Description: No Description
 */
public class USBInterface implements HardwareInterface{
    @Override
    public void visitor(CPU cpu) {
        System.out.println("usb连接cpu");
    }

    @Override
    public void visitor(VideoCard videoCard) {
        System.out.println("用usb连接显卡");
    }

    @Override
    public void visitor(HardDisk hardDisk) {
        System.out.println("用usb连接硬盘");
    }
}
