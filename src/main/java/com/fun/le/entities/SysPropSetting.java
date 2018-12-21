 package com.fun.le.entities;
 
 import java.io.Serializable;
import java.util.Date;
 
 public class SysPropSetting
   implements Serializable
 {
   private static final long serialVersionUID = 1L;
   private Integer pkId;
   private Integer dataVersion;
   private Integer createUser;
   private Date createTime;
   private Integer updateUser;
   private Date updateTime;
   private String propKey;
   private String propValue;
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
 
   public String getPropKey()
   {
     return this.propKey;
   }
 
   public void setPropKey(String propKey)
   {
     this.propKey = propKey;
   }
 
   public String getPropValue()
   {
     return this.propValue;
   }
 
   public void setPropValue(String propValue)
   {
     this.propValue = propValue;
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

