package util;

import sun.text.resources.zh.CollationData_zh_TW;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @description:
 * @author: Andy
 * @time: 2022/2/2 12:59
 */

public class LogUtils {
    public static void info(String msg,Object... args){
        print(msg, "--info--", args);
    }
    public static void error(String msg,Object... args){
        print(msg, "--error--", args);
    }
    private static void print(String msg, String level, Object... args) {
        if (args != null && args.length > 0) {
             msg = String.format(msg.replace("{}", "%s"),args);
        }

        String CurrentName = Thread.currentThread().getName();
        System.out.println(LocalTime.now().format(DateTimeFormatter.ofPattern("hh:ss:mm"))+""+CurrentName +level+msg);
    }

}
