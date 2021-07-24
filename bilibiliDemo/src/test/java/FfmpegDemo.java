import java.io.*;

public class FfmpegDemo {

    // FFmpeg全路径
    private static final String FFMPEG_PATH = "D:\\FFMPEG\\ffmpeg-latest-win64-static\\bin\\ffmpeg.exe";

    public static void main(String[] args) {
        try {
            String videoInputPath = "D:\\ceshi\\demo2.mp4";
            String audioInputPath = "D:\\ceshi\\说好不哭.mp3";
            String videoOutPath = "D:\\ceshi\\666\\6啊.avi";
//            File f = new File("D:\\ceshi\\红色高跟鞋.mp3");
//            File f2 = new File("D:\\ceshi\\红色高跟鞋3.mp3");
//            cut(f,f2);
            convetor(videoInputPath,audioInputPath,videoOutPath);
            System.out.println("音频合成成功，老铁666");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 具体合成视频函数
     * @param videoInputPath
     *   原视频的全路径
     * @param audioInputPath
     *   音频的全路径
     * @param videoOutPath
     *   视频与音频结合之后的视频的路径
     */
    public static void convetor(String videoInputPath, String audioInputPath, String videoOutPath)
            throws Exception {
        Process process = null;
        InputStream errorStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader br = null;
        try {
            // ffmpeg命令
            String command = FFMPEG_PATH + " -i " + videoInputPath +
                    " -i " + audioInputPath
                    + " -c:v copy -c:a aac -strict experimental " +
                    " -map 0:v:0 -map 1:a:0 " +
                    " -t 15.0"    //生成视频时间为15s
                    + " -y " + videoOutPath;

            process = Runtime.getRuntime().exec(command);
            errorStream = process.getErrorStream();
            inputStreamReader = new InputStreamReader(errorStream);
            br = new BufferedReader(inputStreamReader);
            // 用来收集错误信息的
            String str = "";
            while ((str = br.readLine()) != null) {
                System.out.println(str);
            }
            process.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                br.close();
            }
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            if (errorStream != null) {
                errorStream.close();
            }
        }
    }
}