import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;

/**
 * @description:
 * @author: Andy
 * @time: 2022/3/31 2:09
 */

public class test4 {
    public static void main(String[] args) {
        CloseableHttpClient Client = HttpClients.createDefault();
        HttpGet get = new HttpGet("https://detail.tmall.com/item.htm?id=667878820326");
        //<script src="https://rate.tmall.com/list_detail_rate.htm?itemId=667878820326&amp;spuId=2296288584&amp;sellerId=3586123655&amp;order=3&amp;currentPage=1&amp;append=0&amp;content=1&amp;tagId=40161003&amp;posi=-1&amp;picture=0&amp;groupId=&amp;ua=098%23E1hvUQvPvxgvUpCkvvvvvjiWR2Lwlj3PP2FOsj1VPmPp0jrmPFMhgjtbnLsUQjrWPs9Cvvpvvvvv9vhv8HgGaxTOzYswzvPI7%2F%2F%2FMbjwiDiQ4%2FEukVIUQOT3Owakg98pklDXpkk%2BvpvaZvQPvDDXvnsdAfvTExVH5a2ye8Y6BWLO1WvOeo8VvpvhvvpvvvgCvvLMMQvvkvhvC99vvOCtp89Cvv9vvUmMIwjqYd9Cvm9vvvvvphvvvvvv96CvpvsCvvm2phCvhRvvvUnvphvppvvv96CvpCCvmvhvLvFiivvj7dmxfwmK5eU%2Flw2UA2hKnpcUsW11K33ApED1lwvXeoh2%2BExrz8TJOymQD7zZditQc8c61WvfjjxX0f0DyBvOJ1kHsX7veCIvvpvVvvpvvhCvRvhvCvvvvvmevpvhvvmv9IvCv2L9cn3JUnMwznQJ3DSM7M1hzbl44Lns9weukWsVguRCoV5EsfYCW6uCoW5jADnbk8Du9iVLRvhvCvvvvvm%2BvpvEvCv%2FvyDEvhA%2B&amp;itemPropertyId=&amp;itemPropertyIndex=&amp;userPropertyId=&amp;userPropertyIndex=&amp;rateQuery=&amp;location=&amp;needFold=0&amp;_ksTS=1648753719472_1005&amp;callback=jsonp1006" async=""></script>

        get.setHeader("cookie", "lid=%E4%B9%B0%E8%A1%A3%E6%9C%8Dm%E8%A3%A4%E5%AD%9028%E9%9E%8B%E5%AD%9040; enc=8V%2FBXPPpp6KEGdFjbUew0n6bxno5l5dQa%2Bn6YhW6dC1iTAIkm9%2F4LO4rp%2Fa4AySxJx8cUUvkCGOOgSDwb1%2Bmrw%3D%3D; xlly_s=1; cna=Xj3MGp0DsBgCARsaJ51egd9I; t=2941f0e29a97c0e9d3e8b6e71bc2b44b; tracknick=%5Cu4E70%5Cu8863%5Cu670Dm%5Cu88E4%5Cu5B5028%5Cu978B%5Cu5B5040; lgc=%5Cu4E70%5Cu8863%5Cu670Dm%5Cu88E4%5Cu5B5028%5Cu978B%5Cu5B5040; _tb_token_=7db7373351b36; cookie2=2379fe1cc96d1a1bbfd614c8c823e1cf; _m_h5_tk=765eaaf266871d3adbe983fe729964c6_1648753707621; _m_h5_tk_enc=03c5c0bc28f0be6531a94796a0449c12; cq=ccp%3D1; otherx=e%3D1%26p%3D*%26s%3D0%26c%3D0%26f%3D0%26g%3D0%26t%3D0; swfstore=85529; sm4=421000; ariaDefaultTheme=default; ariaFixed=true; ariaReadtype=1; ariaStatus=false; dnk=%5Cu4E70%5Cu8863%5Cu670Dm%5Cu88E4%5Cu5B5028%5Cu978B%5Cu5B5040; uc1=cookie16=URm48syIJ1yk0MX2J7mAAEhTuw%3D%3D&cookie21=V32FPkk%2Fhodroid0QSjisQ%3D%3D&pas=0&existShop=true&cookie14=UoewCLY1QoQM5w%3D%3D&cookie15=VT5L2FSpMGV7TQ%3D%3D; uc3=vt3=F8dCvCtPHNnskDFb0s0%3D&id2=UUwVYuJNAmMjoA%3D%3D&lg2=UtASsssmOIJ0bQ%3D%3D&nk2=ocyHq5xpaRLIFMCzbxslw4WTVA%3D%3D; _l_g_=Ug%3D%3D; uc4=nk4=0%40o4Sndj5tqzTPn3WdeDkMukSxDly0qUm5IXU1rD2N&id4=0%40U27KDqGYfnQyPIDe1EvDHcTgin3N; unb=2456556960; cookie1=WqOgzKlhlwpLU6Da2gx%2B4Trf5YxemgN%2Ft3cSthDo8cc%3D; login=true; cookie17=UUwVYuJNAmMjoA%3D%3D; _nk_=%5Cu4E70%5Cu8863%5Cu670Dm%5Cu88E4%5Cu5B5028%5Cu978B%5Cu5B5040; sgcookie=E100cRWW4mTHCfkk53hbgD5hpUTLQGFysTU0ROV4FA%2F3HVgzaylmos8FzvU5x8zPoe1BMNB1DSNzEBiBIf2NPqJCj4PxiUQQDe5gApqgoHBAXk9t5usp5KNibZArrVPoWLQD; cancelledSubSites=empty; sg=004; csg=e8fe7e16; pnm_cku822=098%23E1hvTpvUvbpvUvCkvvvvvjiWR2Lwlj3PP2qw6jivPmPZljr8RsLU0jEmPsFZlj3Wi9hvCvvvpZpvvpvVvUCvpvvvuvhvmvvvpLTj9N%2BdkvhvC9hvpyPytb9Cvm9vvhCvvvvvvvvvBGwvvUhgvvCj1Qvvv3QvvhNjvvvmmvvvBGwvvvUUmvhvLUhpGNhas8TJ%2Bulz8dmxdXKK5kx%2FsjZ7%2Bu6wjLPClfy6HbUfbj7yHd8reB690f06W3vOfvDrz8TJ%2Bul1bbmxdXkK55EvAbmAdXuKNoORvpvhvv2MMs9CvvpvvhCv; tfstk=cMFfBVciHnxfEoBwgr_PgT41MrcfaA8I5ti0lRo_1wN6GMUj2sYWTDNjxRxt_V35.; l=eBEUufyrLY1KcgHCBO5Cnurza77TmIRf1lVzaNbMiInca6OFw37zlNC3NN_wkdtjgtfXRetrIuCUWdEJS0zU-E_ceTwhKXIpB2v6-; isg=BAcHYaXRKdvZJ61Xh9lOIexhlrvRDNvuU58yNdn0rxbWSCQK4d9wP4VK6ggWm7Nm");
        get.setHeader("user-agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.84 Safari/537.36");
        try {
            CloseableHttpResponse execute = Client.execute(get);
            String s = EntityUtils.toString(execute.getEntity());
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
            ////s.taobao.com/search?q=%E5%86%85%E8%A3%A4&amp;imgfile=&amp;js=1&amp;stats_click=search_radio_all%3A1&amp;initiative_id=staobaoz_20220401&amp;ie=utf8&amp;bcoffset=1&amp;ntoffset=7&amp;p4ppushleft=2%2C48&amp;data-key=s&amp;data-value=44" aria-label="第2页" data-url="pager" data-key="s" data-value="44" trace="srp_bottom_page2" data-spm-anchor-id="a230r.1.0.0">2</a>
        }

    }
}
