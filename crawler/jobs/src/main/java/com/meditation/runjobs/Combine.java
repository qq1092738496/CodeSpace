package com.meditation.runjobs;

import com.meditation.serlvlet.climbUrl;
import com.meditation.serlvlet.impl.climb51job;
import com.meditation.serlvlet.impl.climb58;
import com.meditation.service.analysis51job;
import com.meditation.service.analysis58;
import com.meditation.util.mypipeline51job;
import com.meditation.util.mypipeline58;
import us.codecraft.webmagic.Spider;

public class Combine extends Thread{

    public void addInsert(String post, String site, Integer thread) {
        
      /*  climbUrl climb51job = new climb51job();
        climb51job.setroot(post, site);
        String urlfront = climb51job.getUrlfront();
        String urlrear = climb51job.getUrlrear();
        Integer getpage = Integer.valueOf(climb51job.getpage());
        for (int i = 1; i < getpage; i++) {
            Spider spider = new Spider(new analysis51job());
            String url = urlfront + i + urlrear;
            spider.addUrl(url)
                    .addPipeline(new mypipeline51job())
                    .thread(thread)
                    .run();
        }*/
        Thread thread1 = new Thread(() -> {
            climbUrl climb51job = new climb51job();
            climb51job.setroot(post, site);
            String urlfront = climb51job.getUrlfront();
            String urlrear = climb51job.getUrlrear();
            Integer getpage = Integer.valueOf(climb51job.getpage());
            for (int i = 1; i <= getpage; i++) {
                Spider spider = new Spider(new analysis51job());
                String url = urlfront + i + urlrear;
                spider.addUrl(url)
                        .addPipeline(new mypipeline51job())
                        .thread(thread)
                        .run();

            }
        });
        Thread thread2 = new Thread(() -> {
            climbUrl climb58 = new climb58();
            climb58.setroot(post, site);
            String urlfront = climb58.getUrlfront();
            String urlrear = climb58.getUrlrear();
            Integer integer = Integer.valueOf(climb58.getpage());
            for (int i = 1; i <= integer; i++) {
                Spider spider = new Spider(new analysis58());
                String url = urlfront + "pn" + i + "/?" + urlrear;
                System.out.println(url);
                spider.addPipeline(new mypipeline58())
                        .addUrl(url)
                        .thread(thread)
                        .run();

            }
        });

        thread1.run();
        //  thread2.run();

    }

}
