package com.fun.api.web.controller;

import com.fun.client.domain.GoodsInfo;
import com.fun.client.domain.GoodsOrderInfo;
import com.fun.client.domain.MemUserInfo;
import com.fun.client.service.GoodsInfoService;
import com.fun.client.service.GoodsOrderInfoService;
import com.fun.client.service.MemUserInfoService;
import com.fun.framework.domain.AjaxReturn;
import com.fun.framework.web.controller.BaseController;
import com.fun.framework.web.dto.QueryDto;
import com.fun.le.entities.FinCapitalLog;
import com.fun.le.service.FinCapitalLogService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/api")
public class IndexController extends BaseController {
    private @Autowired
    MemUserInfoService memUserInfoService;
    private @Autowired
    FinCapitalLogService finCapitalLogService;
    private @Autowired
    GoodsOrderInfoService goodsOrderInfoService;
    private @Autowired
    GoodsInfoService goodsInfoService;

    @ApiIgnore
    // @Secure(has = {"le:sys:overview"})
    @RequestMapping(path = {"index-info"}, method = {RequestMethod.POST})
    public AjaxReturn indexInfo(QueryDto queryDto) {
        if (queryDto.getBeginDate() == null) {
            queryDto.setBeginDate(new DateTime().withTime(0, 0, 0, 0).toDate());
        }
        if (queryDto.getEndDate() == null) {
            queryDto.setEndDate(new DateTime().withTime(23, 59, 59, 999).toDate());
        }
        if (queryDto.getBeginDate() != null) {
            queryDto.setBeginDate(new DateTime(queryDto.getBeginDate()).withTime(0, 0, 0, 0).toDate());
        }
        if (queryDto.getEndDate() != null) {
            queryDto.setEndDate(new DateTime(queryDto.getEndDate()).withTime(23, 59, 59, 999).toDate());
        }
        Map<Object, Object> map = new HashMap<>();
        List<MemUserInfo> list =  this.memUserInfoService.selectRegister(queryDto);//当日注册用户id
        int registerNum = list.size();//今日注册人数
        int registerAndPromotion = 0; //今日注册促销人数
        List<FinCapitalLog> num = this.finCapitalLogService.PromotionNum(queryDto);//促销用户
        /**
         * 注册促销
         */
        Set<String> set2 = new HashSet();
        for (int i = 0; i < list.size(); i++) {
            set2.add(list.get(i).getPkId().toString());
        }
        Set<String> set3 = new HashSet();
        for (int i = 0; i < num.size(); i++) {
            set3.add(num.get(i).getMemberId().toString());
        }
        for (String s : set2) {
            if (set3.contains(s)) {
                registerAndPromotion++;
            }
        }

        Set<FinCapitalLog> pay = this.finCapitalLogService.selectPayNum(queryDto);//当天充值用户

        List<FinCapitalLog> payCount1 = this.finCapitalLogService.selectPayCount(queryDto);

        /**
         * 今日首充
         */
        int firstPay = 0;
        QueryDto queryDto2 = new QueryDto();
        Date date = new Date();
        date.setTime(date.getTime() - 86400000);//
        queryDto2.setEndDate(new DateTime(date).withTime(0, 0, 0, 0).toDate());
        Set<FinCapitalLog> pay1 = this.finCapitalLogService.selectPayNum(queryDto2);//除今日外的充值用户
        for (FinCapitalLog pay2 : pay) {
            if (!pay1.contains(pay2)) {
                firstPay++;
            }
        }

        Set<FinCapitalLog> set = new HashSet<>();
        set.addAll(pay);
        set.removeAll(pay1);//首充用户ID
        List<FinCapitalLog> list2 = new ArrayList<>(set);
        double rechargeMoney = 0.0;//首充金额
        for (int i = 0; i < list2.size(); i++) {
            Double money = this.finCapitalLogService.selectFirstRecharge(list2.get(i).getMemberId().intValue());
            rechargeMoney += money;
        }

        int payNum = pay.size();//充值人数
        int promotionNum = num.size();//促销人数
        int payCount = payCount1.size();//充值笔数
        double rechargeCount = this.finCapitalLogService.rechargeCount(queryDto);//充值金额
        double drawMoney = this.finCapitalLogService.selectDrawMoney(queryDto);//提款金额
        double rechargeAndDraw = rechargeCount - drawMoney;//充提差额
        double betMoney = this.finCapitalLogService.betMoney(queryDto);//促销金额

        /**
         * 中奖金额=大吉大利+抢红包
         */
        double promotionWinMoney = 0.0;//大吉大利中奖金额
        double redEnvelopeMoney = 0.0;//抢红包中奖金额
        List<GoodsOrderInfo> goodsOrderInfo = this.goodsOrderInfoService.promotionWinList(queryDto);
        for (int i = 0; i < goodsOrderInfo.size(); i++) {
            GoodsInfo goodsInfo = this.goodsInfoService.selectById(goodsOrderInfo.get(i).getGoodsId());
            GoodsInfo goodsInfo1 = this.goodsInfoService.selectById(goodsInfo.getGoodSourceId());//原来商品信息
            MemUserInfo memUserInfo = this.memUserInfoService.selectById(goodsInfo1.getCreateUser());//用户
            if (memUserInfo.getAgentId() == 0) {
                promotionWinMoney += goodsInfo1.getPrice() * 1.9;
            } else {
                MemUserInfo memUserInfo1 = this.memUserInfoService.selectById(memUserInfo.getAgentId().intValue());
                promotionWinMoney += goodsInfo1.getPrice() * memUserInfo1.getExtension();
            }
        }
        List<GoodsOrderInfo> goodsOrderInfo1 = this.goodsOrderInfoService.redEnvelopeList(queryDto);
        for (int i = 0; i < goodsOrderInfo1.size(); i++) {
            GoodsInfo goodsInfo = this.goodsInfoService.selectById(goodsOrderInfo1.get(i).getGoodsId());
            GoodsInfo goodsInfo1 = this.goodsInfoService.selectById(goodsInfo.getGoodSourceId());//原来商品信息
            MemUserInfo memUserInfo = this.memUserInfoService.selectById(goodsInfo1.getCreateUser());//用户上级
            if (memUserInfo.getAgentId() == 0) {
                promotionWinMoney += goodsInfo1.getPrice() * 1.9;
            } else {
                MemUserInfo memUserInfo1 = this.memUserInfoService.selectById(memUserInfo.getAgentId().intValue());
                promotionWinMoney += goodsInfo1.getPrice() * memUserInfo1.getExtension();
            }
        }

        double winMoney = promotionWinMoney + redEnvelopeMoney;

        double profitAndLoss = Math.abs(betMoney - winMoney);
        List<FinCapitalLog> list1 = this.finCapitalLogService.drawCount(queryDto);
        int drawCount = list1.size();
        list1 = new ArrayList(new HashSet(list1));
        int drawNum = list1.size();//提款人数

        List<Object> list5 = new ArrayList();

        String[] strings = new String[4];
        strings[0] = "充值金额";
        strings[1] = "提款金额";
        strings[2] = "充提差额";
        strings[3] = "首充金额";

        Double[] ints = new Double[4];
        ints[0] = rechargeCount;
        ints[1] = drawMoney;
        ints[2] = rechargeAndDraw;
        ints[3] = rechargeMoney;

        list5.add(strings);
        list5.add(ints);

        String[] strings1 = new String[4];
        int[] ints1 = new int[4];
        List<Object> list8 = new ArrayList();

        strings1[0] = "充值人数";
        strings1[1] = "充值笔数";
        strings1[2] = "提款笔数";
        strings1[3] = "提款人数";
        ints1[0] = payNum;
        ints1[1] = payCount;
        ints1[2] = drawCount;
        ints1[3] = drawNum;
        list8.add(strings1);
        list8.add(ints1);

        List list3 = new ArrayList();

        list3.add(String.format("%.2f", winMoney));
        list3.add(String.format("%.2f", betMoney));
        list3.add(String.format("%.2f", profitAndLoss));
        map.put("map3", list3);

        map.put("payNum", payNum);
        map.put("firstPay", firstPay);
        map.put("registerNum", registerNum);
        map.put("registerAndPromotion", registerAndPromotion);
        map.put("promotionNum", promotionNum);
        map.put("map1", list8);
        map.put("map2", list5);
        //  map.put("map3", map1);
        return new AjaxReturn(200, null, map);
    }

