package com.fun.api.domain;

import com.fun.framework.web.dto.QueryDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel()
public class AdminPayInfoQueryDto extends QueryDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5915549481048353891L;
	@ApiModelProperty("商户订单号")
	private String orderNo1;
	@ApiModelProperty("顺宝订单号")
	private String orderNo2;
	@ApiModelProperty("平台订单号")
	private String orderNo3;
	@ApiModelProperty("代理")
	private Long agentId;
	@ApiModelProperty("商户")
	private Long merchantId;
	@ApiModelProperty("充值通道")
	private Long platformId;
	@ApiModelProperty("充值方式(--1微信--2支付宝--3快捷支付--4网银支付--5QQ钱包)")
	private Integer payType;
	@ApiModelProperty("订单状态(--1待支付--2已支付--3支付失败)")
	private Integer payStatus;
	@ApiModelProperty("通知状态(--1待通知--2通知成功--3通知失败)")
	private Integer noticeStatus;

	@ApiModelProperty(hidden = true)
	private String date;
}
