package demo.pattern.visitor;

/**
 * User: BigStrong
 * Date: 2021/8/25
 * Description: No Description
 */
public class Test {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.useComputer(new TPCInterface());
    }
}
