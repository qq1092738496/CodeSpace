import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.io.*;

public class IOStudi {

    public static void main(String[] args) {
        File file = new File("D://");
        ww(file);

        /*File file = new File("D://迅雷下载");
        File[] ff  = file.listFiles();
        for (File file1 : ff) {
            System.out.println(file1 +"文件夹:"+file1.isDirectory());

            if (file1.isDirectory()){
                File[] ff2  = file1.listFiles();
                for (File file2 : ff2) {
                    System.out.println(file1 +"文件夹:"+file2.isDirectory());
                }
            }
        }*/
        try {
           /* boolean boo1 = file.exists(); //判断文件或者目录是否存在;
            boolean boo2 = file.isDirectory();
            System.out.println(boo2?"存在":"不存在");*/

           /*String[] str = file.list();
            for (String s : str) {
                System.out.println(s);
            }*/

          /* File[] f = file.listFiles();
            for (int i = 0; i < f.length; i++) {
                System.out.println(f[i]);
            }*/
        } catch (Exception e) {
            e.printStackTrace();
        }
        //创建文件夹
        /*file.mkdirs();*/
    }

    @Test
    public static void rr(File dir){
         File[] str = dir.listFiles();
        for (int i1 = 0; i1 < str.length; i1++) {
            System.out.println(str[i1]);
            boolean bool = str[i1].isDirectory();
            System.out.println("路径:"+str[i1]+"      是否是文件夹:"+bool);

            if (bool){
                    rr(str[i1]);
            }
        }
    }
    @Test
    public static void ww(File dir){
        File[] str =  dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname.getName().startsWith("&")|| pathname.getName().endsWith("&")){
                    return false;
                }
                return false;
            }
        });
        int q = 0;
        for (int i1 = 0; i1 < str.length; i1++) {
            System.out.println(str[i1]);
            boolean bool = str[i1].isDirectory();
            q++;
           // System.out.println("路径:"+str[i1]+"      是否是文件夹:"+bool +"调用次数:"+q);
            if (bool ||  !"System Volume Information ".equals(str[i1].getName()) ){
                ww(str[i1]);
            }

        }
    }
}
