package com.fun.client.service;


import com.fun.client.domain.GoodsInfo;
import com.fun.client.domain.GoodsOrderInfo;
import com.fun.client.domain.IntegralOrderInfo;
import com.fun.client.domain.MemUserInfo;
import com.fun.framework.service.BaseService;
import com.fun.framework.support.BusinessException;
import com.fun.le.entities.FinCapitalLog;
import com.fun.le.repository.SysPropSettingMapper;
import com.fun.le.service.FinCapitalLogService;
import com.fun.le.service.SysPropSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class CancelTheOrderService extends BaseService {
    @Autowired
    private GoodsInfoService goodsInfoService;
    private @Autowired
    GoodsOrderInfoService goodsOrderInfoService;
    private @Autowired
    FinCapitalLogService finCapitalLogService;
    private @Autowired
    MemUserInfoService memUserInfoService;
    private @Autowired
    IntegralOrderInfoService integralOrderInfoService;

    //--商品订单 GoodsOrderInfo--根据订单号搜索订单
    //     * --加钱--资金记录FinCapitalLog
    //     * --商品表:添加商品数量
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class}, readOnly = false)
    public String cancelTheOrder(Integer userId, String orderNo)  throws BusinessException {
        GoodsOrderInfo goodsOrderInfo = this.goodsOrderInfoService.selectGoodsInfo(orderNo, userId);//商品订单信息
        MemUserInfo memUserInfo = memUserInfoService.select(userId);
        double amount = memUserInfo.getCapital1();//用户余额
        MemUserInfo memUserInfo1 = this.memUserInfoService.selectById(memUserInfo.getAgentId().intValue());//上级代理
        double extension = memUserInfo1.getExtension();//查询上级代理推广比例
        GoodsInfo goodsInfo1 = this.goodsInfoService.selectById(goodsOrderInfo.getGoodsId());
        GoodsInfo goodsInfo = this.goodsInfoService.selectById(goodsInfo1.getGoodSourceId());//原商品信息
        int  countUserIntegral = memUserInfo.getUserScore();//用户积分余额
        FinCapitalLog finCapitalLog = new FinCapitalLog();
        IntegralOrderInfo integralOrderInfo = new IntegralOrderInfo();
        if (goodsOrderInfo.getIsIntegral() == 0) {//不是积分商品
            if (goodsOrderInfo.getGameType() > 0 && goodsOrderInfo.getOrderState() == 2) {//促销商品中奖退货

                finCapitalLog.setRemark("促销商品退货");
                finCapitalLog.setCapitalAmount1(goodsInfo.getPrice()* extension);
                finCapitalLog.setCapitalAmount2(Double.valueOf(amount + goodsInfo.getPrice()* extension));
            } else {

                finCapitalLog.setRemark("普通商品退货");
                finCapitalLog.setCapitalAmount1(goodsOrderInfo.getPayMoney());
                finCapitalLog.setCapitalAmount2(Double.valueOf(amount + goodsOrderInfo.getPayMoney()));
                goodsInfo.setRepertoryNum(goodsInfo.getRepertoryNum() + goodsOrderInfo.getBuyNum());
                this.goodsInfoService.updateById(goodsInfo, goodsOrderInfo.getGoodsId());
            }

            finCapitalLog.setMemberName(memUserInfo.getLoginName());
            finCapitalLog.setCreateTime(new Date());
            finCapitalLog.setUpdateTime(new Date());
            finCapitalLog.setCreateUser(userId);
            finCapitalLog.setUpdateUser(userId);
            finCapitalLog.setOrderNo(orderNo);
            finCapitalLog.setMemberId(memUserInfo.getPkId().longValue());
            finCapitalLog.setCapitalType(33);
            finCapitalLog.setAgentFullId(memUserInfo.getAgentFullId());
            finCapitalLog.setAgentFullName(memUserInfo.getAgentFullName());
            finCapitalLog.setAgentId(memUserInfo.getAgentId().intValue());
            finCapitalLog.setAgentName(memUserInfo.getAgentName());
            finCapitalLog.setOrderId(goodsOrderInfo.getPkId());
            finCapitalLog.setDataVersion(1);

            this.finCapitalLogService.insert(finCapitalLog);
            this.memUserInfoService.updateUserAmount1(userId, finCapitalLog.getCapitalAmount2());
            this.goodsOrderInfoService.updateOrderState(orderNo,6,userId);
            return "已退货";
        }else{
            //积分商品
            integralOrderInfo.setCreateTime(new Date());
            integralOrderInfo.setGoodId(goodsOrderInfo.getGoodsId());
            integralOrderInfo.setAmount(goodsOrderInfo.getPayMoney());
            integralOrderInfo.setUserId(userId);
            integralOrderInfo.setOrderState(6);
            integralOrderInfo.setOrderNo(orderNo);
            integralOrderInfo.setGoodName(goodsInfo.getGoodName());
            this.integralOrderInfoService.insert(integralOrderInfo, userId);
            goodsInfo.setRepertoryNum(goodsInfo.getRepertoryNum() + goodsOrderInfo.getBuyNum());
            this.goodsInfoService.updateById(goodsInfo, goodsOrderInfo.getGoodsId());
            this.memUserInfoService.updateUserIntegral(userId, countUserIntegral + goodsOrderInfo.getPayMoney());
            this.goodsOrderInfoService.updateOrderState(orderNo,6,userId);
            return "已退货";
        }
    }
}
