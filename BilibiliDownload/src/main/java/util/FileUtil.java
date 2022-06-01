package util;

import java.io.File;

/**
 * @description:
 * @author: Andy
 * @time: 2022/2/2 16:58
 */

public class FileUtil {
    public static long getFileContentLength(String path){
        File file = new File(path);
        return file.exists() && file.isFile() ? file.length() : 0 ;
    }
}
