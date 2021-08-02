package demo.generic;


import java.util.Random;

/**
 * User: BigStrong
 * Date: 2021/7/18
 * Description: No Description
 */
public class RobotFactory implements GenericFactory<String, Integer> {

    private String[] stringRobot = new String[]{"Hello", "Hi"};

    private Integer[] integerRobot = new Integer[]{111, 100};

    @Override
    public String nextObject() {
        Random random = new Random();
        return stringRobot[random.nextInt(2)];
    }

    @Override
    public Integer nextNumber() {
        Random random = new Random();
        return integerRobot[random.nextInt(2)];
    }

    public static void main(String[] args) {
        GenericFactory<String, Integer> genericFactory = new RobotFactory();
        System.out.println(genericFactory.nextObject());
        System.out.println(genericFactory.nextNumber());
    }
}
