package demo.pattern.singleton;

/**
 * User: BigStrong
 * Date: 2021/8/4
 * Description: No Description
 */
public class LazyDoubleCheckSingleton {

    private volatile static LazyDoubleCheckSingleton instance;

    private LazyDoubleCheckSingleton() {}

    public static LazyDoubleCheckSingleton getInstance() {

        if (instance == null) {
            // 同步
            synchronized (LazyDoubleCheckSingleton.class) {
                if (instance == null) {
                    // 1. 分配对象空间
                    // 2. 初始化对象
                    // 3. 设置引用指向刚分配的内存地址
                    instance = new LazyDoubleCheckSingleton();
                }
            }
        }

        return instance;
    }
}
