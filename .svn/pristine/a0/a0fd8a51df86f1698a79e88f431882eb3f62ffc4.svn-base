package com.fun.api.domain;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@ApiModel()
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class SysAttachment implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@ApiModelProperty("主键")
	private Long pkId;
	@ApiModelProperty("会员编号")
	private Long memId;
	@ApiModelProperty("文件类型")
	private Integer fileType;
	@ApiModelProperty("文档类型")
	private String docType;
	@ApiModelProperty("文件名称")
	private String fileName;
	@ApiModelProperty("文件大小")
	private Integer fileLength;
	@ApiModelProperty("文件内容")
	private byte[] fileData;
	@ApiModelProperty("创建时间")
	private Date createTime;
}

