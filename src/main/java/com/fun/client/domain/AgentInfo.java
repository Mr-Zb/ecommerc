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
public class AgentInfo  implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("上级代理")
    private String agentName;
    @ApiModelProperty("用户帐号")
    private String loginName;
    @ApiModelProperty("用户姓名")
    private String userName;
    @ApiModelProperty("总促销额")
    private Double totalSales;
    @ApiModelProperty("流水盈利")
    private Double profitable;
    @ApiModelProperty("大升级总额")
    private Double bigTotal;
    @ApiModelProperty("奖金组")
    private Double extension;
    @ApiModelProperty("与上级差额")
    private Double difference;
    @ApiModelProperty("差额盈利")
    private Double profitMargin;
    @ApiModelProperty("总盈利")
    private Double totalEarnings;
}
