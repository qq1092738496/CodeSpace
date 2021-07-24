import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * @description:
 * @author: Andy
 * @time: 2021/7/17 0:37
 */

public class text {
    public static void main(String[] args) {
        convetor(new File("F:\\927026377"));
    }

    public static void convetor(File path) {


        File[] files = path.listFiles();
        String name = null;
        File video = null;
        File audio = null;
        for (int i = files.length-1 ;i > 0;i--) {
            System.out.println(files[i]);
            if (files[i].getName().equals("entry.json")) {
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(files[i]));
                    char[] chars = new char[(int) files[i].length()];
                    int count = 0;
                    while ((count = reader.read(chars)) != -1) {
                    }
                    reader.close();
                    /*chars.toString(); 不明白为什么，toString转换，会为空。 1. chars 读取io内部机制，没弄懂。  2.两种转换纯在区别。 待研究IO流 */

                    String entry = String.valueOf(chars);
                    ObjectMapper mapper = new ObjectMapper();
                    JsonNode jsonNode = mapper.readTree(entry);
                    JsonNode page_data = jsonNode.findValue("page_data");
                    String part = page_data.findValue("part").toString();
                    name = page_data.findValue("page").toString() + "." + part.substring(1, part.length() - 1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println(name);
            if (files[i].isDirectory()) {
                convetor(files[i]);
            }
        }
    }
}
