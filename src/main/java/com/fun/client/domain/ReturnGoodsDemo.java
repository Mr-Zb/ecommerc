package com.fun.client.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ReturnGoodsDemo implements Serializable {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty("响应公告数据")
    protected java.lang.Object left = "";
    @ApiModelProperty("响应所有普通商品数据")
    protected java.lang.Object right = "";
}
