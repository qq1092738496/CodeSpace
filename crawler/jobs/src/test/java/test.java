import com.meditation.runjobs.Combine;
import com.meditation.serlvlet.climbUrl;
import com.meditation.serlvlet.impl.climb51job;
import com.meditation.serlvlet.impl.climb58;
import com.meditation.service.analysis51job;
import com.meditation.service.analysis58;
import com.meditation.util.mypipeline51job;
import com.meditation.util.mypipeline58;
import org.junit.Test;
import us.codecraft.webmagic.Spider;

public class test {

    @Test
    public void test1() {
        climbUrl climbUrl = new climb51job();
        climbUrl.setroot("普工", "荆州");
    }

    @Test
    public void test2() {
        Combine combine = new Combine();
        combine.addInsert("普工", "武汉", 100);
    }

    @Test
    public void test3() {
        Spider spider = new Spider(new analysis51job());
        spider.addUrl("https://search.51job.com/list/180700,000000,0000,00,9,99,%25E6%2599%25AE%25E5%25B7%25A5,2,1.html?lang=c&stype=&postchannel=0000&workyear=99&cotype=99&degreefrom=99&jobterm=99&companysize=99&providesalary=99&lonlat=0%2C0&radius=-1&ord_field=0&confirmdate=9&fromType=&dibiaoid=0&address=&line=&specialarea=00&from=&welfare=")
                .thread(100)
                .addPipeline(new mypipeline51job())
                .run();
    }

    @Test
    public void test4() {
        climbUrl climb = new climb58();
        climb.setroot("普工", "荆州");
        String urlfront = climb.getUrlfront();
        String urlrear = climb.getUrlrear();
        System.out.println(urlfront);
        System.out.println(urlrear);
    }

    @Test
    public void test5() {
        Spider spider = new Spider(new analysis58());
        spider.thread(1)
                .addPipeline(new mypipeline58())
                .addUrl("https://wh.58.com/job/?key=%E6%99%AE%E5%B7%A5&final=1&jump=1")
                .run();
    }

    @Test
    public void test6() {
        Combine combine = new Combine();
        combine.addInsert("普工", "武汉", 50);
    }

    @Test
    public void test7() {
        analysis58 analysis58 = new analysis58();
        Spider spider = new Spider(new analysis58());
        Spider spider1 = new Spider(new analysis51job());
        try {
            Thread thread = new Thread(() -> spider.thread(1).addUrl("//jingzhou.58.com/job/").run());
            Thread thread1 = new Thread(() -> spider1.thread(1).addUrl("https://search.51job.com/list/180700,000000,0000,00,9,99,%25E6%2599%25AE%25E5%25B7%25A5,2,1.html?lang=c&stype=&postchannel=0000&workyear=99&cotype=99&degreefrom=99&jobterm=99&companysize=99&providesalary=99&lonlat=0%2C0&radius=-1&ord_field=0&confirmdate=9&fromType=&dibiaoid=0&address=&line=&specialarea=00&from=&welfare=").run());
            thread.start();
            thread1.start();

            Thread thread2 = new Thread(thread);
            Thread thread3 = new Thread(thread1);
            thread2.start();
            thread3.start();
        } catch (Exception e) {

        }
    }
}
