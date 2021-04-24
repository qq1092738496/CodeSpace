import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import util.HttpUtils;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class test {
    public static void main(String[] args) {

        try {


            String url1 = "https://huaban.com/discovery/beauty/";
            String Cookie = "_uab_collina=158721133804312101917499; __auc=028e18f41718d2b03364a7d6e0a; _ga=GA1.2.1308956527.1587212199; _hmt=1; sid=s%3AMxS_GKRq7lWeR97JXbZaVOgnPDNo1FZE.s8XcbUCCrj6xHrMw%2BvFwcwp9hSQ0PgVmdvI0IQ%2F2vws; uid=17564807; _f=iVBORw0KGgoAAAANSUhEUgAAADIAAAAUCAYAAADPym6aAAACh0lEQVRYR%2B2WP2hTURSHv5MOQlsqDhZB2oLFwago2LQUh7wqSFEpOFiwYBU0kwgOghXUQcFEcKg4SUQ0QgQVhC4WsTYPhFLj4KBVkIhakOI%2FUDSDYo7cZxJimrwkNVHUZrrJ%2Fb2T893zO%2Bc%2BQVVx%2B4iI6%2F5v2hx%2BP%2ByapxiQ%2BmSScCDgpHQ4GORqfz%2BJ9nYC4TDJhgZXEIV6IAyMCVyoFVdZIObP%2Fbbt5GD7%2FT%2BtKaMiCiuAVQLX5kFKnEBFFYlZVjZc7%2Bgog5EIA9HoHmAEuAQcTAtuAm3AJLAVWAwcAQbyfsvXmefXAL0ZncDbcqpYEUi%2BtV43NzPl9fYbyyhsBx4KPFYIAYfykt4mcFLBb%2BII2CV02Xh%2FBAToBhLpRPcDV9IVcXokAwK0l9BVH6TY1BoKhXjZ2mrs05U%2BtVOAsUss5xSjwGngRtpu5rsZgb4CuhlgPbAbuGhAjVYgWaoqZVuraKAyplapJKqxPw%2BSPcV%2FuSJqT25AJQLSBOxD2IXSadZi%2BS7nW0lj9x%2BBekGmxOpYWcxqbrp8a%2FlfLeNZ0zumGz844ZxXlLm8a2ns3nGQtWL5%2Bpy1epqkp%2BPAbAhHt0Us3zq147dJ8Vx6fHsr1WVAWj4tZNP0cufxWy1PqwDiVMVzAkkdJVXXh6Q%2BitV5bHaC8RHQB2YvF75SXW5FDEz3TBsTS178OohJRO34XZRzmMtSUsPi77rjnmB8J7BZLN%2BOSnW1BRmPn0doBj4XSs6Bjf0NFYmZE9Yg6rleqD9%2BgFS3R0zMGljL9EndWdBQoWmVsY%2FT5MrGzNRSp5Lai%2Bhgrh3ddGdWT4xlIEyzN35dwBfPN8aXJniy6M3cp1Y1butKYvw3N%2Ft3wkXZKCKdKrkAAAAASUVORK5CYII%3D%2CWin32.1536.864.24; Hm_lvt_d4a0e7c3cd16eb58a65472f40e7ee543=1587290536,1587301301,1587302997,1587365271; Hm_lpvt_d4a0e7c3cd16eb58a65472f40e7ee543=1587378076; __asc=6480d34f171971b39737a607d68";

            HttpUtils httpUtils = new HttpUtils();
            int i = 1;
            String  j = null;
            String url = httpUtils.dourl(j, "40", i);
            while (i <= 10){
            Map<String, String> map = httpUtils.httpdoget(url, Cookie);
            String id = httpUtils.download(map);
            i++;
            j=id;
            }




        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
