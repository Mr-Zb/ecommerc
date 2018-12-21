package com.fun.client.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ReturnIndex implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("响应编码")
    protected java.lang.Integer code = 200;
    @ApiModelProperty("响应信息")
    protected java.lang.String info = "";
    @ApiModelProperty("响应轮播图数据")
    protected java.lang.Object banner = "";
    @ApiModelProperty("响应公告数据")
    protected java.lang.Object notice = "";
    @ApiModelProperty("响应所有普通商品数据")
    protected java.lang.Object generalGoods = "";
}
