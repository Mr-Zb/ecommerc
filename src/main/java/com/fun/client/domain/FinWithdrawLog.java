 package com.fun.client.domain;
 import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
 
 @ApiModel
 public class FinWithdrawLog
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
 
   @ApiModelProperty(name="bankAccount", notes="银行卡号")
   private String bankAccount;
 
   @ApiModelProperty(name="bankAccountName", notes="开户名称")
   private String bankAccountName;
 
   @ApiModelProperty(name="bankName", notes="银行名称")
   private String bankName;
 
   @ApiModelProperty(name="bankSubName", notes="开户行")
   private String bankSubName;
 
   @ApiModelProperty(name="orderNo", notes="订单编号")
   private String orderNo;
 
   @ApiModelProperty(name="withdrawTo", notes="提现平台")
   private String withdrawTo;
 
   @ApiModelProperty(name="withdrawAccount", notes="提现账户")
   private String withdrawAccount;
 
   @ApiModelProperty(name="withdrawNo", notes="提现流水")
   private String withdrawNo;
 
   @ApiModelProperty(name="withdrawState", notes="提现状态(--0未审核--1通过--2拒绝)")
   private Integer withdrawState;
 
   @ApiModelProperty(name="withdrawAmount1", notes="提现前金额")
   private Double withdrawAmount1;
 
   @ApiModelProperty(name="withdrawAmount2", notes="提现金额")
   private Double withdrawAmount2;
 
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
 
   public String getBankAccount()
   {
     return this.bankAccount;
   }
 
   public void setBankAccount(String bankAccount)
   {
     this.bankAccount = bankAccount;
   }
 
   public String getBankAccountName()
   {
     return this.bankAccountName;
   }
 
   public void setBankAccountName(String bankAccountName)
   {
     this.bankAccountName = bankAccountName;
   }
 
   public String getBankName()
   {
     return this.bankName;
   }
 
   public void setBankName(String bankName)
   {
     this.bankName = bankName;
   }
 
   public String getBankSubName()
   {
     return this.bankSubName;
   }
 
   public void setBankSubName(String bankSubName)
   {
     this.bankSubName = bankSubName;
   }
 
   public String getOrderNo()
   {
     return this.orderNo;
   }
 
   public void setOrderNo(String orderNo)
   {
     this.orderNo = orderNo;
   }
 
   public String getWithdrawTo()
   {
     return this.withdrawTo;
   }
 
   public void setWithdrawTo(String withdrawTo)
   {
     this.withdrawTo = withdrawTo;
   }
 
   public String getWithdrawAccount()
   {
     return this.withdrawAccount;
   }
 
   public void setWithdrawAccount(String withdrawAccount)
   {
     this.withdrawAccount = withdrawAccount;
   }
 
   public String getWithdrawNo()
   {
     return this.withdrawNo;
   }
 
   public void setWithdrawNo(String withdrawNo)
   {
     this.withdrawNo = withdrawNo;
   }
 
   public Integer getWithdrawState()
   {
     return this.withdrawState;
   }
 
   public void setWithdrawState(Integer withdrawState)
   {
     this.withdrawState = withdrawState;
   }
 
   public Double getWithdrawAmount1()
   {
     return this.withdrawAmount1;
   }
 
   public void setWithdrawAmount1(Double withdrawAmount1)
   {
     this.withdrawAmount1 = withdrawAmount1;
   }
 
   public Double getWithdrawAmount2()
   {
     return this.withdrawAmount2;
   }
 
   public void setWithdrawAmount2(Double withdrawAmount2)
   {
     this.withdrawAmount2 = withdrawAmount2;
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

