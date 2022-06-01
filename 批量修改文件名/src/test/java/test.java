import java.io.File;

/**
 * @description:
 * @author: Andy
 * @time: 2022/3/10 23:51
 */

public class test {
    public static void main(String[] args) {
        modify modify = new modify();
        File file = new File("F:\\Picture\\jared999d\\Fallen Lady1-6（堕落的女人）\\Fallen Lady 6-1\\FL6-1-JPG-notext");
        modify.modifyfileName(file,"jpg");
    }
}
