package com.fun.client.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@ApiModel()
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class NewPromotion implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(name = "goodName", notes = "商品名称")
    private String goodName;
    @ApiModelProperty(name = "loginName", notes = "用户名")
    private String loginName;
}
