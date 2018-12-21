package com.fun.api.domain;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@ApiModel()
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PayInfo implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@ApiModelProperty("主键")
	private Long pkId;
	@ApiModelProperty("商户订单号")
	private String orderNo1;
	@ApiModelProperty("平台订单号")
	private String orderNo2;
	@ApiModelProperty("通道订单号")
	private String orderNo3;
	@ApiModelProperty("订单创建时间")
	private Date createTime;
	@ApiModelProperty("订单金额")
	private Double orderAmt;
	@ApiModelProperty("代理")
	private Long agentId;
	@ApiModelProperty("商户")
	private Long merchantId;
	@ApiModelProperty("充值通道")
	private Long platformId;
	@ApiModelProperty("充值方式(--1微信--2支付宝--3快捷支付--4网银支付--5QQ钱包--6银联--7京东钱包--8银联一码付--9银联扫码--10微信h5--11支付宝h5)")
	private Integer payType;
	@ApiModelProperty("订单状态(--1待支付--2已支付--3支付失败)")
	private Integer payStatus;
	@ApiModelProperty("充值时间")
	private Date payTime;
	@ApiModelProperty("商户手续费")
	private Double fee1;
	@ApiModelProperty("代理手续费")
	private Double fee2;
	@ApiModelProperty("平台手续费")
	private Double fee3;
	@ApiModelProperty("同步地址")
	private String asyncUrl;
	@ApiModelProperty("异步地址")
	private String syncUrl;
	@ApiModelProperty("扩展信息1")
	private String extend1;
	@ApiModelProperty("扩展信息2")
	private String extend2;
	@ApiModelProperty("扩展信息3")
	private String extend3;
	@ApiModelProperty("扩展信息4")
	private String extend4;
	@ApiModelProperty("扩展信息5")
	private String extend5;
	@ApiModelProperty("通知状态(--1待通知--2通知成功--3通知失败)")
	private Integer noticeStatus;
	@ApiModelProperty("通知类型(--1正常通知--2环讯支付--3智付支付)")
	private Integer noticeType;
	@ApiModelProperty("通知成功时间")
	private Date noticeTime;
}

