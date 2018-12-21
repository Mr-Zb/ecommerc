package com.fun.framework.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Pagination<E> extends AjaxReturn {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8426528464623224135L;
	@ApiModelProperty("总行数")
	private java.lang.Long total;
	@ApiModelProperty("数据行")
	private java.util.Collection<E> rows;

}