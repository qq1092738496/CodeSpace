import java.io.File;

/**
 * @description:
 * @author: Andy
 * @time: 2021/6/15 16:41
 */

public class test {

    public static void main(String[] args) {
        modify modify = new modify();
        File file = new File("F:\\Download\\FL4-1-(jpg)-notext");
        modify.modifyfile(file,"jpg");
    }
}
