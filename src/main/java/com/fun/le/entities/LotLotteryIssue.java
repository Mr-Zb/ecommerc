 package com.fun.le.entities;
 import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
 
 @ApiModel
 public class LotLotteryIssue
   implements Serializable
 {
   private static final long serialVersionUID = 1L;
 
   @ApiModelProperty(name="pkId", notes="主键")
   private Long pkId;
 
   @ApiModelProperty(name="createUser", notes="创建者")
   private Integer createUser;
 
   @ApiModelProperty(name="createTime", notes="创建时间")
   private Date createTime;
 
   @ApiModelProperty(name="updateUser", notes="更新者")
   private Integer updateUser;
 
   @ApiModelProperty(name="updateTime", notes="更新时间")
   private Date updateTime;
 
   @ApiModelProperty(name="dataVersion", notes="版本号")
   private Integer dataVersion;
 
   @ApiModelProperty(name="productId", notes="彩种编号")
   private Integer productId;
 
   @ApiModelProperty(name="lotteryIssue", notes="期号")
   private String lotteryIssue;
 
   @ApiModelProperty(name="bgnTime", notes="开始时间")
   private Date bgnTime;
 
   @ApiModelProperty(name="endTime", notes="截止时间")
   private Date endTime;
 
   @ApiModelProperty(name="openTime", notes="开奖时间")
   private Date openTime;
 
   @ApiModelProperty(name="openFlag", notes="开奖状态(--0未开奖--1已开奖)")
   private Integer openFlag;
 
   @ApiModelProperty(name="openCode", notes="开奖号码")
   private String openCode;
 
   @ApiModelProperty(name="openCodeScource", notes="开奖号码来源(--0未开奖--1手工--2自动)")
   private Integer openCodeScource;
 
   @ApiModelProperty(name="openFeature1", notes="开奖特征1")
   private String openFeature1;
 
   @ApiModelProperty(name="openFeature2", notes="开奖特征2")
   private String openFeature2;
 
   @ApiModelProperty(name="openFeature3", notes="开奖特征3")
   private String openFeature3;
 
   @ApiModelProperty(name="openFeature4", notes="开奖特征4")
   private String openFeature4;
 
   @ApiModelProperty(name="openFeature5", notes="开奖特征5")
   private String openFeature5;
 
   @ApiModelProperty(name="amount1", notes="销售金额")
   private Double amount1;
 
   @ApiModelProperty(name="amount2", notes="出票金额")
   private Double amount2;
 
   @ApiModelProperty(name="amount3", notes="中奖金额")
   private Double amount3;
 
   @ApiModelProperty(name="amount4", notes="返水金额")
   private Double amount4;
 
   public Long getPkId()
   {
     return this.pkId;
   }
 
   public void setPkId(Long pkId)
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
 
   public Integer getProductId()
   {
     return this.productId;
   }
 
   public void setProductId(Integer productId)
   {
     this.productId = productId;
   }
 
   public String getLotteryIssue()
   {
     return this.lotteryIssue;
   }
 
   public void setLotteryIssue(String lotteryIssue)
   {
     this.lotteryIssue = lotteryIssue;
   }
 
   public Date getBgnTime()
   {
     return this.bgnTime;
   }
 
   public void setBgnTime(Date bgnTime)
   {
     this.bgnTime = bgnTime;
   }
 
   public Date getEndTime()
   {
     return this.endTime;
   }
 
   public void setEndTime(Date endTime)
   {
     this.endTime = endTime;
   }
 
   public Date getOpenTime()
   {
     return this.openTime;
   }
 
   public void setOpenTime(Date openTime)
   {
     this.openTime = openTime;
   }
 
   public Integer getOpenFlag()
   {
     return this.openFlag;
   }
 
   public void setOpenFlag(Integer openFlag)
   {
     this.openFlag = openFlag;
   }
 
   public String getOpenCode()
   {
     return this.openCode;
   }
 
   public void setOpenCode(String openCode)
   {
     this.openCode = openCode;
   }
 
   public Integer getOpenCodeScource()
   {
     return this.openCodeScource;
   }
 
   public void setOpenCodeScource(Integer openCodeScource)
   {
     this.openCodeScource = openCodeScource;
   }
 
   public String getOpenFeature1()
   {
     return this.openFeature1;
   }
 
   public void setOpenFeature1(String openFeature1)
   {
     this.openFeature1 = openFeature1;
   }
 
   public String getOpenFeature2()
   {
     return this.openFeature2;
   }
 
   public void setOpenFeature2(String openFeature2)
   {
     this.openFeature2 = openFeature2;
   }
 
   public String getOpenFeature3()
   {
     return this.openFeature3;
   }
 
   public void setOpenFeature3(String openFeature3)
   {
     this.openFeature3 = openFeature3;
   }
 
   public String getOpenFeature4()
   {
     return this.openFeature4;
   }
 
   public void setOpenFeature4(String openFeature4)
   {
     this.openFeature4 = openFeature4;
   }
 
   public String getOpenFeature5()
   {
     return this.openFeature5;
   }
 
   public void setOpenFeature5(String openFeature5)
   {
     this.openFeature5 = openFeature5;
   }
 
   public Double getAmount1()
   {
     return this.amount1;
   }
 
   public void setAmount1(Double amount1)
   {
     this.amount1 = amount1;
   }
 
   public Double getAmount2()
   {
     return this.amount2;
   }
 
   public void setAmount2(Double amount2)
   {
     this.amount2 = amount2;
   }
 
   public Double getAmount3()
   {
     return this.amount3;
   }
 
   public void setAmount3(Double amount3)
   {
     this.amount3 = amount3;
   }
 
   public Double getAmount4()
   {
     return this.amount4;
   }
 
   public void setAmount4(Double amount4)
   {
     this.amount4 = amount4;
   }
 }

