package demo.reflect;

/**
 * User: BigStrong
 * Date: 2021/7/31
 * Description: No Description
 */
public class ReflectTarget extends ReflectTargetOrigin{
    // 构造函数
    ReflectTarget(String str) {
        System.out.println("默认的构造函数" + str);
    }

    ReflectTarget() {
        System.out.println("调用了无参构造方法");
    }

    public ReflectTarget(char name) {
        System.out.println("调用了带有一个参数的构造方法，参数值为：" + name);
    }

    public ReflectTarget(char name, int index) {
        System.out.println("调用了带有多个参数的构造方法，参数值为【目标名】" + name + "【索引名】" + index);
    }

    protected ReflectTarget(Boolean n) {
        System.out.println("受保护的构造方法" + n);
    }

    private ReflectTarget(int index) {
        System.out.println("私有的构造方法 序号:" + index);
    }

    // 字段
    public String name;
    protected int index;
    char type;
    private String targetInfo;

    @Override
    public String toString() {
        return "ReflectTarget[name=" +this.name + ", index=" + this.index + ",type=" + this.type
                + ",targetInfo=" + this.targetInfo;
    }

    // 成员方法
    public void show1() {
        System.out.printf("public 调用了show1");
    }

    protected void show2() {
        System.out.println("protected 调用了show2");
    }

    void show3() {
        System.out.println("default 调用了show3");
    }

    private String show4() {
        System.out.println("private 调用了show4");
        return "show4, -------";
    }

    public static void main(String[] args) throws ClassNotFoundException {
        // 通过对象的getClass方法获取class
        ReflectTarget reflectTarget = new ReflectTarget();
        Class a = reflectTarget.getClass();
        System.out.println(a.getName());
        // 通过类的.class属性获取class
        Class b = ReflectTarget.class;
        System.out.println(b.getName());
        // 使用Class.forName获取class
        Class c = Class.forName("demo.reflect.ReflectTarget");
        System.out.println(c.getName());
        System.out.println(a == b);
        System.out.println(b == c);
    }
}
