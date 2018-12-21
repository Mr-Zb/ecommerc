package com.fun.client.controller;

import com.fun.client.domain.GoodsOrderInfo;
import com.fun.client.domain.NewPromotion;
import com.fun.client.service.ExchangeIntegralService;
import com.fun.client.service.GoodsOrderInfoService;
import com.fun.client.service.UserPlaceOrderService;
import com.fun.framework.domain.AjaxReturn;
import com.fun.framework.domain.Pagination;
import com.fun.framework.web.controller.BaseController;
import com.fun.framework.web.dto.QueryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class GoodsOrderInfoController extends BaseController {
    private @Autowired
    GoodsOrderInfoService goodsOrderInfoService;
    private @Autowired
    UserPlaceOrderService userPlaceOrderService;
    private @Autowired
    ExchangeIntegralService exchangeIntegralService;

    /**
     * 用户下单
     *
     * @param goodsId  商品ID
     * @param goodsNum 购买数量
     * @return
     * @throws Exception
     */
    @ApiIgnore
    @RequestMapping(path = {"user-place-order"}, method = {RequestMethod.POST})
    public AjaxReturn userPlaceOrder(Integer goodsId, Integer goodsNum) throws Exception {
        int userId = getAuthentication().intValue();
        String s = this.userPlaceOrderService.userPlaceOrder(userId, goodsId, goodsNum);
        if ("商品库存不足".equals(s) || "余额不足".equals(s) || "积分不足无法兑换".equals(s)||"此商品已经下架！".equals(s)) {
            return new AjaxReturn(500, s, null);
        }
        return new AjaxReturn(200, s, null);
    }

    /**
     * 红包
     *
     * @param goodsId
     * @return
     * @throws Exception
     */
    @ApiIgnore
    @RequestMapping(path = {"user-open-red-envelope"}, method = {RequestMethod.POST})
    public AjaxReturn OpenRedEnvelope(Integer goodsId) throws Exception {
        int userId = getAuthentication().intValue();
        String s = this.userPlaceOrderService.OpenRedEnvelope(userId, goodsId);
        if ("余额不足".equals(s)||"此商品已经下架！".equals(s)) {
            return new AjaxReturn(500, s, null);
        }
        return new AjaxReturn(200, s, null);
    }

    /**
     * 转为积分
     */
    @ApiIgnore
    @RequestMapping(path = {"exchange-integral-order"}, method = {RequestMethod.POST})
    public AjaxReturn exchangeIntegral(String orderNo) throws Exception {
        int userId = getAuthentication().intValue();
        return new AjaxReturn(200, this.exchangeIntegralService.exchangeIntegral(userId, orderNo), null);
    }

    @ApiIgnore
    @RequestMapping(path = {"add-goods-order-info"}, method = {RequestMethod.POST})
    public AjaxReturn add(GoodsOrderInfo goodsOrderInfo) throws Exception {
        int userId = getAuthentication().intValue();
        //int userId = 1;
        goodsOrderInfo.setCreateUser(userId);
        goodsOrderInfo.setUpdateUser(userId);
        goodsOrderInfo.setCreateTime(new Date());
        goodsOrderInfo.setUpdateTime(new Date());
        this.goodsOrderInfoService.add(goodsOrderInfo);
        return new AjaxReturn(200, null, null);
    }

    //商品订单列表
    @ApiIgnore
    @RequestMapping(path = {"goods-order-list"}, method = {RequestMethod.POST})
    public AjaxReturn select(QueryDto queryDto) throws Exception {
        int userId = getAuthentication().intValue();
        //  int userId = 1;
        if (queryDto == null) {
            queryDto = new QueryDto();
        }
        Pagination<GoodsOrderInfo> list = this.goodsOrderInfoService.select(userId, queryDto);
        return list;
    }

    //红包十条中奖纪录
    @ApiIgnore
    @RequestMapping(path = {"goods-order-new-Promotion-list"}, method = {RequestMethod.POST})
    public AjaxReturn selectNewPromotion() {
        List<NewPromotion> newPromotion = goodsOrderInfoService.selectNewPromotion();
        return new AjaxReturn(200, null, newPromotion);
    }
}
