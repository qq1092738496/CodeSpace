import com.sun.xml.internal.bind.v2.model.core.MapPropertyInfo;
import sun.nio.cs.ext.GBK;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class BufferedIO {
    public static void main(String[] args) throws Exception {
        //对haha.txt文本进行顺序排列
        /*BufferedReader reader = new BufferedReader(new FileReader("src/haha.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/heihei.txt"));
        HashMap<String,String > map = new HashMap<String, String>();
        String len = null;
        while ((len = reader.readLine()) != null){
           String[] arr =  len.split("\\.");
            map.put(arr[0],arr[1]);
        }

        for (int j = 1 ; j <= map.keySet().size();j++){
            System.out.println(map.get(j + ""));
           writer.write(j+"."+map.get(j+""));
           writer.write("\r\n");
        }
        reader.close();
        writer.close();*/

        //缓冲字节输入流 BufferedInputStream
        BufferedInputStream binpyt = new BufferedInputStream(new FileInputStream("src/haha.txt"));
        byte[] bytes = new byte[30];
        binpyt.read(bytes);
        System.out.println(new String(bytes));
        binpyt.close();

        //缓冲字节输出流 BufferedOutputStream
        BufferedOutputStream outputStream  = new BufferedOutputStream(new FileOutputStream("src/haha.txt",true));
        outputStream.write("请问请问请问请问请问".getBytes());
        outputStream.close();

        //缓冲字符输入流 BufferedReader
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("E://IOTest/hellowrod.txt"), "GBK");
        BufferedReader reader = new BufferedReader(inputStreamReader);
        char[] chars = new char[30];
        reader.read(chars);
        System.out.println(new String(chars));
        reader.close();

        //缓冲字符输出流,BufferedWriter
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("E://IOTest/hellowrod.txt",true),"GBK");
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        char[] chars1 = new char[]{'我','为','了','其','寻'};
        bufferedWriter.write(chars1);
        bufferedWriter.close();

    }
}
