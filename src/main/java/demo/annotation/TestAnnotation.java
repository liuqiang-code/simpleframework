package demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * User: BigStrong
 * Date: 2021/7/31
 * Description: No Description
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)

public @interface TestAnnotation {
}
