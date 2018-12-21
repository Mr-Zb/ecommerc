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
public class FinRechargeOption implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    private Long pkId;
    @ApiModelProperty("创建者")
    private Integer createUser;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("更新者")
    private Integer updateUser;
    @ApiModelProperty("更新时间")
    private Date updateTime;
    @ApiModelProperty("版本号")
    private Integer dataVersion;
    @ApiModelProperty("充值金额")
    private Double amount;
}
