
import sun.nio.cs.ext.GBK;

import java.io.*;
import java.util.Arrays;

public class IoReader {
    public static void main(String[] args) throws IOException {

        //都有此方式转换编码
    /*    OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("E://IOTest/hellowrod.txt",true),"GBK");

        OutputStreamWriter writer = new FileWriter("E://IOTest/hellowrod.txt",true);
        char[] chars = new char[]{'我','最','帅'};
        writer.write(chars);
        writer.flush();

        writer.close();
*/
        /*Idea编译器的编码格式如果是utf-8则与windos系统GBK编码格式不符合,中文编码组成规则不同,inputStreamReader 是读取字节 并将其解码为字符.
         它使的字符集可以由名称或者指定显示给定, 或者接受编译器或系统平台默认的字符集;*/
         InputStreamReader Frde = new InputStreamReader(new FileInputStream("E://IOTest/hellowrod.txt"),"GBK");


       /* InputStreamReader Frde = new FileReader("E://IOTest/hellowrod.txt");

        char[] chars = new char[20];
        Frde.read(chars);

        System.out.println(Arrays.toString(chars));
        Frde.close();*/


     /*  InputStream istem = new FileInputStream("E://IOTest/hellowrod.txt");


        byte[] bytes = new byte[20];
        istem.read(bytes);
        System.out.println(Arrays.toString(bytes));

        InputStreamReader fire = new InputStreamReader(new FileInputStream("E://IOTest/hellowrod.txt"), "GBK");
        char[] chars = new char[20];
        fire.read(chars);
        System.out.println(new String(chars));*/
//  字节流在读取 中文时, GBK两个字节组成一个中文, UTF-8三个字节组成一个中文;
// 由于字节流 是单个字节读取,会将中文拆分成字节,拆分后 再将字节数组转成String 输出, 结果表示乱码;
// [-52, -20, -78, -59, -55, -39, -60, -22, -66, -51, -54, -57, -50, -46, 0, 0, 0, 0, 0, 0]
//????????????

    }
}
