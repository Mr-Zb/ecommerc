package com.fun.admin.dto;

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
public class ReturnCat implements Serializable {
    private static final long serialVersionUID = 1L;
    private String Id;
    private String catName;
}
