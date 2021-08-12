package demo.pattern.template;

/**
 * User: BigStrong
 * Date: 2021/8/12
 * Description: No Description
 */
public class TemplateDemo {
    public static void main(String[] args) {
        KTVRoom ktvRoom = new ChineseSinger();
        ktvRoom.procedure();

        System.out.println("----------------------------");

        KTVRoom ktvRoom1 = new JapanSinger();
        ktvRoom1.procedure();
    }
}
