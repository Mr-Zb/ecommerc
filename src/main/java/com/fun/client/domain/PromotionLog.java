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
public class PromotionLog implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    private Integer pkId;
    @ApiModelProperty("用戶id")
    private Integer userId;
    @ApiModelProperty("玩法类型(0.大吉大利 1.抢红包)")
    private Integer gameType;
    @ApiModelProperty("商品名称")
    private String goodName;
    @ApiModelProperty("促销类型(1.大吉 2.大利 3.抢红包)")
    private Integer promotionType;
    @ApiModelProperty("升级状态(1,大升级,2,小升级,3升级中)")
    private Integer upgradeState;
}
