import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.rmi.RemoteException;

public class IoStudi2 {

    //实现IO 递归,搜索文件
    public static void main(String[] args) throws Exception {
        File file = new File("D:\\");
        seek(file,"IrisPortable.exe");
    }
    private static int j = 0 ;
    public static void seek(File url,String name)  {
        File[] file = url.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return false;
            }
        });

        try {
            for (int i = 0; i < file.length; i++) {
               // System.out.println(file[i]);
               if(file[i].exists()||!file[i].getName().equals("System Volume Information") ) {
                    if (file[i].isDirectory() ) {
                        seek(file[i], name);
                    }
                    if (file[i].getName().equals(name)) {
                        System.out.println("找到路径:" + file[i]);
                        j = 1;
                        return;
                    }
                }
            }
        } catch (NullPointerException e) {
                e.printStackTrace();
           return;
        }

    }

}
