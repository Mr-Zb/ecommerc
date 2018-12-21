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
public class GoodImg implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "pkId", notes = "主键")
    private Integer pkId;
    @ApiModelProperty(name = "cteateUser", notes = "创建者")
    private Integer createUser;
    @ApiModelProperty(name = "createTime", notes = "创建时间")
    private Date createTime;
    @ApiModelProperty(name = "updateUser", notes = "更新者")
    private Integer updateUser;
    @ApiModelProperty(name = "updateTime", notes = "更新时间")
    private Date updateTime;
    @ApiModelProperty(name = "dataVersion", notes = "版本号")
    private Integer dataVersion;
    @ApiModelProperty(name = "goodId", notes = "商品ID")
    private Integer goodId;
    @ApiModelProperty(name = "goodSrc", notes = "详情图片")
    private String goodSrc;
}
