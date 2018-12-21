package com.fun.le.entities;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@Builder
@ApiModel()
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class FinCapitalLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(name = "pkId", notes = "主键")
	private Integer pkId;

	@ApiModelProperty(name = "dataVersion", notes = "版本号")
	private Integer dataVersion;

	@ApiModelProperty(name = "createUser", notes = "创建者")
	private Integer createUser;

	@ApiModelProperty(name = "createTime", notes = "创建时间")
	private Date createTime;

	@ApiModelProperty(name = "updateUser", notes = "更新者")
	private Integer updateUser;

	@ApiModelProperty(name = "updateTime", notes = "更新时间")
	private Date updateTime;

	@ApiModelProperty(name = "memberId", notes = "会员编号")
	private Long memberId;

	@ApiModelProperty(name = "memberName", notes = "会员名称")
	private String memberName;

	@ApiModelProperty(name = "agentId", notes = "代理编号")
	private Integer agentId;

	@ApiModelProperty(name = "agentName", notes = "代理名称")
	private String agentName;

	@ApiModelProperty(name = "agentFullId", notes = "代理链")
	private String agentFullId;

	@ApiModelProperty(name = "agentFullName", notes = "代理链名称")
	private String agentFullName;

	@ApiModelProperty(name = "capitalType", notes = "资金类型(11,充值，12，提款，13，奖励，21，购彩，22，保底，23，充值返利，31，中奖，32，返点，33，其他")
	private Integer capitalType;

	@ApiModelProperty(name = "capitalAmount1", notes = "变更金额")
	private Double capitalAmount1;

	@ApiModelProperty(name = "capitalAmount2", notes = "变更后金额")
	private Double capitalAmount2;

	@ApiModelProperty(name = "orderId", notes = "订单号")
	private Integer orderId;

	@ApiModelProperty(name = "orderNo", notes = "订单编号")
	private String orderNo;

	@ApiModelProperty(name = "remark", notes = "备注信息")
	private String remark;


}
