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
public class BannerInfo implements Serializable {
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
    @ApiModelProperty(name = "bannerName", notes = "图片名称")
    private String bannerName;
    @ApiModelProperty(name = "bannerSrc", notes = "图片URL")
    private String bannerSrc;
    @ApiModelProperty(name = "detail", notes = "图片描述")
    private String detail;
    @ApiModelProperty(name = "state", notes = "是否启用")
    private Integer state;
    @ApiModelProperty(name = "bannerLocation", notes = "轮播图位置1-首页2-积分商城")
    private Integer bannerLocation;
}
