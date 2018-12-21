package com.fun.client.controller;

import com.fun.client.domain.GoodsOrderInfo;
import com.fun.client.service.GoodsOrderInfoService;
import com.fun.framework.domain.AjaxReturn;
import com.fun.framework.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class PickGoodsController extends BaseController {
    private @Autowired
    GoodsOrderInfoService goodsOrderInfoService;

    /**
     * 提货
     *
     * @param orderNo
     * @return
     * @throws Exception
     */
    @ApiIgnore
    @RequestMapping(path = {"pick-up-goods"}, method = {RequestMethod.POST})
    public AjaxReturn pickUpGoods(String orderNo, HttpServletRequest request) throws Exception {
        int userId = getAuthentication(request);
        GoodsOrderInfo goodsOrderInfo = this.goodsOrderInfoService.selectGoodsInfo(orderNo, userId);
        if (goodsOrderInfo.getOrderState().equals(2) || goodsOrderInfo.getOrderState().equals(3)) {//大升级，小升级
            goodsOrderInfo.setOrderState(4);
            this.goodsOrderInfoService.updateOrderState(orderNo, goodsOrderInfo.getOrderState(),userId);
            return new AjaxReturn(200, null, null);
        }
        if (goodsOrderInfo.getPromotionType().equals(0)) {//非促销商品
            goodsOrderInfo.setOrderState(4);
            this.goodsOrderInfoService.updateOrderState(orderNo, goodsOrderInfo.getOrderState(),userId);
            return new AjaxReturn(200, null, null);
        }
        return new AjaxReturn(501, "提货失败", null);
    }
}
