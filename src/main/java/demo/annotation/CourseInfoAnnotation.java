package demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * User: BigStrong
 * Date: 2021/8/1
 * Description: No Description
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)

public @interface CourseInfoAnnotation {
    // 课程名称
    public String courseName();

    // 课程标题
    public String courseTag();

    // 课程简介
    public String coureseProfile();

    // 课程序号
    public int coureseIndex() default 303;
}
