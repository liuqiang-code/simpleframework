package demo.pattern.template;

/**
 * User: BigStrong
 * Date: 2021/8/12
 * Description: No Description
 */
public class ChineseSinger extends KTVRoom{
    @Override
    protected void orderSong() {
        System.out.println("点了首中文歌.....");
    }

    @Override
    protected void orderExtra() {
        System.out.println("买了水果，进行额外的消费....");
    }
}
