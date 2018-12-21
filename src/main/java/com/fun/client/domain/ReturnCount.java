package com.fun.client.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ReturnCount implements Serializable {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty("次数")
    private Integer count;
    @ApiModelProperty("金额")
    private Double sumAmount;
}