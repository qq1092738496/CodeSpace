import java.io.File;

/**
 * @description:
 * @author: Andy
 * @time: 2021/6/15 16:41
 */

public class test {

    public static void main(String[] args) {
        modify modify = new modify();
        File file = new File("F:\\Picture\\女士\\女士3-1");
        modify.modifyfile(file,"jpg");
    }
}
