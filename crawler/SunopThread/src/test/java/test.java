import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.FileReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Andy
 * @time: 2020/10/24 19:12
 */

public class test {
    public static void main(String[] args) throws UnsupportedEncodingException {
       /* HttpPost httpPost = new HttpPost("https://fanyi.baidu.com/langdetect");
        Map<String, String> map = new HashMap<String, String>();
        map.put("user-agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) " +
                "Chrome/85.0.4183.121 Safari/537.36");
        map.put("content-type", "application/x-www-form-urlencoded; charset=UTF-8");
        map.put("cookie", "BIDUPSID=3842DA1FC27C724006A8F04D205E8A67; PSTM=1603465649;
        BAIDUID=3842DA1FC27C72407762426478B360FF:FG=1; BDORZ=B490B5EBF6F3CD402E515D22BCDA1598; FANYI_WORD_SWITCH=1;
        REALTIME_TRANS_SWITCH=1; SOUND_SPD_SWITCH=1; HISTORY_SWITCH=1; SOUND_PREFER_SWITCH=1;
        H_PS_PSSID=32756_1443_32879_32723_32230_7516_7605_32913_22158; delPer=0; PSINO=7;
        BA_HECTOR=2l850h05ak8185ephg1fpaq7p0k; Hm_lvt_64ecd82404c51e03dc91cb9e8c025574=1603529493,1603537227,
        1603557997,1603627259; Hm_lpvt_64ecd82404c51e03dc91cb9e8c025574=1603627259; __yjsv5_shitong=1
        .0_7_a387b5d471b75fda55e532dd0000ae2e580a_300_1603627257809_27.26.21.236_1f32c5db;
        yjs_js_security_passport=2fe5dca8d1d46790dd9332f3a00be711d803b494_1603627258_js");
        map.put("origin", "https://fanyi.baidu.com");
        map.put("referer", "https://fanyi.baidu.com/?aldtype=16047");
        for (String s : map.keySet()) {
            httpPost.addHeader(s, map.get(s));
        }
        */
       /* List<BasicNameValuePair> pairs = new ArrayList<>();
        pairs.add(new BasicNameValuePair("from","zh"));
        pairs.add(new BasicNameValuePair("to","en"));
        pairs.add(new BasicNameValuePair("query","°¡°¡"));
        pairs.add(new BasicNameValuePair("transtype","translang"));
        pairs.add(new BasicNameValuePair("simple_means_flag","3"));
        pairs.add(new BasicNameValuePair("sign","384913.81056"));
        pairs.add(new BasicNameValuePair("token","08aa1193b4e64a92e879c21db0d11da1"));
        pairs.add(new BasicNameValuePair("domain","common"));
        httpPost.setEntity(new UrlEncodedFormEntity(pairs,"utf-8"));*/

        ScriptEngine script = new ScriptEngineManager().getEngineByName("javascript");
        try {
            FileReader reader = new FileReader("E:\\CodeSpace\\crawler\\SunopThread\\src\\test\\java\\haha.js");
            script.eval(reader);
            Invocable invoke = (Invocable)script;
            invoke.invokeFunction("e", "¹þ,¹þ");
        } catch (Exception e) {
            e.printStackTrace();
        }

      /*  try (CloseableHttpClient client = HttpClients.createDefault()) {
            Header[] allHeaders = httpPost.getAllHeaders();
            CloseableHttpResponse execute = client.execute(httpPost);
            HttpEntity entity = execute.getEntity();
            String string = EntityUtils.toString(entity);
            System.out.println(string);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
