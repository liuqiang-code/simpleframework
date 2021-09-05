package demo.pattern.visitordemo;

/**
 * User: BigStrong
 * Date: 2021/8/25
 * Description: No Description
 */
public class Apple extends Fruits{
    @Override
    void accept(Ivisitor ivisitor) {
        ivisitor.visitor(this);
    }
}
