package demo.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * User: BigStrong
 * Date: 2021/9/13
 * Description: IO 工具类
 */
public class IOUtil {

    /**
     * 读取指定文件内容，按照16进制输出到控制台
     * 并且每10个字节进行换行
     * @param fileNmae
     */
    public static void printHex(String fileNmae) throws IOException {

        // 把文件作为字节流进行读操作
        FileInputStream in = new FileInputStream(fileNmae);

        int b;
        int i = 1;

        while((b = in.read()) != -1) {
            System.out.print(Integer.toHexString(b) + "  ");
            if (i ++ % 10 == 0) {
                System.out.println();
            }
        }

        in.close();
    }

    public static void printByteArrays(String fileName) throws IOException {

        FileInputStream in = new FileInputStream(fileName);

        byte[] buf = new byte[8];

        int b;
        int j = 1;

        while ((b = in.read(buf, 0, buf.length)) != -1) {
            for (int i = 0; i < b; i ++) {
                System.out.print(Integer.toHexString(buf[i]) + "  ");
                if (j ++ % 10 == 0) {
                    System.out.println();
                }
            }
        }
    }

    /**
     * copy file
     * @param fileName
     * @throws IOException
     */
    public static void copyFile(String fileName) throws IOException {

        FileInputStream in = new FileInputStream(fileName);

        FileOutputStream out = new FileOutputStream(fileName + "1");

        byte[] buff = new byte[10 * 1024];

        int b;

        while ((b = in.read(buff, 0, buff.length)) != -1) {
            out.write(buff, 0, b);
            out.flush();
        }

        in.close();
        out.close();
    }
}
