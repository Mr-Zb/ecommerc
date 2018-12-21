 package com.fun.le.entities;
 import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
 
 @ApiModel
 public class SchSchemeDetail
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
 
   @ApiModelProperty(name="schemeId", notes="方案编号")
   private Integer schemeId;
 
   @ApiModelProperty(name="productId", notes="产品编号")
   private Integer productId;
 
   @ApiModelProperty(name="gameId", notes="玩法编号")
   private Integer gameId;
 
   @ApiModelProperty(name="gameName", notes="玩法编号")
   private String gameName;
 
   @ApiModelProperty(name="gameContext", notes="玩法详情(1,大吉，2，大利)")
   private String gameContext;
 
   @ApiModelProperty(name="betting", notes="投注数")
   private Integer betting;
 
   @ApiModelProperty(name="amount1", notes="每注金额")
   private Double amount1;
 
   @ApiModelProperty(name="amount2", notes="合计金额")
   private Double amount2;
   
   @ApiModelProperty(name="moneymode", notes="圆角")
   private Double moneymode;
   
   
	public Double getMoneymode() {
		return moneymode;
	}

	public void setMoneymode(Double moneymode) {
		this.moneymode = moneymode;
	}

	public Integer getPkId() {
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
 
   public Integer getSchemeId()
   {
     return this.schemeId;
   }
 
   public void setSchemeId(Integer schemeId)
   {
     this.schemeId = schemeId;
   }
 
   public Integer getProductId()
   {
     return this.productId;
   }
 
   public void setProductId(Integer productId)
   {
     this.productId = productId;
   }
 
   public Integer getGameId()
   {
     return this.gameId;
   }
 
   public void setGameId(Integer gameId)
   {
     this.gameId = gameId;
   }
 
   public String getGameContext()
   {
     return this.gameContext;
   }
 
   public void setGameContext(String gameContext)
   {
     this.gameContext = gameContext;
   }
 
   public Integer getBetting()
   {
     return this.betting;
   }
 
   public void setBetting(Integer betting)
   {
     this.betting = betting;
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
 
   public String getGameName() {
     return this.gameName;
   }
 
   public void setGameName(String gameName) {
     this.gameName = gameName;
   }
   
 }

