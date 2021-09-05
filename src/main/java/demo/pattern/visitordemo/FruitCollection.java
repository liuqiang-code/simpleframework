package demo.pattern.visitordemo;

/**
 * User: BigStrong
 * Date: 2021/8/25
 * Description: No Description
 */
public class FruitCollection {
    public void collect(Ivisitor ivisitor) {
       new Apple().accept(ivisitor);
       new Banana().accept(ivisitor);
    }
}
