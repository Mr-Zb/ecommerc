 package com.fun.client.domain;
 import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
 
 @ApiModel
 public class FinRechargeLog
   implements Serializable
 {
   private static final long serialVersionUID = 1L;
 
   @ApiModelProperty(name="pkId", notes="主键")
   private Integer pkId;
 
   @ApiModelProperty(name="dataVersion", notes="版本号")
   private Integer dataVersion;
 
   @ApiModelProperty(name="createUser", notes="创建者")
   private Integer createUser;
 
   @ApiModelProperty(name="createTime", notes="创建时间")
   private Date createTime;
 
   @ApiModelProperty(name="updateUser", notes="更新者")
   private Integer updateUser;
 
   @ApiModelProperty(name="updateTime", notes="更新时间")
   private Date updateTime;
 
   @ApiModelProperty(name="memberId", notes="会员编号")
   private Integer memberId;
 
   @ApiModelProperty(name="memberName", notes="会员名称")
   private String memberName;
 
   @ApiModelProperty(name="agentId", notes="代理编号")
   private Integer agentId;
 
   @ApiModelProperty(name="agentName", notes="代理名称")
   private String agentName;
 
   @ApiModelProperty(name="agentFullId", notes="代理链")
   private String agentFullId;
 
   @ApiModelProperty(name="agentFullName", notes="代理链名称")
   private String agentFullName;
 
   @ApiModelProperty(name="orderNo", notes="订单编号")
   private String orderNo;
 
   @ApiModelProperty(name="rechargeFrom", notes="充值平台")
   private String rechargeFrom;
 
   @ApiModelProperty(name="rechargeAccount", notes="充值账户")
   private String rechargeAccount;
 
   @ApiModelProperty(name="rechargeAmount1", notes="充值金额")
   private Double rechargeAmount1;
 
   @ApiModelProperty(name="rechargeAmount2", notes="充值后金额")
   private Double rechargeAmount2;
 
   @ApiModelProperty(name="rechargeState", notes="充值状态(0未审核，1已到账，2未到账)")
   private Integer rechargeState;
 
   @ApiModelProperty(name="rechargeNo", notes="充值流水")
   private String rechargeNo;
 
   @ApiModelProperty(name="remark", notes="备注")
   private String remark;
 
   public Integer getPkId()
   {
     return this.pkId;
   }
 
   public void setPkId(Integer pkId)
   {
     this.pkId = pkId;
   }
 
   public Integer getCreateUser()
   {
     return this.createUser;
   }
 
   public void setCreateUser(Integer createUser)
   {
     this.createUser = createUser;
   }
 
   public Date getCreateTime()
   {
     return this.createTime;
   }
 
   public void setCreateTime(Date createTime)
   {
     this.createTime = createTime;
   }
 
   public Integer getUpdateUser()
   {
     return this.updateUser;
   }
 
   public void setUpdateUser(Integer updateUser)
   {
     this.updateUser = updateUser;
   }
 
   public Date getUpdateTime()
   {
     return this.updateTime;
   }
 
   public void setUpdateTime(Date updateTime)
   {
     this.updateTime = updateTime;
   }
 
   public Integer getDataVersion()
   {
     return this.dataVersion;
   }
 
   public void setDataVersion(Integer dataVersion)
   {
     this.dataVersion = dataVersion;
   }
 
   public Integer getMemberId()
   {
     return this.memberId;
   }
 
   public void setMemberId(Integer memberId)
   {
     this.memberId = memberId;
   }
 
   public String getMemberName()
   {
     return this.memberName;
   }
 
   public void setMemberName(String memberName)
   {
     this.memberName = memberName;
   }
 
   public Integer getAgentId()
   {
     return this.agentId;
   }
 
   public void setAgentId(Integer agentId)
   {
     this.agentId = agentId;
   }
 
   public String getAgentName()
   {
     return this.agentName;
   }
 
   public void setAgentName(String agentName)
   {
     this.agentName = agentName;
   }
 
   public String getAgentFullId()
   {
     return this.agentFullId;
   }
 
   public void setAgentFullId(String agentFullId)
   {
     this.agentFullId = agentFullId;
   }
 
   public String getAgentFullName()
   {
     return this.agentFullName;
   }
 
   public void setAgentFullName(String agentFullName)
   {
     this.agentFullName = agentFullName;
   }
 
   public String getOrderNo()
   {
     return this.orderNo;
   }
 
   public void setOrderNo(String orderNo)
   {
     this.orderNo = orderNo;
   }
 
   public String getRechargeFrom()
   {
     return this.rechargeFrom;
   }
 
   public void setRechargeFrom(String rechargeFrom)
   {
     this.rechargeFrom = rechargeFrom;
   }
 
   public String getRechargeAccount()
   {
     return this.rechargeAccount;
   }
 
   public void setRechargeAccount(String rechargeAccount)
   {
     this.rechargeAccount = rechargeAccount;
   }
 
   public Double getRechargeAmount1()
   {
     return this.rechargeAmount1;
   }
 
   public void setRechargeAmount1(Double rechargeAmount1)
   {
     this.rechargeAmount1 = rechargeAmount1;
   }
 
   public Double getRechargeAmount2()
   {
     return this.rechargeAmount2;
   }
 
   public void setRechargeAmount2(Double rechargeAmount2)
   {
     this.rechargeAmount2 = rechargeAmount2;
   }
 
   public Integer getRechargeState()
   {
     return this.rechargeState;
   }
 
   public void setRechargeState(Integer rechargeState)
   {
     this.rechargeState = rechargeState;
   }
 
   public String getRechargeNo()
   {
     return this.rechargeNo;
   }
 
   public void setRechargeNo(String rechargeNo)
   {
     this.rechargeNo = rechargeNo;
   }
 
   public String getRemark()
   {
     return this.remark;
   }
 
   public void setRemark(String remark)
   {
     this.remark = remark;
   }

 }

