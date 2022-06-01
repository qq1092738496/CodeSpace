package com.medititation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @author: Andy
 * @time: 2022/4/14 1:01
 */

public class jsonTest {
    @Test
    public void test1() {
        CloseableHttpClient client = HttpClients.createDefault();
        String json = "{\"valItemInfo\":{\"skuList\":[{\"names\":\"黑色 \",\"pvs\":\"1627207:28341\"," +
                "\"skuId\":\"4745324202865\"},{\"names\":\"军绿色 \",\"pvs\":\"1627207:3232483\"," +
                "\"skuId\":\"4745324202872\"},{\"names\":\"粉红色 \",\"pvs\":\"1627207:3232480\"," +
                "\"skuId\":\"4604018664598\"},{\"names\":\"深灰色 \",\"pvs\":\"1627207:3232478\"," +
                "\"skuId\":\"4715336708627\"},{\"names\":\"白色 \",\"pvs\":\"1627207:28320\"," +
                "\"skuId\":\"4589824532861\"},{\"names\":\"巧克力色 \",\"pvs\":\"1627207:3232481\"," +
                "\"skuId\":\"4715336708628\"},{\"names\":\"绿色 \",\"pvs\":\"1627207:28335\"," +
                "\"skuId\":\"4762863770175\"},{\"names\":\"紫色 \",\"pvs\":\"1627207:28329\"," +
                "\"skuId\":\"4745324202861\"},{\"names\":\"蓝色 \",\"pvs\":\"1627207:28338\"," +
                "\"skuId\":\"4600121881368\"},{\"names\":\"天蓝色 \",\"pvs\":\"1627207:3.232484\"," +
                "\"skuId\":\"4781346971046\"},{\"names\":\"透明 \",\"pvs\":\"1627207:107121\"," +
                "\"skuId\":\"4781346971044\"},{\"names\":\"浅绿色 \",\"pvs\":\"1627207:30156\"," +
                "\"skuId\":\"4781346971045\"},{\"names\":\"黄色 \",\"pvs\":\"1627207:28324\"," +
                "\"skuId\":\"4745324202858\"},{\"names\":\"浅灰色 \",\"pvs\":\"1627207:28332\"," +
                "\"skuId\":\"4745324202862\"},{\"names\":\"深蓝色 \",\"pvs\":\"1627207:28340\"," +
                "\"skuId\":\"4745324202864\"},{\"names\":\"花色 \",\"pvs\":\"1627207:130164\"," +
                "\"skuId\":\"4600121881367\"},{\"names\":\"红色 \",\"pvs\":\"1627207:28326\"," +
                "\"skuId\":\"4745324202859\"},{\"names\":\"桔色 \",\"pvs\":\"1627207:90554\"," +
                "\"skuId\":\"4745324202876\"},{\"names\":\"褐色 \",\"pvs\":\"1627207:132069\"," +
                "\"skuId\":\"4745324202856\"},{\"names\":\"深卡其布色 \",\"pvs\":\"1627207:3232482\"," +
                "\"skuId\":\"4762863770177\"},{\"names\":\"酒红色 \",\"pvs\":\"1627207:28327\"," +
                "\"skuId\":\"4745324202860\"},{\"names\":\"浅黄色 \",\"pvs\":\"1627207:60092\"," +
                "\"skuId\":\"4745324202874\"},{\"names\":\"深紫色 \",\"pvs\":\"1627207:3232479\"," +
                "\"skuId\":\"4607642065565\"},{\"names\":\"紫罗兰 \",\"pvs\":\"1627207:80882\"," +
                "\"skuId\":\"4768127456254\"}],\"defSelected\":[],\"skuMap\":{\";1627207:28335;" +
                "\":{\"priceCent\":8800,\"price\":\"88.00\",\"stock\":310,\"skuId\":\"4762863770175\"},\";" +
                "1627207:28324;\":{\"priceCent\":2380,\"price\":\"23.80\",\"stock\":722,\"skuId\":\"4745324202858\"}," +
                "\";1627207:28326;\":{\"priceCent\":3300,\"price\":\"33.00\",\"stock\":242," +
                "\"skuId\":\"4745324202859\"},\";1627207:28341;\":{\"priceCent\":1980,\"price\":\"19.80\"," +
                "\"stock\":3936,\"skuId\":\"4745324202865\"},\";1627207:28320;\":{\"priceCent\":6600,\"price\":\"66" +
                ".00\",\"stock\":621,\"skuId\":\"4589824532861\"},\";1627207:80882;\":{\"priceCent\":2560," +
                "\"price\":\"25.60\",\"stock\":570,\"skuId\":\"4768127456254\"},\";1627207:28332;" +
                "\":{\"priceCent\":3580,\"price\":\"35.80\",\"stock\":360,\"skuId\":\"4745324202862\"},\";" +
                "1627207:60092;\":{\"priceCent\":3280,\"price\":\"32.80\",\"stock\":567,\"skuId\":\"4745324202874\"}," +
                "\";1627207:3232479;\":{\"priceCent\":1280,\"price\":\"12.80\",\"stock\":352," +
                "\"skuId\":\"4607642065565\"},\";1627207:3232478;\":{\"priceCent\":3350,\"price\":\"33.50\"," +
                "\"stock\":363,\"skuId\":\"4715336708627\"},\";1627207:28340;\":{\"priceCent\":6800,\"price\":\"68" +
                ".00\",\"stock\":240,\"skuId\":\"4745324202864\"},\";1627207:132069;\":{\"priceCent\":8100," +
                "\"price\":\"81.00\",\"stock\":80,\"skuId\":\"4745324202856\"},\";1627207:3232484;" +
                "\":{\"priceCent\":3000,\"price\":\"30.00\",\"stock\":1598,\"skuId\":\"4781346971046\"},\";" +
                "1627207:3232482;\":{\"priceCent\":4700,\"price\":\"47.00\",\"stock\":722," +
                "\"skuId\":\"4762863770177\"},\";1627207:3232483;\":{\"priceCent\":3000,\"price\":\"30.00\"," +
                "\"stock\":1597,\"skuId\":\"4745324202872\"},\";1627207:90554;\":{\"priceCent\":5900,\"price\":\"59" +
                ".00\",\"stock\":121,\"skuId\":\"4745324202876\"},\";1627207:3232480;\":{\"priceCent\":3280," +
                "\"price\":\"32.80\",\"stock\":1241,\"skuId\":\"4604018664598\"},\";1627207:3232481;" +
                "\":{\"priceCent\":5380,\"price\":\"53.80\",\"stock\":182,\"skuId\":\"4715336708628\"},\";" +
                "1627207:130164;\":{\"priceCent\":6600,\"price\":\"66.00\",\"stock\":180," +
                "\"skuId\":\"4600121881367\"},\";1627207:107121;\":{\"priceCent\":6600,\"price\":\"66.00\"," +
                "\"stock\":1417,\"skuId\":\"4781346971044\"},\";1627207:30156;\":{\"priceCent\":1980,\"price\":\"19" +
                ".80\",\"stock\":5670,\"skuId\":\"4781346971045\"},\";1627207:28338;\":{\"priceCent\":6600," +
                "\"price\":\"66.00\",\"stock\":984,\"skuId\":\"4600121881368\"},\";1627207:28327;" +
                "\":{\"priceCent\":3280,\"price\":\"32.80\",\"stock\":298,\"skuId\":\"4745324202860\"},\";" +
                "1627207:28329;\":{\"priceCent\":5280,\"price\":\"52.80\",\"stock\":1312," +
                "\"skuId\":\"4745324202861\"}},\"salesProp\":{}},\"valLoginIndicator\":\"//buy.taobao.com/auction/buy" +
                ".htm?from=itemDetail&id=561456882226\",\"isShowSizeRecommend\":false,\"isDoubleElevenItem\":true," +
                "\"isHouseholdService\":false,\"isSevenDaysRefundment\":true,\"apiBidCount\":\"//tbskip.taobao" +
                ".com/json/show_bid_count.htm?itemNumId=561456882226&old_quantity=107019&date=1649726260000\"," +
                "\"valTimeLeft\":486930,\"standingDate\":0,\"tradeParams\":{},\"api\":{\"descUrl\":\"//itemcdn.tmall" +
                ".com/desc/icoss400393179931228e4fa8aaf44e?var=desc\",\"httpsDescUrl\":\"//itemcdn.tmall" +
                ".com/desc/icoss400393179931228e4fa8aaf44e?var=desc\",\"fetchDcUrl\":\"//hdc1new.taobao.com/asyn" +
                ".htm?pageId=1571432006&userId=2711008903\"},\"tag\":{\"isShowMeiliXinde\":false,\"isMedical\":false," +
                "\"isRightRecommend\":true,\"isShowEcityIcon\":false,\"isShowYuanchuanIcon\":false," +
                "\"isBrandAttr\":true,\"isShowTryReport\":false,\"isAsynDesc\":true,\"isBrandSiteRightColumn\":true," +
                "\"isShowHouseIcon\":false},\"isService\":true,\"isTripUser\":false,\"cmCatId\":\"0\"," +
                "\"cartEnable\":true,\"renderSystemServer\":\"//render.taobao.com\",\"carCascade\":false," +
                "\"isWTContract\":false,\"isOnlyInMobile\":false,\"isAreaSell\":true,\"isMultiPoint\":false," +
                "\"isShowSizeHelper\":false,\"isMeiz\":false,\"newSelectCityApi\":\"//mdskip.taobao" +
                ".com/json/detailSelectCity.do?isAreaSell=true&itemId=561456882226\"," +
                "\"initCspuExtraApi\":\"//ext-mdskip.taobao.com/extension/initCspuExtra.htm\"," +
                "\"detail\":{\"isMemberShopItem\":false,\"isBundleItem\":false,\"canEditInItemDet\":true," +
                "\"isAllowReport\":true,\"isHiddenShopAction\":false,\"isDownShelf\":false,\"is0YuanBuy\":false," +
                "\"isCarService\":false,\"isShowEcityBasicSign\":false,\"isItemAllowSellerView\":true," +
                "\"goNewAuctionFlow\":false,\"isShowEcityVerticalSign\":true,\"reviewListType\":1," +
                "\"rxShowTitle\":\"本品为处方药，请在医师指导下使用。\",\"isVaccine\":false,\"isHasPos\":false," +
                "\"recommendBigMarkDownEndTime\":\"1477880000000\",\"isAutoYushou\":false,\"isOnePriceCar\":false," +
                "\"isVitual3C\":false,\"rxIcon\":\"https://gw.alicdn.com/tfs/TB13T_zHHrpK1RjSZTEXXcWAVXa-216-84" +
                ".png\",\"isFullCarSell\":false,\"isHideAttentionBtn\":false,\"isNABundleItem\":false," +
                "\"double11StartTime\":\"\",\"showDiscountRecommend\":false,\"enableAliMedicalComponent\":true," +
                "\"isOtcDrug\":false,\"isYYZY\":false,\"mlhNewDesc\":false,\"isMainLiaoSku\":false," +
                "\"isHkMilk\":false,\"isEnableAppleSku\":true,\"isHkItem\":false,\"isShowContentModuleTitle\":false," +
                "\"isRx2Count\":true,\"isHiddenNonBuyprice\":false,\"isH5NewLogin\":true,\"isHkO2OItem\":false," +
                "\"isSavingEnergy\":false,\"showFushiPoiInfo\":false,\"defaultItemPrice\":\"12.80 - 88.00\"," +
                "\"globalSellItem\":false,\"isShowEcityDesc\":false,\"isSkuColorShow\":false,\"autoccUser\":false," +
                "\"isMenDianInventroy\":false,\"isMeilihui\":false,\"isLadderGroupon\":false,\"isHidePoi\":false," +
                "\"isNewAttraction\":true,\"isPreSellBrand\":false,\"loginBeforeCart\":false," +
                "\"isAutoFinancing\":false,\"showSuperMarketBuy\":false,\"isPrescriptionDrug\":false," +
                "\"isHasQualification\":false,\"recommendBigMarkDownStartTime\":\"1478793600000\"," +
                "\"pageType\":\"default\",\"isIFCShop\":false,\"isAlicomMasterCard\":false,\"isCarCascade\":false," +
                "\"isDianQiMeiJia\":false,\"isSkuMemorized\":false,\"addressLevel\":3,\"isRx2\":false," +
                "\"isTeMai\":false,\"allowRate\":true,\"isShowPreClosed\":false,\"isO2OStaging\":false," +
                "\"isPurchaseMallVipBuyer\":false,\"cdn75\":false,\"isNewMedical\":false,\"isCarYuEBao\":false," +
                "\"isAliHouse\":false,\"isCyclePurchase\":false,\"isChineseMedicinalMaterial\":false," +
                "\"isAliTelecomNew\":false,\"show9sVideo\":true,\"isHkDirectSale\":false,\"isTspace\":false," +
                "\"tryReportDisable\":false,\"isB2Byao\":false,\"isRegionLevel\":true,\"isContractPhoneItem\":false," +
                "\"isYY\":false,\"supermarketAndQianggou\":false,\"isZhengChe\":false,\"isDianZiMendian\":false," +
                "\"isNextDayService\":false,\"timeKillAuction\":false},\"apiAddCart\":\"//cart.taobao" +
                ".com/add_cart_item.htm?item_id=561456882226\",\"apiBeans\":\"//count.taobao" +
                ".com/counter3?keys=SM_368_dsr-2711008903,ICCP_1_561456882226\",\"idsMod\":[],\"initApi\":\"//mdskip" +
                ".taobao.com/core/initItemDetail.htm?isUseInventoryCenter=false&cartEnable=true&service3C=true" +
                "&isApparel=false&isSecKill=false&tmallBuySupport=true&isAreaSell=true&tryBeforeBuy=false&offlineShop" +
                "=false&itemId=561456882226&showShopProm=false&isPurchaseMallPage=false&itemGmtModified=1649843876000" +
                "&isRegionLevel=true&household=false&sellerPreview=false&queryMemberRight=true&addressLevel=3" +
                "&isForbidBuyItem=false\",\"valPointTimes\":1.0,\"changeLocationApi\":\"//mdskip.taobao" +
                ".com/core/changeLocation.htm?isUseInventoryCenter=false&cartEnable=true&sellerUserTag3" +
                "=144185556820066432&service3C=true&sellerUserTag2=18018933994946560&isSecKill=false&isAreaSell=true" +
                "&sellerUserTag4=1152921504608961923&offlineShop=false&itemId=561456882226&sellerUserTag=34672672" +
                "&showShopProm=false&tgTag=false&isPurchaseMallPage=false&isRegionLevel=true&household=false" +
                "&notAllowOriginPrice=false&addressLevel=3\",\"isTmallComboSupport\":false,\"serviceIconList\":[]," +
                "\"valPointRate\":0.1,\"tradeType\":2,\"valMode\":128,\"initExtraApi\":\"//ext-mdskip.taobao" +
                ".com/extension/initExtra.htm\",\"itemDO\":{\"isInRepository\":false,\"isSupportTryBeforeBuy\":false," +
                "\"reservePrice\":\"19.80\",\"imgVedioPic\":\"https://img.alicdn" +
                ".com/imgextra/i4/2711008903/O1CN0123053w2FdctEDNoRO_!!2711008903.jpg\"," +
                "\"isSecondKillFromMobile\":false,\"cspuCategorySwitch\":false,\"isOnline\":true," +
                "\"title\":\"乐普升修正带210米大容量涂改带改正带学生用实惠装改错带小学生专用修改带改字带乐普生官方旗舰店文具批发\",\"isEnterprisePath\":false," +
                "\"showCompanyPurchase\":false,\"isDcAsyn\":true,\"feature\":\"1\",\"attachImgUrl\":[]," +
                "\"isElecCouponItem\":false,\"brandSiteId\":\"0\",\"brandSpecialSold\":\"false\"," +
                "\"sellerNickName\":\"%E8%8B%8F%E5%85%8B%E5%8A%9E%E5%85%AC%E4%B8%93%E8%90%A5%E5%BA%97\"," +
                "\"isSecondKillFromPC\":false,\"auctionType\":\"b\",\"encryptSellerId\":\"UvCcYvFNWOmkWvWTT\"," +
                "\"prov\":\"广东\",\"brand\":\"LPS/乐普升\",\"imgVedioUrl\":\"//cloud.video.taobao" +
                ".com/play/u/2711008903/p/1/e/1/t/8/308400482510.swf\",\"isDefaultChooseTryBeforeBuy\":false," +
                "\"quantity\":23685,\"isBidden\":false,\"hasSku\":true,\"isNewProGroup\":false,\"weight\":\"0\"," +
                "\"imgVedioID\":\"308400482510\",\"userId\":\"2711008903\",\"rootCatId\":\"50018004\"," +
                "\"itemId\":\"561456882226\",\"validatorUrl\":\"//store.taobao.com/tadget/shop_stats.htm\"," +
                "\"isCustomizedItem\":false,\"auctionStatus\":\"0\",\"isSecondKillFromPCAndWap\":false," +
                "\"brandId\":\"77012007\",\"sellProgressiveRate\":\"3_100_1.60;6_0_4.50;9_0_6.00\"," +
                "\"spuId\":\"274004854\",\"categoryId\":\"121466019\"},\"rateConfig\":{\"itemId\":561456882226," +
                "\"sellerId\":2711008903,\"rateScoreCacheDisable\":false,\"rateSubjectDisable\":false," +
                "\"tryReportDisable\":false,\"rateScoreDisable\":false,\"rateEnable\":true,\"spuId\":274004854," +
                "\"rateNewChartDisable\":false,\"listType\":1,\"rateCloudDisable\":false},\"rstShopId\":142752747," +
                "\"propertyPics\":{\";1627207:28324;\":[\"//img.alicdn" +
                ".com/imgextra/i4/2711008903/O1CN01TbtRXU2Fdco0JpAKT_!!2711008903.jpg\"],\";1627207:28326;\":[\"//img" +
                ".alicdn.com/imgextra/i1/2711008903/O1CN01Gq26dS2FdclmvYPYQ_!!2711008903.jpg\"],\";1627207:80882;" +
                "\":[\"//img.alicdn.com/imgextra/i3/2711008903/O1CN01xsCSYP2FdctcjfmbK_!!2711008903.jpg\"],\";" +
                "1627207:28320;\":[\"//img.alicdn.com/imgextra/i1/2711008903/O1CN01ko4ocT2FdcqyGkyjU_!!2711008903" +
                ".jpg\"],\";1627207:28332;\":[\"//img.alicdn" +
                ".com/imgextra/i4/2711008903/O1CN01DS7ZLd2FdcnwbARah_!!2711008903.jpg\"],\";1627207:60092;\":[\"//img" +
                ".alicdn.com/imgextra/i3/2711008903/O1CN01vIBHPD2FdcphGQgUl_!!2711008903.jpg\"],\";1627207:3232479;" +
                "\":[\"//img.alicdn.com/imgextra/i4/2711008903/O1CN01NyIXVt2FdcqLe9h7R_!!2711008903.jpg\"],\";" +
                "1627207:28340;\":[\"//img.alicdn.com/imgextra/i3/2711008903/O1CN01W4Z9eE2Fdco2BLbrO_!!2711008903" +
                ".jpg\"],\";1627207:132069;\":[\"//img.alicdn" +
                ".com/imgextra/i2/2711008903/O1CN01uWolWO2FdclonfJOI_!!2711008903.jpg\"],\";1627207:3232483;" +
                "\":[\"//img.alicdn.com/imgextra/i4/2711008903/O1CN01vSutXW2FdcqOgT636_!!2711008903.jpg\"]," +
                "\"default\":[\"//img.alicdn.com/imgextra/https://img.alicdn" +
                ".com/imgextra/i4/2711008903/O1CN0123053w2FdctEDNoRO_!!2711008903.jpg\",\"//img.alicdn" +
                ".com/imgextra/https://img.alicdn.com/imgextra/i1/2711008903/O1CN01Su0CTS2Fdcqonri4k_!!2711008903" +
                ".jpg\",\"//img.alicdn.com/imgextra/https://img.alicdn" +
                ".com/imgextra/i2/2711008903/O1CN01wLHbn42FdcqkP5b4G_!!2711008903.jpg\",\"//img.alicdn" +
                ".com/imgextra/https://img.alicdn.com/imgextra/i3/2711008903/O1CN01XJnbZ22FdcqjhKHue_!!2711008903" +
                ".jpg\",\"//img.alicdn.com/imgextra/https://img.alicdn" +
                ".com/imgextra/i3/2711008903/O1CN01RNnxAH2FdcqmcPJoQ_!!2711008903.jpg\"],\";1627207:3232481;" +
                "\":[\"//img.alicdn.com/imgextra/i4/2711008903/O1CN01Fbqt4e2FdcsCyaxhL_!!2711008903.jpg\"],\";" +
                "1627207:130164;\":[\"//img.alicdn.com/imgextra/i1/2711008903/O1CN01bd6hdZ2FdcqCqkVpc_!!2711008903" +
                ".jpg\"],\";1627207:107121;\":[\"//img.alicdn" +
                ".com/imgextra/i1/2711008903/O1CN01AYVyEX2FdcqQiP4sL_!!2711008903.jpg\"],\";1627207:28338;\":[\"//img" +
                ".alicdn.com/imgextra/i3/2711008903/O1CN01PglXBK2FdcqIO5Emc_!!2711008903.jpg\"],\";1627207:28335;" +
                "\":[\"//img.alicdn.com/imgextra/i1/2711008903/O1CN01G4V4eH2Fdcqyz6GgR_!!2711008903.jpg\"],\";" +
                "1627207:28341;\":[\"//img.alicdn.com/imgextra/i4/2711008903/O1CN01Hod7HT2FdcqM4ktaa_!!2711008903" +
                ".jpg\"],\";1627207:3232478;\":[\"//img.alicdn" +
                ".com/imgextra/i3/2711008903/O1CN01KwSqxO2FdcsIsP83r_!!2711008903.jpg\"],\";1627207:3232484;" +
                "\":[\"//img.alicdn.com/imgextra/i1/2711008903/O1CN01SHgCQ82FdcqHnqb1q_!!2711008903.jpg\"],\";" +
                "1627207:3232482;\":[\"//img.alicdn.com/imgextra/i3/2711008903/O1CN01ANwFz02Fdcso1YYNR_!!2711008903" +
                ".jpg\"],\";1627207:90554;\":[\"//img.alicdn" +
                ".com/imgextra/i4/2711008903/O1CN015ysh8R2Fdclk6Sy1I_!!2711008903.jpg\"],\";1627207:3232480;" +
                "\":[\"//img.alicdn.com/imgextra/i3/2711008903/O1CN01MwnnIZ2FdcqXXq1Pb_!!2711008903.jpg\"],\";" +
                "1627207:30156;\":[\"//img.alicdn.com/imgextra/i2/2711008903/O1CN01zv2M172FdcqMX1C1J_!!2711008903" +
                ".jpg\"],\";1627207:28327;\":[\"//img.alicdn" +
                ".com/imgextra/i1/2711008903/O1CN01d3LMZI2FdcpfIhyR5_!!2711008903.jpg\"],\";1627207:28329;\":[\"//img" +
                ".alicdn.com/imgextra/i1/2711008903/O1CN017eXpb62FdcqKwRJMf_!!2711008903.jpg\"]},\"tmallRateType\":0," +
                "\"selectRegionApi\":\"//mdskip.taobao.com/core/selectRegion" +
                ".do?isAreaSell=true&itemId=561456882226\",\"apiItemViews\":\"//count.taobao" +
                ".com/counter2?keys=ICVT_7_561456882226&inc=ICVT_7_561456882226&sign" +
                "=9598304f6edbe0c9841f4e8e4aa7c3d3ea3\",\"tagsId\":\"120321,123905,139778,166402,2049,249858,119298," +
                "287745,470018,502786,508418,365570,2059,1547,1478146,1479682,1502210,1799170,1649154,1666562," +
                "1692162,1977858,1987074,1993730,2032642,2057730,2065922,1902082,1955330,2105346,2131458,2133506," +
                "2140162,89665,91713,36417,212546,241218,49218,235585,137281,141889,393794,404546,266817,491074," +
                "281666,4166,368706,386114,2635,1611,11339,1739842,1763394,1624130,1666626,1982018,2007618,2021442," +
                "2042946,2067010,1895490,1902658,2111042,2127938,2187842,91777,115329,22145,39553,51329,200321," +
                "264321,286337,508546,522882,268418,284290,1163,22155,1286274,1456258,1434754,1712770,1721474," +
                "1817218,1602178,1624706,1702530,1993858,2016386,2043010,2058370,2067074,2072194,2096770,1902210," +
                "2097794,2123906,2128514,2158210,2181762,2183298,84673,108225,28353,37569,243906,57026,25282,28866," +
                "200897,508610,299202,386242,3787,4811,5323,7371,7883,23755,1240770,1562306,1709250,1829058,1624770," +
                "1660610,1991874,1998018,2038978,2057410,2057922,2096834,1842882,1913026,1916610,2102466,2128578," +
                "2132674,2157762,2208450,120577,166658,203521,112386,173313,192769,398594,484098,508674,8454,11015," +
                "368386,388354,391426,542466,1803,7947,1286402,1481986,1391874,1713410,1733890,1781506,1784066," +
                "1823490,1627906,1693954,2039042,2057474,2074882,1846530,1886466,1902338,1904386,2102018,2185986," +
                "2205442,84801,70465,87361,108865,122177,24385,200002,241985,255297,107842,116546,141121,368962," +
                "381762,540482,843,1867,11083,19787,27979,1301314,1474370,1522498,1352514,1389890,1441090,1765698," +
                "1823554,1607490,1619266,1648962,1660738,2008386,2057538,1835330,1839426,1876290,1900354,1902402," +
                "2131266,2188098,2193730,2201410,95105,73089,87425,106881,112001,143746,53121,82306,101762,145793," +
                "191873,441218,444802,297858,299394,3974,7046,11143,348546,349570,776578,2443,4491,1478530,1502082," +
                "1520514,1376642,1769346,1771394,1797506,1581442,1620354,1693570,1967490,1974658,1992066,2008450," +
                "2054018,2057602,2075010,1875842,1902466,2121090,2170242,2188162,67521,82369,33217,40897,21442," +
                "217025,245697,260033,119234,113602,155073,159169,328641,332225,303553,504258,299458,302530,1478," +
                "360386,364482,531906,4555,1483,2507,11723,1254338,1310146,1478082,1497538,1362370,1666498,1691586," +
                "2008514,2027970,2057666,1930178,1959874,2106818,2119618,2136514,2163138\"," +
                "\"url\":{\"tbskip\":\"//tbskip.taobao.com\",\"mdskip\":\"//mdskip.taobao.com\"," +
                "\"tradeForOldTmallBuy\":\"//stay.buy.tmall.com/order/confirm_order.htm\"," +
                "\"tgDetailDomain\":\"//detail.ju.taobao.com\",\"detailServer\":\"//detail.taobao.com\"," +
                "\"buyBase\":\"//buy.taobao.com/auction\",\"mallList\":\"//list.tmall.com\"," +
                "\"extMdskip\":\"//ext-mdskip.taobao.com\",\"xCrossServer\":\"//mdetail.tmall.com\"," +
                "\"tgDomain\":\"//ju.taobao.com\",\"rate\":\"//rate.tmall.com\",\"tradeBaseUrl\":\"//trade.taobao" +
                ".com/trade\",\"topUploadServerBaseUrl\":\"//upload.taobao.com\"," +
                "\"BIDRedirectionitemDomain\":\"//paimai.taobao.com\"},\"tradeConfig\":{\"1\":\"//buy.taobao" +
                ".com/auction/buy_now.jhtml\",\"2\":\"//buy.tmall.com/order/confirm_order.htm\",\"3\":\"//obuy.tmall" +
                ".com/home/order/confirm_order.htm\",\"4\":\"\",\"7\":\"//tw.taobao.com/buy/auction/buy_now.jhtml\"}," +
                "\"valCartInfo\":{\"itemId\":\"561456882226\",\"cartUrl\":\"//cart.taobao.com/my_cart" +
                ".htm?from=bdetail\",\"statsUrl\":\"//go.mmstat.com/1.gif?logtype=2&category=cart_{loc}_121466019\"}," +
                "\"isAliTripHK\":false,\"selectCityApi\":\"//mdskip.taobao.com/core/selectCity" +
                ".htm?isAreaSell=true&itemId=561456882226\",\"getProgressiveInfoApi\":\"//mdskip.taobao" +
                ".com/core/getProgressiveInfo.do?platform_type=b2c&fromTryBeforeBuy=false&sellerId=2711008903" +
                "&platform=tmall&category=121466019&sellerPercent=3_100_1.60;6_0_4.50;9_0_6.00\"}";
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = null;

        try {
            jsonNode = mapper.readValue(json, JsonNode.class);



            //详情页 list
            String s = jsonNode.get("api").get("descUrl").asText();
            HttpGet httpGet = new HttpGet("https:" + s);
            String html = EntityUtils.toString(client.execute(httpGet).getEntity());
            Document parse = Jsoup.parse(html);
            LinkedList<String> list = new LinkedList<String>();

            for (Element element : parse.select("html > body > p img[src]")) {
                list.add(element.attr("src"));
            }
            System.out.println(list);

            //关键字标题
            System.out.println(jsonNode.get("itemDO").get("title").asText());

            //发货地址
            System.out.println(jsonNode.get("itemDO").get("prov").asText());


        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
