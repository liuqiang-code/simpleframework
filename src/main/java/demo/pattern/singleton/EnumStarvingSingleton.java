package demo.pattern.singleton;

/**
 * User: BigStrong
 * Date: 2021/8/5
 * Description: No Description
 */
public class EnumStarvingSingleton {

    private EnumStarvingSingleton() {}

    public static EnumStarvingSingleton getInstance() {
        return ContainerHolder.HOLDER.instance;
    }

    private enum ContainerHolder {
        HOLDER;
        private EnumStarvingSingleton instance;
        ContainerHolder() {
            instance = new EnumStarvingSingleton();
        }
    }
}
