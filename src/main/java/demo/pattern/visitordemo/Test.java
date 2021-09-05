package demo.pattern.visitordemo;

/**
 * User: BigStrong
 * Date: 2021/8/25
 * Description: No Description
 */
public class Test {
    public static void main(String[] args) {
        new FruitCollection().collect(new LiuQiangVisitor());
    }
}
