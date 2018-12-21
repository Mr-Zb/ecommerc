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

public class MenuInfo implements Serializable {
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
    @ApiModelProperty(name = "catName", notes = "类别名称")
    private String catName;
    @ApiModelProperty(name = "state", notes = "分类状态 0 不显示 1 显示")
    private Integer state;
    @ApiModelProperty(name = "bigMenu", notes = "大分类")
    private Integer bigMenu;
    @ApiModelProperty(name = "count", notes = "商品数量")
    private Integer count;
}
