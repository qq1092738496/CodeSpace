import java.io.File;

/**
 * @description:
 * @author: Andy
 * @time: 2021/6/15 16:39
 */

public class modify {
    public int modifyfile (File file,String suffix){
        File[] files = file.listFiles();
        for (File name : files) {
            String path = name.getPath();
            String[] split = path.split("\\.");
            String prefix = split[0];
            name.renameTo(new File(prefix+"."+suffix));
            System.out.println("修改"+path+"成功。");
        }
        return 1;
    }
}
