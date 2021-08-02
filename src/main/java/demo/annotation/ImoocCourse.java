package demo.annotation;

/**
 * User: BigStrong
 * Date: 2021/8/1
 * Description: No Description
 */
@CourseInfoAnnotation(courseName = "箭指Java面试", courseTag = "面试",
coureseProfile = "整理Java核心知识点")
public class ImoocCourse {

    @PersonInfoAnnotation(name = "BigStrong", language = {"java", "Python"})
    private String author;

    @CourseInfoAnnotation(courseName = "校园商铺", courseTag = "管理系统", coureseProfile = "校园商铺项目")
    public void getCourseInfo() {

    }
}
