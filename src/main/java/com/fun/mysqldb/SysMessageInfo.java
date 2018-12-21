package com.fun.mysqldb;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class SysMessageInfo implements Serializable{

	private static final long serialVersionUID = 1157645281272936338L;
	@ApiModelProperty(name = "pkId", notes = "主键")
	private Integer pkId;
	@ApiModelProperty(name = "cteateUser", notes = "创建者")
	private Integer createUser;
	@ApiModelProperty(name = "createTime", notes = "创建时间")
	private Date createTime;
	@ApiModelProperty(name = "updateUser", notes = "更新者")
	private Integer updateUser;
	@ApiModelProperty(name = "updateUser", notes = "更新时间")
	private Date updateTime;
	@ApiModelProperty(name = "dataVersion", notes = "版本号")
	private Integer dataVersion;
	@ApiModelProperty(name = "title", notes = "文章标题")
	private String title;
	@ApiModelProperty(name = "content", notes = "文章内容")
	private String content;
	@ApiModelProperty(name = "createName", notes = "操作者")
	private String createName;
	@ApiModelProperty(name = "state", notes = "是否开启")
	private Integer state;
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
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreateName() {
		return createName;
	}
	public void setCreateName(String createName) {
		this.createName = createName;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
}
