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
public class LogisticsInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty("主键")
    private Integer pkId;
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
    @ApiModelProperty("订单号")
    private Integer orderId;
    @ApiModelProperty("物流公司")
    private String logisticsCompany;
    @ApiModelProperty("物流单号")
    private String logisticsNo;
    @ApiModelProperty("备注信息")
    private String remark;
}
