package demo.pattern.template;

/**
 * User: BigStrong
 * Date: 2021/8/12
 * Description: No Description
 */
public abstract class KTVRoom {

    public void procedure() {
        openDivice();
        orderSong();
        orderExtra();
        pay();
    }

    // 共用方法
    private void openDivice() {
        System.out.println("打开设备和音响");
    }

    // 抽象方法，由子类实现
    protected abstract void orderSong();

    // 钩子，额外开销视情况选择
    protected void orderExtra() {}

    // 共用方法
    private void pay() {
        System.out.println("支付本次消费账单....");
    }
}
