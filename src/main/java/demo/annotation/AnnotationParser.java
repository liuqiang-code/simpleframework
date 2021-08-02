package demo.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * User: BigStrong
 * Date: 2021/8/1
 * Description: No Description
 */
public class AnnotationParser {

    // 解析类注解
    public static void parseTpyeAnnotation() throws ClassNotFoundException {

        Class clazz = Class.forName("demo.annotation.ImoocCourse");

        // 获取类的注解
        Annotation[] annotations = clazz.getAnnotations();

        for (Annotation annotation : annotations) {
            CourseInfoAnnotation courseInfoAnnotation = (CourseInfoAnnotation) annotation;
            System.out.println("课程名:" + courseInfoAnnotation.courseName() + "\n" +
                    "课程标签:" + courseInfoAnnotation.courseTag() + "\n" +
                    "课程简介:" + courseInfoAnnotation.coureseProfile() + "\n" +
                    "课程序号:" + courseInfoAnnotation.coureseIndex());
        }
    }

    // 解析成员变量上的标签
    public static void parseFieldAnnotation() throws ClassNotFoundException {

        Class clazz = Class.forName("demo.annotation.ImoocCourse");

        Field[] declaredFields = clazz.getDeclaredFields();

        for (Field field: declaredFields) {
            // 判断是否存在指定的注解
            if (field.isAnnotationPresent(PersonInfoAnnotation.class)) {

                PersonInfoAnnotation annotation = field.getAnnotation(PersonInfoAnnotation.class);

                System.out.println("名字:" + annotation.name() + "\n" +
                        "年龄:" + annotation.age() + "\n" +
                        "性别:" + annotation.gender() + "\n");

                for (String language : annotation.language()) {
                    System.out.println("擅长的语言:" + language);
                }
            }
        }
    }

    // 解析方法上的注解
    public static void parseMenthodAnnotation() throws ClassNotFoundException {

        Class clazz = Class.forName("demo.annotation.ImoocCourse");

        Method[] declaredMethods = clazz.getDeclaredMethods();

        for (Method declaredMethod : declaredMethods) {
            if (declaredMethod.isAnnotationPresent(CourseInfoAnnotation.class)) {

                CourseInfoAnnotation annotation = declaredMethod.getAnnotation(CourseInfoAnnotation.class);

                System.out.printf("课程名称:" + annotation.courseName() + "\n" +
                        "课程标签:" + annotation.courseTag() + "\n" +
                        "课程详情:" + annotation.coureseProfile());
            }
        }

    }

    public static void main(String[] args) throws ClassNotFoundException {
        parseMenthodAnnotation();
    }
}
