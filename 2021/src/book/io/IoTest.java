package book.io;

import java.io.*;

/**
 * Description：
 *
 * @author jiaoqianjin
 * Date: 2021/11/9 10:39
 **/

public class IoTest {
    public static void main(String[] args) throws IOException {
        File file = new File("D:/test.txt");

        write(file);
        System.out.println(read(file));
    }

    public static void write(File file) throws IOException {
        OutputStream os = new FileOutputStream(file, true);

        // 要写入的字符串
        String string = "松下问童子，言师采药去。只在此山中，云深不知处。";
        // 写入文件
        os.write(string.getBytes());
        // 关闭流
        os.close();
    }

    public static String read(File file) throws IOException {
        InputStream in = new FileInputStream(file);

        // 一次性取多少个字节
        byte[] bytes = new byte[1024];
        // 用来接收读取的字节数组
        StringBuilder sb = new StringBuilder();
        // 读取到的字节数组长度，为-1时表示没有数据
        int length = 0;
        // 循环取数据
        while ((length = in.read(bytes)) != -1) {
            // 将读取的内容转换成字符串
            sb.append(new String(bytes, 0, length));
        }
        // 关闭流
        in.close();

        return sb.toString();
    }
}
