package com.fun.framework.domain;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class LoginReturn implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1951072383754672530L;
    @ApiModelProperty("响应编码")
    protected java.lang.Integer code = 200;
    @ApiModelProperty("响应信息")
    protected java.lang.String info = "";
    @ApiModelProperty("响应数据")
    protected java.lang.Object data = "";
    @ApiModelProperty("token")
    protected java.lang.Object token = "";
    @ApiModelProperty("用户ID")
    protected java.lang.Object userId = "";
    @ApiModelProperty("用户类型")
    protected java.lang.Object userType = "";
    @ApiModelProperty("用户名")
    protected java.lang.Object userName = "";
}
