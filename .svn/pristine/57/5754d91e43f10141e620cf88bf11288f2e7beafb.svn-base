package com.fun.client.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@ApiModel()
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class FinManage implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    private Integer pkId;
    @ApiModelProperty("创建者")
    private Integer createUser;
    @ApiModelProperty("下单时间")
    private Date createTime;
    @ApiModelProperty("商品ID")
    private Integer goodsId;
    @ApiModelProperty("订单状态(1,升级中,2,大升级,3,小升级,4,申请发货,5,已发货,6,已退货)")
    private Integer orderState;
    @ApiModelProperty("促销玩法(1大吉大利 2抢红包)")
    private Integer gameType;
    @ApiModelProperty("订单编号")
    private String orderNo;
    @ApiModelProperty("促销选择(1大吉 2大利 3抢红包)")
    private Integer promotionType;
    @ApiModelProperty("物流单号")
    private String  logisticsNo;
    @ApiModelProperty("购买数量")
    private Integer buyNum;
    @ApiModelProperty("付款")
    private Double payMoney;
    @ApiModelProperty(name = "goodName", notes = "商品名称")
    private String goodName;
    @ApiModelProperty(name = "goodSrc", notes = "商品图片URL")
    private String goodSrc;
    @ApiModelProperty(name = "catId", notes = "商品分类")
    private Integer catId;
    @ApiModelProperty(name = "detail", notes = "商品详情")
    private String detail;
    @ApiModelProperty(name = "price", notes = "商品价格")
    private Double price;
    @ApiModelProperty(name = "coin", notes = "商品积分")
    private Double coin;
    @ApiModelProperty(name = "isIntegral", notes = "是否是积分商品(0,不是，1,是)")
    private Integer isIntegral;
    @ApiModelProperty(name = "isPromotion", notes = "是否是促销商品ID(有值时is_promotion必须为1)")
    private Integer isPromotion;
    @ApiModelProperty(name = "goodSourceId", notes = "原有商品ID")
    private Integer goodSourceId;
    @ApiModelProperty(name = "result", notes = "开奖结果(1大吉，2大利)")
    private Integer result;
    @ApiModelProperty(name = "openTime", notes = "开奖时间")
    private Date openTime;
    @ApiModelProperty(name="lotteryIssue", notes="期号")
    private String lotteryIssue;
    @ApiModelProperty(name="loginName", notes="用户名")
    private String loginName;
}
