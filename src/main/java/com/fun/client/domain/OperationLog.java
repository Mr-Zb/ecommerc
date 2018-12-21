package com.fun.client.domain;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class OperationLog implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(name = "pkId", notes = "主键")
	private Integer pkId;
	@ApiModelProperty(name = "createUser", notes = "创建者")
	private Integer createUser;
	@ApiModelProperty(name = "createTime", notes = "创建时间")
	private Date createTime;
	@ApiModelProperty(name = "updateUser", notes = "更新者")
	private Integer updateUser;
	@ApiModelProperty(name = "updateTime", notes = "更新时间")
	private Date updateTime;
	@ApiModelProperty(name = "dataVersion", notes = "版本号")
	private Integer dataVersion;
	@ApiModelProperty(name = "memberId", notes = "会员编号")
	private Integer memberId;
	@ApiModelProperty(name = "memberName", notes = "会员姓名")
	private String memberName;
	@ApiModelProperty(name = "memberRemark", notes = "会员备注")
	private String memberRemark;
	@ApiModelProperty(name = "operationIp", notes = "操作ip")
	private String operationIp;
	@ApiModelProperty(name = "content", notes = "操作内容")
	private String content;

	public String getMemberRemark() {
		return memberRemark;
	}
	public void setMemberRemark(String memberRemark) {
		this.memberRemark = memberRemark;
	}
	public Integer getPkId() {
		return pkId;
	}

	public void setPkId(Integer pkId) {
		this.pkId = pkId;
	}

	public Integer getCreateUser() {
		return createUser;
	}

	public void setCreateUser(Integer createUser) {
		this.createUser = createUser;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(Integer updateUser) {
		this.updateUser = updateUser;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getDataVersion() {
		return dataVersion;
	}

	public void setDataVersion(Integer dataVersion) {
		this.dataVersion = dataVersion;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getOperationIp() {
		return operationIp;
	}

	public void setOperationIp(String operationIp) {
		this.operationIp = operationIp;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
