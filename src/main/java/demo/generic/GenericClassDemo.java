package demo.generic;

import lombok.Data;

/**
 * User: BigStrong
 * Date: 2021/7/17
 * Description: No Description
 */
@Data
public class GenericClassDemo<T> {
    private T member;

    public GenericClassDemo(T member) {
        this.member = member;
    }

    public T handleSomething(T target) {
        return target;
    }
}
