package demo.generic;

/**
 * User: BigStrong
 * Date: 2021/7/18
 * Description: No Description
 */
public interface GenericFactory<T, N> {
    T nextObject();
    N nextNumber();
}