    /*最新七条促销人数*/
    @ApiIgnore
    //   @Secure(has = {"le:sys:overview"})
    @RequestMapping(path = {"select-seven"}, method = {RequestMethod.POST})
    public AjaxReturn selectSeven() {
        List list = new ArrayList();
        List list2 = new ArrayList();
        List list3 = new ArrayList();
        int num;
        for (int i = 6; i > -1; i--) {
            Set<FinCapitalLog> set = finCapitalLogService.selectSeven(i);
            num = set.size();
            list.add(num);

            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - i);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date today = calendar.getTime();
            String result = format.format(today);
            list2.add(result);

        }
        list3.add(list);
        list3.add(list2);
        return new AjaxReturn(200, null, list3);
    }


//    /**
//     * test
//     * @param queryDto
//     * @return
//     */
//    @ApiIgnore
//    @RequestMapping(path = {"select-test"}, method = {RequestMethod.POST})
//    public AjaxReturn testYiBu(QueryDto queryDto){
//        long start = System.currentTimeMillis();
//        if (queryDto.getBeginDate() == null) {
//            queryDto.setBeginDate(new DateTime().withTime(0, 0, 0, 0).toDate());
//        }
//        if (queryDto.getEndDate() == null) {
//            queryDto.setEndDate(new DateTime().withTime(23, 59, 59, 999).toDate());
//        }
//        Map<Object, Object> map = new HashMap<>();
//        List<MemUserInfo> list = (List<MemUserInfo>) this.memUserInfoService.selectRegister(queryDto);//当日注册用户id
//        List<FinCapitalLog> num = (List<FinCapitalLog>) this.finCapitalLogService.PromotionNum(queryDto);//促销用户
//        System.out.println(System.currentTimeMillis() - start);
//        return new AjaxReturn(200,null,null);
//    }

}
