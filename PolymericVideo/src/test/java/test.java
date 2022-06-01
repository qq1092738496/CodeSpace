import SourceVideo.SourceVideo;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.Videodao;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import pojo.VideoPaging;
import service.VideoService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Andy
 * @time: 2021/8/23 6:31
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationcontext.xml"})
@WebAppConfiguration
public class test {

    @Autowired
    Videodao videodao;
    @Autowired
    VideoService videoService;

    @Test
    public void test() {
        VideoPaging videopage = videoService.Videopage(1, 5);
        ObjectMapper mapper = new ObjectMapper();

    }

    @Test
    public void test2() {
        //jackson学习
        //创建json串

    }

    @Test
    public void test3() {
        SourceVideo video = new SourceVideo();
        video.start("http://dianying.im/pianku-dianying--------1---/");
    }

    @Test
    public void test4() {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("https://s.taobao.com/search?q=%E5%B0%8F%E5%90%83&imgfile=&commend=all&ssid=s5" +
                "-e&search_type=item&sourceId=tb.index&spm=a21bo.21814703.201856-taobao-item" +
                ".1&ie=utf8&initiative_id=tbindexz_20170306");
        httpGet.setHeader("cookie", "cna=seKrGWfXlhYCARsaFfjE9Bys; t=42576787ae65dd71c1a0775cd0e2ac4c; " +
                "lgc=%5Cu4E70%5Cu8863%5Cu670Dm%5Cu88E4%5Cu5B5028%5Cu978B%5Cu5B5040; " +
                "tracknick=%5Cu4E70%5Cu8863%5Cu670Dm%5Cu88E4%5Cu5B5028%5Cu978B%5Cu5B5040; " +
                "_m_h5_tk=81f65a485cdfce2d5110cbeb25730e8e_1631257832673; " +
                "_m_h5_tk_enc=113f79aae219c50388a473274bf9da2e; thw=cn; cookie2=1d86c153a5a42ae2613afdff59472e2e; " +
                "xlly_s=1; _samesite_flag_=true; unb=2456556960; cancelledSubSites=empty; _l_g_=Ug%3D%3D; " +
                "sgcookie=E100Ou4%2FCdJjJKdAZ1kgeOAPL5guhOng3elyjwdcKuLLu0Ex6cLAn7" +
                "%2Bp7xy7cfMlAt6Ur9Qz51fJSbTHsNDXy3CTZjcrImxd9sYuPfQFcZAcR18%3D; " +
                "uc3=nk2=ocyHq5xpaRLIFMCzbxslw4WTVA%3D%3D&id2=UUwVYuJNAmMjoA%3D%3D&lg2=U%2BGCWk%2F75gdr5Q%3D%3D&vt3" +
                "=F8dCujCxpxkVsbxSLdU%3D; csg=d78e7c5e; cookie17=UUwVYuJNAmMjoA%3D%3D; " +
                "dnk=%5Cu4E70%5Cu8863%5Cu670Dm%5Cu88E4%5Cu5B5028%5Cu978B%5Cu5B5040; skt=dce695093046cdd3; " +
                "existShop=MTYzMTI0OTU3NQ%3D%3D; uc4=nk4=0%40o4Sndj5tqzTPn3WdeDkMukSxDly0qU5vD%2F6AdwLW&id4=0" +
                "%40U27KDqGYfnQyPIDe1Eyy0UvMugT0; _cc_=Vq8l%2BKCLiw%3D%3D; sg=004; " +
                "_nk_=%5Cu4E70%5Cu8863%5Cu670Dm%5Cu88E4%5Cu5B5028%5Cu978B%5Cu5B5040; " +
                "cookie1=WqOgzKlhlwpLU6Da2gx%2B4Trf5YxemgN%2Ft3cSthDo8cc%3D; _tb_token_=7e170de331705; " +
                "enc=qsr3g8s6rOxdm8%2F3LJYJ0d1dIavBTUhnWaHfc8IMZ20TLfCbzCMmd9SfLPmLRh3uzgk397NvY14%2Br4zEG1qexQ%3D" +
                "%3D; mt=ci=41_1; hng=CN%7Czh-CN%7CCNY%7C156; lLtC1_=1; miid=330198040510516420; alitrackid=www" +
                ".taobao.com; lastalitrackid=www.taobao.com; " +
                "uc1=pas=0&cookie15=V32FPkk%2Fw0dUvg%3D%3D&cookie16=Vq8l%2BKCLySLZMFWHxqs8fwqnEw%3D%3D&existShop" +
                "=false&cookie14=Uoe3dtPHZSf8rA%3D%3D&cookie21=UIHiLt3xSixwH1aenGUFEQ%3D%3D; " +
                "JSESSIONID=C4040C023B4CE87BA86B048FFAFD999A; " +
                "tfstk=cBONBQTilfhwEfCje11q1TIcRSfOZ4TMoW75Ip35QaRmGaXGiIZA-djN8Zs-tOf..; " +
                "l=eBrypOx4gMx2FDo9BOfZnurza77OSIRAjuPzaNbMiOCPO_5p5dXfW63we8T9C3GVh6H9R3SW3fIXBeYBqQOSnxv92j-la_kmn;" +
                " isg=BN7eZM5DMzOKC2fVqGCl2uNtL3Qgn6IZ7BSxc4hnSiEcq36F8C_yKQRLo7ensJox");
        try {
            CloseableHttpResponse execute = httpclient.execute(httpGet);
            HttpEntity entity = execute.getEntity();
            String s = EntityUtils.toString(entity);
            System.out.println(s);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test5() {
       /* 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。

        请你将两个数相加，并以相同形式返回一个表示和的链表。

        你可以假设除了数字 0 之外，这两个数都不会以 0 开头。*/
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] b = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < a.length; i++) {
            list.add(a[i]+b[i]);

            
        }

        
        Integer[] objects = (Integer[])list.toArray();

    }

    @Test
    public void test6(){
        boolean i = true;
        while (i){
            i=false;
        }
    }
}
