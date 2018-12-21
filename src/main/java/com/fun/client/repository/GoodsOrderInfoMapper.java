package com.fun.client.repository;

import com.fun.client.domain.FinManage;
import com.fun.client.domain.GoodsOrderInfo;
import com.fun.client.domain.NewPromotion;
import com.fun.framework.web.dto.QueryDto;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
@Mapper
public interface GoodsOrderInfoMapper {

    Integer addGoodsOrderInfo(@Param("goodsOrderInfo") GoodsOrderInfo goodsOrderInfo);

    Page<GoodsOrderInfo> select(@Param("userId") Integer userId,QueryDto queryDto);

    GoodsOrderInfo selectGoodsInfo(@Param("orderNo") String orderNo,@Param("userId") Integer userId);

    //修改订单状态
    Integer updateOrderState(@Param("orderNo") String orderNo, @Param("orderState") Integer orderState, @Param("updateTime")Date updateTime,@Param("updateUser") Integer updateUser);

    //最新十条红包促销大升级记录
    List<NewPromotion> selectNewPromotion();

    Integer updateStateAndResult(@Param("orderNo") String orderNo,@Param("orderState") Integer orderState,@Param("result") Integer result);

    Page<GoodsOrderInfo> orderInfoList(@Param("goodsOrderInfo") GoodsOrderInfo goodsOrderInfo,@Param("where") QueryDto where);

    Double selectPromotionMoney(@Param("userId") Integer userId);

    Double selectRedPacketMoney(@Param("userId") Integer userId);

    List<GoodsOrderInfo> promotionWinList(@Param("where") QueryDto where);

    List<GoodsOrderInfo> redEnvelopeList(@Param("where") QueryDto where);

    Page<FinManage> userPromotionList(@Param("finManage") FinManage finManage, @Param("where") QueryDto queryDto);
    Integer selectOrderByGoodId(@Param("goodId")Integer goodId);

    Integer updatePickState(@Param("pickState") Integer pickState,@Param("pkId") Integer pkId,@Param("updateUser") Integer updateUser,@Param("remark") String remark);

    GoodsOrderInfo selectGoodsOrderById(@Param("pkId") Integer pkId);

    Integer updateGoods(@Param("payMoney") Double payMoney,@Param("goodsId") Integer goodsId,@Param("pkId") Integer pkId);
}
