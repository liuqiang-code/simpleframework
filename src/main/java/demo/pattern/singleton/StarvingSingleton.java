package demo.pattern.singleton;

/**
 * User: BigStrong
 * Date: 2021/8/4
 * Description: No Description
 */
public class StarvingSingleton {

    private static final StarvingSingleton starvingSingleton = new StarvingSingleton();

    private StarvingSingleton() {}

    public static StarvingSingleton getInstance() {
        return starvingSingleton;
    }
}
