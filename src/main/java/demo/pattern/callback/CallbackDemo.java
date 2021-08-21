package demo.pattern.callback;

/**
 * User: BigStrong
 * Date: 2021/8/21
 * Description: No Description
 */
public class CallbackDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("我要休息拉");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("我被回调啦");
        });
        thread.start();
    }
}
