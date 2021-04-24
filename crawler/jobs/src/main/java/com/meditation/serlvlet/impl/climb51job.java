package com.meditation.serlvlet.impl;

import com.meditation.serlvlet.climbUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Properties;
import java.util.Random;

public class climb51job implements climbUrl {
    private String Url;
    private String page;

    @Override
    public void setroot(String post, String site) {
        /*String path = this.getClass().getClassLoader().getResource("jebc.properties").getPath();
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(new File(path)));
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        String path = climb51job.class.getClassLoader().getResource("chromedriver.exe").getPath();

        System.setProperty("webdriver.chrome.driver", path);
        System.setProperty("webdriver.chrome.bin", "C:\\Program Files (x86)" +
                "\\Google\\Chrome\\Application\\chrome.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        ChromeDriver chrome = new ChromeDriver(options);
        JavascriptExecutor js = chrome;


        chrome.get("https://www.51job.com/");


        //填写搜索职位
        chrome.findElement(By.cssSelector("body div[class=\"content\"] div[class=\"in Fm\"] div[class=\"fltr radius_5\"] div[class=\"ush top_wrap\"] div[class=\"el on\"] p[class=\"ipt\"] input")).sendKeys(post);

        //点击地址
        chrome.findElement(By.cssSelector("body div[class=\"content\"] div[class=\"in Fm\"] div[class=\"fltr radius_5\"] div[class=\"ush top_wrap\"] div[class=\"el on\"] p[class=\"addbut\"] input")).click();

        //地址异步加载,加载全部
        WebElement siteul = chrome.findElement(By.xpath("//*[@id=\"work_position_click_center_left\"]"));
        List<WebElement> siteli = siteul.findElements(By.cssSelector("li"));
        try {
            Random rd = new Random();
            int rz = (rd.nextInt(5) + 1) * 300;
            Thread.sleep(rz);
            for (WebElement webElement : siteli) {
                int r = (rd.nextInt(3) + 1) * 100;
                Thread.sleep(r);
                webElement.click();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //获取城市id
        String siteid = null;
        WebElement sitediv = chrome.findElement(By.xpath("//div[@id=\"work_position_click_center_right\"]"));
        List<WebElement> sitelist = sitediv.findElements(By.cssSelector("div[class=\"work_position_click_center_right_list de d3\"]"));
        for (WebElement webElement : sitelist) {
            List<WebElement> tbody_tr_td = webElement.findElements(By.cssSelector("tbody tr td[class=\"js_more\"]"));
            for (WebElement element : tbody_tr_td) {
                //地址
                String siteadd = element.findElement(By.cssSelector("em")).getAttribute("innerHTML");
                if (siteadd.equals(site)) {
                    //地址id
                    siteid = element.findElement(By.cssSelector("em")).getAttribute("data-value");
                    break;
                }
            }
        }
        System.out.println("site:"+site+"\n"+"siteid:"+siteid);
        chrome.findElement(By.xpath("//*[@id=\"work_position_click_top\"]/a")).click();

        //调用js
        WebElement alter = chrome.findElement(By.xpath("//*[@id=\"jobarea\"]"));
        js.executeScript("document.getElementById(\"jobarea\").setAttribute(\"value\",\"" + siteid + "\")", alter);

        chrome.findElement(By.xpath("/html/body/div[3]/div/div[1]/div /button")).click();

        page =
                chrome.findElement(By.xpath("//div[@class=\"p_in\"]/span")).getText();
        System.out.println(page);

        Url = chrome.getCurrentUrl();
        System.out.println(Url);
        // chrome.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "T");
       /* Actions action = new Actions(chrome);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        action.keyDown(Keys.CONTROL).sendKeys("t").keyUp(Keys.CONTROL).perform();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        //关闭浏览器
        /*chrome.close();*/
        chrome.quit();
    }

    @Override
    public String getUrlfront() {
        String url = this.Url;
        if (url != null) {
            String[] split = url.split(",1");
            return split[0] + ",";
        }
        return "未填写参数";
    }

    @Override
    public String getUrlrear() {
        String url = this.Url;
        if (url != null) {
            String[] split = url.split(",1");
            return split[1];
        }
        return "未填写参数";
    }

    @Override
    public String getpage() {
        String page = this.page;
        if (page != null) {
            String[] split = page.split("共 ");

            String[] split1 = split[1].split(" 页");

            return split1[0];
        }
        return "未填写参数";
    }
}
