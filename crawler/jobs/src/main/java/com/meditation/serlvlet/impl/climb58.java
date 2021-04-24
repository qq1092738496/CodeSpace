package com.meditation.serlvlet.impl;

import com.meditation.serlvlet.climbUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;
import java.util.Set;

public class climb58 implements climbUrl {
    private String Url;
    private String page;
    @Override
    public void setroot(String post, String site) {
        String path = this.getClass().getClassLoader().getResource("jebc.properties").getPath();
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(new File(path)));
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.setProperty("webdriver.chrome.driver", properties.get("chromeDriver").toString());
        System.setProperty("webdriver.chrome.bin", properties.get("chrome").toString());
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        ChromeDriver chrome = new ChromeDriver(options);
        JavascriptExecutor js = chrome;

        chrome.get("https://jingzhou.58.com/");

        try {
            Thread.sleep(2000);
            chrome.findElement(By.xpath("//*[@id=\"commonTopbar_ipconfig\"]/a[1]")).click();
            chrome.findElement(By.xpath("//*[@id=\"selector-search-input\"]")).sendKeys(site);
            chrome.findElement(By.xpath("//*[@id=\"selector-search-btn\"]")).click();
            Thread.sleep(2000);
            chrome.findElement(By.xpath("//*[@id=\"zpNav\"]/a")).click();

            chrome.getWindowHandle();

            Thread.sleep(2000);
            ArrayList<String> windou = new ArrayList<String>(chrome.getWindowHandles());

            chrome.switchTo().window(windou.get(1));
            Thread.sleep(2000);
            chrome.findElement(By.xpath("//*[@id=\"keyword1\"]")).sendKeys(post);
            chrome.findElement(By.xpath("//*[@id=\"searJob\"]")).click();
            Url = chrome.getCurrentUrl();
            Thread.sleep(2000);

            page = chrome.findElement(By.xpath("/html/body/div[4]/div[4]/div[1]/div[2]/span[2]/input")).getAttribute("max");

            System.out.println("当前url"+Url+"当前总页数"+page);
            chrome.close();
            chrome.quit();
        } catch (Exception e) {
            e.printStackTrace();
            chrome.close();
            chrome.quit();
        }

    }

    @Override
    public String getUrlfront() {
        String Url = this.Url;
        String[] split = Url.split("\\?");

        return split[0];
    }

    @Override
    public String getUrlrear() {
        String Url = this.Url;
        String[] split = Url.split("\\?");

        return split[1];
    }

    @Override
    public String getpage() {
        String page = this.page;
        return page;
    }
}
