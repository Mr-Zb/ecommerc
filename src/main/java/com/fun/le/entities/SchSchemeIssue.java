package com.fun.le.entities;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class SchSchemeIssue implements Serializable {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(name = "pkId", notes = "主键")
	private Integer pkId;

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

	@ApiModelProperty(name = "schemeId", notes = "方案编号")
	private Integer schemeId;

	@ApiModelProperty(name = "issueState", notes = "中奖状态(--0未出票--1已中奖--2未中奖)")
	private Integer issueState;

	@ApiModelProperty(name = "openState", notes = "期号状态(--0未出票--1已出票--2已退款)")
	private Integer openState;

	@ApiModelProperty(name = "endTime", notes = "出票时间")
	private Date endTime;

	@ApiModelProperty(name = "openTime", notes = "开奖时间")
	private Date openTime;

	@ApiModelProperty(name = "openCode", notes = "开奖号码")
	private String openCode;

	@ApiModelProperty(name = "productId", notes = "产品编号")
	private Integer productId;

	@ApiModelProperty(name = "schemeIssue", notes = "期号")
	private String schemeIssue;

	@ApiModelProperty(name = "schemeMultiple", notes = "倍投")
	private Integer schemeMultiple;

	@ApiModelProperty(name = "schemeAmount1", notes = "购彩金额")
	private Double schemeAmount1;

	@ApiModelProperty(name = "schemeAmount2", notes = "中奖金额")
	private Double schemeAmount2;

	public Integer getPkId() {
		return this.pkId;
	}

	public void setPkId(Integer pkId) {
		this.pkId = pkId;
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

	public Integer getSchemeId() {
		return this.schemeId;
	}

	public void setSchemeId(Integer schemeId) {
		this.schemeId = schemeId;
	}

	public Integer getIssueState() {
		return this.issueState;
	}

	public void setIssueState(Integer issueState) {
		this.issueState = issueState;
	}

	public Integer getOpenState() {
		return this.openState;
	}

	public void setOpenState(Integer openState) {
		this.openState = openState;
	}

	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getOpenTime() {
		return this.openTime;
	}

	public void setOpenTime(Date openTime) {
		this.openTime = openTime;
	}

	public String getOpenCode() {
		return this.openCode;
	}

	public void setOpenCode(String openCode) {
		this.openCode = openCode;
	}

	public Integer getProductId() {
		return this.productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getSchemeIssue() {
		return this.schemeIssue;
	}

	public void setSchemeIssue(String schemeIssue) {
		this.schemeIssue = schemeIssue;
	}

	public Integer getSchemeMultiple() {
		return this.schemeMultiple;
	}

	public void setSchemeMultiple(Integer schemeMultiple) {
		this.schemeMultiple = schemeMultiple;
	}

	public Double getSchemeAmount1() {
		return this.schemeAmount1;
	}

	public void setSchemeAmount1(Double schemeAmount1) {
		this.schemeAmount1 = schemeAmount1;
	}

	public Double getSchemeAmount2() {
		return this.schemeAmount2;
	}

	public void setSchemeAmount2(Double schemeAmount2) {
		this.schemeAmount2 = schemeAmount2;
	}
}
