import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class FfmpegDemo {


    public static void main(String[] args) {
        convetor("F:\\英语", "F:\\自学英语\\", "part");
    }

    private static String pathname;
    private static String name;

    //ffmpeg -i video.m4s -i audio.m4s -codec copy video1.mp4
    public static void convetor(String paths, String Outputpath, String jsonname) {
        File path = new File(paths);
        File[] files = path.listFiles();
        File video = null;
        File audio = null;
        for (int i = files.length - 1; i >= 0; i--) {
            //System.out.println(files[i]);
            if (files[i].getName().equals("entry.json")) {
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(files[i]));
                    char[] chars = new char[(int) files[i].length()];
                    int count = 0;
                    while ((count = reader.read(chars)) != -1) {
                    }
                    reader.close();

                    String entry = String.valueOf(chars);
                    ObjectMapper mapper = new ObjectMapper();
                    JsonNode jsonNode = mapper.readTree(entry);
                    JsonNode page_data = jsonNode.findValue("page_data");
                    String part = page_data.findValue(jsonname).toString();
                    name = part.substring(1, part.length() - 1).replace(":", ",");
                    pathname = page_data.findValue("page").toString() + "." + name;
                    System.out.println(pathname);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (files[i].getName().equals("video.m4s")) {
                video = files[i];
            }
            if (files[i].getName().equals("audio.m4s")) {
                audio = files[i];
            }
            if (null != audio && null != video) {
                if (video.getParent().equals(audio.getParent())) {
                    String content = "ffmpeg" + " -i " + video.getPath() + " -i " + audio.getPath() +
                            " -codec " +
                            "copy "
                            + Outputpath + pathname +
                            ".mp4";

                    System.out.println(content);
                    List<String> commands = new ArrayList<>();
                    commands.add("ffmpeg");
                    commands.add("-i");
                    commands.add(video.getPath());
                    commands.add("-i");
                    commands.add(audio.getPath());
                    commands.add("-codec");
                    commands.add("copy");
                    commands.add(Outputpath + pathname + ".mp4");
                    //ffmpeg -i video.m4s -i audio.m4s -codec copy video1.mp4
                    try {
                        ProcessBuilder processBuilder = new ProcessBuilder();
                        ProcessBuilder command = processBuilder.command(commands);
                        Process start = command.start();
                        sleep(5000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }

            }
            if (files[i].isDirectory()) {
                convetor(files[i].getPath(), Outputpath, jsonname);
            }
        }
    }
}