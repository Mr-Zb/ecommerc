 package com.fun.framework.support;
 
 public final class BusinessException extends Exception
 {
   private static final long serialVersionUID = -5176890916066701634L;
   private Integer code;
   private String info;
 
   public BusinessException()
   {
   }
 
   public BusinessException(Integer code, String info)
   {
     this.code = code;
     this.info = info;
   }
 
   public BusinessException(Integer code, String info, Throwable cause) {
     super(cause);
     this.code = code;
     this.info = info;
   }
 
   public Integer getCode() {
     return this.code;
   }
 
   public void setCode(Integer code) {
     this.code = code;
   }
 
   public String getInfo() {
     return this.info;
   }
 
   public void setInfo(String info) {
     this.info = info;
   }
 }

