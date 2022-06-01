package com.medititation;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.medititation.Basic_Data.Category.getCategory;
import com.medititation.Basic_Data.Commodity.getCommodity;
import com.medititation.util.ImgOrByte;
import com.medititation.util.jdbc;
import jdk.internal.org.objectweb.asm.Handle;
import org.apache.http.cookie.Cookie;
import org.junit.Test;
import sun.net.www.protocol.http.Handler;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.ConsoleHandler;

/**
 * @description:
 * @author: Andy
 * @time: 2022/4/8 2:45
 */

public class test {
    @Test
    public void test1() throws IOException, SQLException {
        getCategory.getSecondary_category("https://huodong.taobao.com/wow/tbhome/act/market-list");

    }
    @Test
    public void test2() throws IOException, SQLException {
        String cookie = "lid=%E4%B9%B0%E8%A1%A3%E6%9C%8Dm%E8%A3%A4%E5%AD%9028%E9%9E%8B%E5%AD%9040; enc=8V%2FBXPPpp6KEGdFjbUew0n6bxno5l5dQa%2Bn6YhW6dC1iTAIkm9%2F4LO4rp%2Fa4AySxJx8cUUvkCGOOgSDwb1%2Bmrw%3D%3D; cna=Xj3MGp0DsBgCARsaJ51egd9I; cq=ccp%3D1; otherx=e%3D1%26p%3D*%26s%3D0%26c%3D0%26f%3D0%26g%3D0%26t%3D0; sm4=421000; _m_h5_tk=91400ad519825f18a05b1273db249bd3_1649705772171; _m_h5_tk_enc=383e8517bb340319918c8dc77cf03ea8; ariaReadtype=1; ariaStatus=false; xlly_s=1; sgcookie=E100abyONuvysEpHKCNT2JtSzcIE8stTG1qqOL6GQa35%2BJCTOH9GPhR%2F9ZUOku5GvqBMPYDhUdBUIqZVGWt%2FSEOdaKuq%2FpC64Ozqv1YxdWrHn4VoikGV3kNRXpNShjzYEmBh; t=fc45d03fcb2ca9a36d5b6fb8daaaaed4; _tb_token_=feeaf1ed15b6b; cookie2=21f5faebdd42852244d8824878b92c4d; OZ_SI_2061=sTime=1649868061&sIndex=1; OZ_1U_2061=vid=v245fddb522e17.0&ctime=1649868061&ltime=1649770923; OZ_1Y_2061=erefer=https%3A//s.taobao.com/&eurl=https%3A//detail.tmall.com/item.htm%3Fspm%3Da230r.1.14.16.35c56e78RxjxC3%26id%3D658702154398%26ns%3D1%26abbucket%3D17&etime=1649868061&ctime=1649868061&ltime=1649770923&compid=2061; pnm_cku822=098%23E1hv5QvUvbpvUvCkvvvvvjiWR2c90jnVnLFOsjrCPmPwzjl8RFswsji2R2zhgjiE29hvCvvvMMGvvpvVvvpvvhCvKvhv8vvvvvCvpvvvvvm2phCv28OvvUnvphvpgvvv96CvpCCvvvm2phCvhhmUvpvVmvvC9cDvuvhvmvvv9hCFrzwFmvhvLvm22vvjX%2B0x9W9OjLEc6acEKBmAVAdOaNoxdX31bbknIOZtIoYbDpcBIb8rwZElibmxdX3gENoxfwpfd5tvD7zhz8g7EcqU1jc6%2Bu6gvpvhvvvvv8OCvvpvvUmm; tfstk=cppRB04tLmER63SvbQhDYZFag8TRZbudlu_3ppL0kRfatiydiv9MBRJKNM_NymC..; l=eBEUufyrLY1KcEDQBOfwourza77OSIRA_uPzaNbMiOCPOLfw5WMhW62PfNLeC3GVh6dJR35gV60wBeYBcnjRCSBNa6Fy_Ckmn; isg=BHBwpWp35iXZuLoyVEyxXA8MQTjCuVQDgHPEHmrBPEueJRDPEskkk8YXeS1Fsgzb";
        String UA="Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/100.0.4896.88 Safari/537.36";
        getCommodity.getCommditys(cookie,UA);

    }
    @Test
    public void test3() throws IOException, SQLException {
        String arr = "var a={\n" +
                "        startTime        : +new Date,\n" +
                "        ver              : '8.0.33',\n" +
                "        st               : '',\n" +
                "        online           : true,\n" +
                "        shopVer          : 2,\n" +
                "        appId            : 1 ,\n" +
                "        itemId           : '637145790668',\n" +
                "        \n" +
                "        shopId           : '143694441',\n" +
                "        shopName         : '\\u5C0F\\u751C\\u5D3Dsweet',\n" +
                "        sellerId         : '2136510393',\n" +
                "        sellerNick       : '风子挪',\n" +
                "        sibUrl           : '//detailskip.taobao.com/service/getData/1/p1/item/detail/sib" +
                ".htm?itemId=637145790668&sellerId=2136510393&modules=dynStock,qrcode,viewer,price,duty,xmpPromotion," +
                "delivery,activity,fqg,zjys,couponActivity,soldQuantity,page,originalPrice,tradeContract',  \n" +
                "        descUrl          : location.protocol==='http:' ? '//dscnew.taobao" +
                ".com/i7/630/140/637145790668/TB1T2Dh8XY7gK0jSZKz8quikpla" +
                ".desc%7Cvar%5Edesc%3Bsign%5E07cc92d1d7c0065c07a894d777bcb573%3Blang%5Egbk%3Bt%5E1649821474' : " +
                "'//descnew.taobao.com/i7/630/140/637145790668/TB1T2Dh8XY7gK0jSZKz8quikpla" +
                ".desc%7Cvar%5Edesc%3Bsign%5E07cc92d1d7c0065c07a894d777bcb573%3Blang%5Egbk%3Bt%5E1649821474',  \n" +
                "        counterApi       : '//count.taobao" +
                ".com/counter3?inc=ICVT_7_637145790668&sign=579039e9e2e096ba241d82517942a71312f5&keys" +
                "=DFX_200_1_637145790668,ICVT_7_637145790668,ICCP_1_637145790668,SCCP_2_143694441',\n" +
                "        rateCounterApi   : '//rate.taobao.com/detailCount.do?itemId=637145790668',\n" +
                "        areaPrice        : false,\n" +
                "        \n" +
                "        lazyload         : '#J_DivItemDesc',\n" +
                "        \n" +
                "        tadComponetCdn   : true,\n" +
                "        delayInsurance   : false,\n" +
                "        fuwubao          : false,\n" +
                "        \n" +
                "        cdn              : true,\n" +
                "        sibFirst         : true,\n" +
                "        \n" +
                "        webp             : true,\n" +
                "        descWebP         : false,\n" +
                "        \n" +
                "        newDomain        : true,\n" +
                "        asyncStock       : true,\n" +
                "        enable           : true,\n" +
                "        \n" +
                "        m_ratio          : 20,\n" +
                "        \n" +
                "        beacon           : {},\n" +
                "        DyBase           : {\n" +
                "            iurl : '//item.taobao.com',\n" +
                "            purl : '//paimai.taobao.com',\n" +
                "            durl : '//siteadmin.taobao.com',\n" +
                "            lgurl: 'https://login.taobao.com/member/login.jhtml',\n" +
                "            surl : '//upload.taobao.com',\n" +
                "            suitUrl: '//jubao.taobao.com/index.htm?&spm=a1z6q.7847058&itemId='\n" +
                "        },\n" +
                "        idata            : {\n" +
                "            item: {\n" +
                "                id               : '637145790668',\n" +
                "                title            : '\\u3010\\u60C5\\u4FA3\\u6B3E\\u3011\\u751C\\u4EFD\\u8D85\\u6807" +
                "*\\u5DE8\\u8212\\u670D\\u60C5\\u4FA3\\u5185\\u88E4 \\u590F\\u5B63\\u7537\\u5973\\u53CB\\u793C\\u7269" +
                " \\u4E03\\u5915\\u9001\\u670B\\u53CB',\n" +
                "                pic              : '//gd1.alicdn" +
                ".com/imgextra/i1/2136510393/O1CN01mfAn5q1Em2P2u9DTW_!!2136510393-0-picasso.jpg',\n" +
                "                price            : '',\n" +
                "                status           : 0,\n" +
                "                descVersion      : '',\n" +
                "                sellerNick       : '风子挪',\n" +
                "                sellerNickGBK    : '%E9%A3%8E%E5%AD%90%E6%8C%AA',\n" +
                "                skuComponentFirst: 'true',\n" +
                "                \n" +
                "                rcid             : '1625',\n" +
                "                cid              : '201778401',\n" +
                "                virtQuantity     : '',\n" +
                "                holdQuantity     : '',\n" +
                "                \n" +
                "                quickAdd         : 1,\n" +
                "                \n" +
                "                edit             : true, \n" +
                "                initSizeJs:true,\n" +
                "                \n" +
                "                \n" +
                "                sizeGroupName:\"中国码(女)\",\n" +
                "                auto: '',\n" +
                "                \n" +
                "                bnow             : true,\n" +
                "                chong: false,\n" +
                "                \n" +
                "                dbst             : 1625048049000,\n" +
                "                stepdata         : {\n" +
                "                    \n" +
                "                },\n" +
                "                xjcc: false,\n" +
                "                \n" +
                "                type             : 'ifashion',\n" +
                "                customHeader     : false,\n" +
                "                \n" +
                "                disableAddToCart  : !true,\n" +
                "                \n" +
                "                auctionImages    : [\"//gd2.alicdn" +
                ".com/imgextra/i1/2136510393/O1CN01mfAn5q1Em2P2u9DTW_!!2136510393-0-picasso.jpg\",\"//gd1.alicdn" +
                ".com/imgextra/i1/2136510393/O1CN01CwlpmE1Em2JTZsZDd_!!2136510393.jpg\",\"//gd4.alicdn" +
                ".com/imgextra/i4/2136510393/O1CN01xXCT7v1Em2JLecvt5_!!2136510393.jpg\",\"//gd3.alicdn" +
                ".com/imgextra/i3/2136510393/O1CN01yhFuVh1Em2JR4t8m7_!!2136510393.jpg\",\"//gd1.alicdn" +
                ".com/imgextra/i1/2136510393/O1CN01mQ71d01Em2JNsg2hd_!!2136510393.jpg\",\"//gd1.alicdn" +
                ".com/imgextra/i1/2136510393/O1CN01osKdPK1Em2P1RqwSz_!!2136510393-0-picasso.jpg\"]\n" +
                "                \n" +
                "            },\n" +
                "            seller: {\n" +
                "                id          : '2136510393',\n" +
                "                mode        : 0,\n" +
                "                shopAge     : '4'\n" +
                "                ,status      : 0\n" +
                "                ,goldSeller  : true\n" +
                "                \n" +
                "                ,goldPeriods  : 8\n" +
                "                \n" +
                "            },\n" +
                "            shop  : {\n" +
                "            \n" +
                "                id  : '143694441',\n" +
                "                url : '//shop143694441.taobao.com/'\n" +
                "                \n" +
                "                ,pid: 1202738464\n" +
                "                \n" +
                "                ,sid: 4\n" +
                "                \n" +
                "                ,xshop: true\n" +
                "                \n" +
                "                ,instId: 355225321\n" +
                "                \n" +
                "            \n" +
                "            }\n" +
                "        },\n" +
                "        vdata :{\n" +
                "        }\n" +
                "        \n" +
                "    }\n";
        System.out.println(arr);
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine javascript = scriptEngineManager.getEngineByName("javascript");
        try {
            Object eval = javascript.eval("JSON.stringify(\'" + arr + "\')");
            System.out.println(eval);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        ObjectMapper mapper = new ObjectMapper();
    }

    @Test
    public void test4(){
        ImgOrByte.getImgByte("https://img.alicdn.com/imgextra/i4/196993935/O1CN01GToMXR1ewHGd6J09A_!!196993935.jpg");
    }



}
