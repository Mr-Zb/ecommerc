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
public class ExtensionInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("主键")
    private Long pkId;
    @ApiModelProperty("被推广者ID")
    private Integer userId;
    @ApiModelProperty("被推广者姓名")
    private String userName;
    @ApiModelProperty("推广者ID")
    private Integer promotersId;
    @ApiModelProperty("推广者姓名")
    private String promotersName;
}
