package demo.pattern.visitordemo;

/**
 * User: BigStrong
 * Date: 2021/8/25
 * Description: No Description
 */
public class LiuQiangVisitor implements Ivisitor{
    @Override
    public void visitor(Apple apple) {
        System.out.println("切苹果");
    }

    @Override
    public void visitor(Banana banana) {
        System.out.println("切香蕉");
    }
}
