package com.fun.client.domain;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class MemLoginLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(name = "pkId", notes = "主键")
	private Integer pkId;

	@ApiModelProperty(name = "userType", notes = "用户类型")
	private Integer userType;

	@ApiModelProperty(name = "dataVersion", notes = "版本号")
	private Integer dataVersion;

	@ApiModelProperty(name = "createUser", notes = "创建者")
	private Integer createUser;

	@ApiModelProperty(name = "createTime", notes = "创建时间")
	private Date createTime;

	@ApiModelProperty(name = "updateUser", notes = "更新者")
	private Integer updateUser;

	@ApiModelProperty(name = "updateTime", notes = "更新时间")
	private Date updateTime;

	@ApiModelProperty(name = "loginName", notes = "账户")
	private String loginName;

	@ApiModelProperty(name = "currLoginIp", notes = "当前登录IP")
	private String currLoginIp;

	@ApiModelProperty(name = "currLoginAddress", notes = "当前登录IP地址")
	private String currLoginAddress;

	@ApiModelProperty(name = "currLoginDevice", notes = "当前登录设备")
	private String currLoginDevice;

	@ApiModelProperty(name = "currLoginTime", notes = "当前登录时间")
	private Date currLoginTime;

	@ApiModelProperty(name = "memberId", notes = "会员编号")
	private Integer memberId;

	@ApiModelProperty(name = "memberName", notes = "会员姓名")
	private String memberName;

	@ApiModelProperty(name = "resultFlag", notes = "登录结果")
	private Integer resultFlag;

	@ApiModelProperty(name = "remark", notes = "备注")
	private String remark;
	
	public Integer getPkId() {
		return this.pkId;
	}

	public void setPkId(Integer pkId) {
		this.pkId = pkId;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public Integer getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(Integer createUser) {
		this.createUser = createUser;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(Integer updateUser) {
		this.updateUser = updateUser;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getDataVersion() {
		return this.dataVersion;
	}

	public void setDataVersion(Integer dataVersion) {
		this.dataVersion = dataVersion;
	}

	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getCurrLoginIp() {
		return this.currLoginIp;
	}

	public void setCurrLoginIp(String currLoginIp) {
		this.currLoginIp = currLoginIp;
	}

	public String getCurrLoginAddress() {
		return this.currLoginAddress;
	}

	public void setCurrLoginAddress(String currLoginAddress) {
		this.currLoginAddress = currLoginAddress;
	}

	public String getCurrLoginDevice() {
		return this.currLoginDevice;
	}

	public void setCurrLoginDevice(String currLoginDevice) {
		this.currLoginDevice = currLoginDevice;
	}

	public Date getCurrLoginTime() {
		return this.currLoginTime;
	}

	public void setCurrLoginTime(Date currLoginTime) {
		this.currLoginTime = currLoginTime;
	}

	public Integer getMemberId() {
		return this.memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return this.memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public Integer getResultFlag() {
		return this.resultFlag;
	}

	public void setResultFlag(Integer resultFlag) {
		this.resultFlag = resultFlag;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
