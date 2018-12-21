 package com.fun.le.entities;
 
 import java.io.Serializable;
import java.util.Date;
 
 public class LotGameInfo
   implements Serializable
 {
   private static final long serialVersionUID = 1L;
   private Integer pkId;
   private Integer createUser;
   private Date createTime;
   private Integer updateUser;
   private Date updateTime;
   private Integer dataVersion;
   private Integer productId;
   private String gameName;
   private String gameAlias;
   private String gameDesc;
   private Integer sorting;
   private Integer enableFlag;
   private String reward;
 
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
 
   public Integer getProductId()
   {
     return this.productId;
   }
 
   public void setProductId(Integer productId)
   {
     this.productId = productId;
   }
 
   public String getGameName()
   {
     return this.gameName;
   }
 
   public void setGameName(String gameName)
   {
     this.gameName = gameName;
   }
 
   public String getGameAlias()
   {
     return this.gameAlias;
   }
 
   public void setGameAlias(String gameAlias)
   {
     this.gameAlias = gameAlias;
   }
 
   public String getGameDesc()
   {
     return this.gameDesc;
   }
 
   public void setGameDesc(String gameDesc)
   {
     this.gameDesc = gameDesc;
   }
 
   public Integer getSorting()
   {
     return this.sorting;
   }
 
   public void setSorting(Integer sorting)
   {
     this.sorting = sorting;
   }
 
   public Integer getEnableFlag()
   {
     return this.enableFlag;
   }
 
   public void setEnableFlag(Integer enableFlag)
   {
     this.enableFlag = enableFlag;
   }
 
   public String getReward()
   {
     return this.reward;
   }
 
   public void setReward(String reward)
   {
     this.reward = reward;
   }
 }

