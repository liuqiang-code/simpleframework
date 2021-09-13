package demo.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * User: BigStrong
 * Date: 2021/9/13
 * Description: No Description
 */
public class IOUtilTest1 {
    public static void main(String[] args) throws IOException {
        IOUtil.copyFile("demo.txt");
    }
}
