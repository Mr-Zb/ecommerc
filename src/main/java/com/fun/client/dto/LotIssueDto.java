 package com.fun.client.dto;
 
 import java.util.Date;

import com.fun.framework.web.dto.BaseDto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
 
 @ApiModel
 public class LotIssueDto extends BaseDto
 {
   private static final long serialVersionUID = 2932131502114823190L;
 
   @ApiModelProperty(name="issue", notes="期号")
   private String issue;
 
   @ApiModelProperty(name="time", notes="时间")
   private Date time;
 
   public String getIssue()
   {
     return this.issue;
   }
 
   public void setIssue(String issue) {
     this.issue = issue;
   }
 
   public Date getTime() {
     return this.time;
   }
 
   public void setTime(Date time) {
     this.time = time;
   }
 }

