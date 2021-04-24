import org.junit.Test;

import java.io.*;
import java.util.Arrays;

public class oupt {
    public static void main(String[] args) throws IOException {
        /*OutputStream ops = new FileOutputStream("src/haha.txt",false);
        byte[] ww = "3".getBytes();*/

        //写入数据,会把十进制的数 转成二进制 存入硬盘, 任意软件 如记事本,notepat++ 等,在打开的时,把二进制字节,转成字符表示:
        //写入正整数值  如果为 0-127, 软件会查询 ASCII码表上的值 写入到文件,其他的值 则查询系统默认的表,中文系统 默认表为GBK,如果其他正整数查询不到,则会用?号,或者空表示;
        //FileOutputStream的write中的构造方法 只允许写入 整数 和 byte(字节) 类型,如果写入字符串 必须先转成字节类型,操作系统 记事本等,会将字节码对照码表还原转成字符串;
        //byte，即字节，由8位的二进制组成。在Java中，byte类型的数据是8位带符号的二进制数。
        //在计算机中，8位带符号二进制数的取值范围是[-128, 127]，所以在Java中，byte类型的取值范围也是[-128, 127]。

      /*  String dd = "你好好阿浩";
        dd.getBytes();
        byte[] aa = dd.getBytes();

        ops.write("asdsa".getBytes());
        ops.write("\r\n".getBytes());
        ops.write(aa);
        ops.close();*/
    }

    @Test
    public void Finpt() throws IOException {
        //字节输入流
       // InputStream istm = new FileInputStream("src/haha.txt");
      /*  int len = 0;
        //单个字节读取,read指针自动向下,如果向下没有数值,返回-1. 在遍历istm.read中,只需要调用一次方法即可,否则指针会连续向下
        while (istm.read()!= -1){
            System.out.println();
            System.out.println((char) istm.read());
        }*/
        //多字节读取,构造方法中给定一个字节数组, read 会将文本中的内容 自动向下指针遍历,存入字节数组内,文本中的内容默认是二进制的,转换成字节读取,所以存入的数据都是字节的;
       /* byte[] bytes = new byte[1024];
        istm.read(bytes);
        System.out.println(Arrays.toString(bytes)); //将数组内容进行遍历,以字符串表示,只是形式上以字符串表示,并未对byte数组内的字节进行转行;
        System.out.println(new String(bytes,0, 5)); //String的构造方法, 将byte数组内字节转成String类型,String(byte[],'数组启始位置','数组长度');
        istm.close();*/

        //练习题:拷贝一张图片，从一个目录到另外一个目录下(PS:是拷贝是不是移动)
        /*InputStream istm = new FileInputStream("E://wallpaper/0.jpg");
        byte[] bytes = new byte[1024*25];
        istm.read(bytes);

        OutputStream ostm = new FileOutputStream("E://0.jpg");
        ostm.write(bytes);

        istm.close();
        ostm.close();*/

        //练习题:在电脑D盘下创建一个文件为HelloWorld.txt文件，判断他是文件还是目录，在创建一个目
        //录IOTest,之后将HelloWorld.txt移动到IOTest目录下去；之后遍历IOTest这个目录下的文
        //件
        File file = new File("E://hellowrod.txt");
        file.createNewFile();
        boolean bool = file.isFile();
        if (bool){
            file.delete();
            File file1 = new File("E:/IOTest");
            file1.mkdir();



            OutputStream ostrm = new FileOutputStream("E://IOTest/hellowrod.txt");
            ostrm.write(new String("assadsd").getBytes());

            InputStream istrm = new FileInputStream("E://IOTest/hellowrod.txt");

            byte[] bytes = new byte[10];
            istrm.read(bytes);
            System.out.println(Arrays.toString(bytes));

            istrm.close();
            ostrm.close();
        }



    }



}