package com.fun.admin.dto;

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
public class MemInfoDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("主键")
    private Integer pkId;
    @ApiModelProperty("用户名")
    private String loginName;
    @ApiModelProperty("银行卡号")
    private String bankAccount;
    @ApiModelProperty("开户名称")
    private String bankAccountName;
    @ApiModelProperty("银行名称")
    private String bankName;
    @ApiModelProperty("开户行")
    private String bankSubName;
    @ApiModelProperty("上级名称")
    private String agentName;
    @ApiModelProperty("账户余额")
    private Double Capital1;
    @ApiModelProperty("会员积分")
    private Integer userScore;
    @ApiModelProperty("备注信息")
    private String Remark;
    @ApiModelProperty("金额")
    private Double rechargeAmount;
    @ApiModelProperty("充值次数")
    private Integer rechargeNum;
    @ApiModelProperty("提款金额")
    private Double withdrawAmount;
    @ApiModelProperty("提款次数")
    private Integer withdrawNum;
}