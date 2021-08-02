package demo.generic;

/**
 * User: BigStrong
 * Date: 2021/7/17
 * Description: No Description
 */
public class GenericDemo {

    public static <E> void printArray(E[] inputArray) {
        for (E element : inputArray) {
            System.out.printf("%s", element);
            System.out.printf(" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] integers = {1,2,3,4,5};
        Double[] doubles = {1.1,2.1,3.1,4.1,5.1};
        String[] strings = {"a", "b"};

        printArray(integers);
        printArray(doubles);
        printArray(strings);
    }
}
