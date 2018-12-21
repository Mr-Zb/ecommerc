// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   WinningDetailsDto.java

package com.fun.admin.dto;

import java.util.Date;

import com.fun.framework.web.dto.BaseDto;

public class WinningDetailsDto extends BaseDto
{

	private static final long serialVersionUID = 0x8269b4e38050b432L;
	private Integer pkId;
	private Date orderTime;
	private String schemeNo;
	private Integer schemeId;
	private Integer productId;
	private String productName;
	private String lotIssue;
	private Integer memId;
	private String memName;
	private Double amount1;
	private Double amount2;
	private Double amount3;
	private Double amount4;
	private Double persient;
	private Integer buyType;
	private Integer schemeState;
	private String OpenCode;

	public Integer getSchemeId() {
		return schemeId;
	}

	public void setSchemeId(Integer schemeId) {
		this.schemeId = schemeId;
	}

	public String getOpenCode() {
		return OpenCode;
	}

	public void setOpenCode(String OpenCode) {
		this.OpenCode = OpenCode;
	}

	public WinningDetailsDto()
	{
	}

	public Integer getPkId()
	{
		return pkId;
	}

	public void setPkId(Integer pkId)
	{
		this.pkId = pkId;
	}

	public Date getOrderTime()
	{
		return orderTime;
	}

	public void setOrderTime(Date orderTime)
	{
		this.orderTime = orderTime;
	}

	public String getSchemeNo()
	{
		return schemeNo;
	}

	public void setSchemeNo(String schemeNo)
	{
		this.schemeNo = schemeNo;
	}

	public Integer getProductId()
	{
		return productId;
	}

	public void setProductId(Integer productId)
	{
		this.productId = productId;
	}

	public String getProductName()
	{
		return productName;
	}

	public void setProductName(String productName)
	{
		this.productName = productName;
	}

	public String getLotIssue()
	{
		return lotIssue;
	}

	public void setLotIssue(String lotIssue)
	{
		this.lotIssue = lotIssue;
	}

	public Integer getMemId()
	{
		return memId;
	}

	public void setMemId(Integer memId)
	{
		this.memId = memId;
	}

	public String getMemName()
	{
		return memName;
	}

	public void setMemName(String memName)
	{
		this.memName = memName;
	}

	public Double getAmount1()
	{
		return amount1;
	}

	public void setAmount1(Double amount1)
	{
		this.amount1 = amount1;
	}

	public Double getAmount2()
	{
		return amount2;
	}

	public void setAmount2(Double amount2)
	{
		this.amount2 = amount2;
	}

	public Double getAmount3()
	{
		return amount3;
	}

	public void setAmount3(Double amount3)
	{
		this.amount3 = amount3;
	}

	public Double getAmount4()
	{
		return amount4;
	}

	public void setAmount4(Double amount4)
	{
		this.amount4 = amount4;
	}

	public Double getPersient()
	{
		return persient;
	}

	public void setPersient(Double persient)
	{
		this.persient = persient;
	}

	public Integer getBuyType()
	{
		return buyType;
	}

	public void setBuyType(Integer buyType)
	{
		this.buyType = buyType;
	}

	public Integer getSchemeState()
	{
		return schemeState;
	}

	public void setSchemeState(Integer schemeState)
	{
		this.schemeState = schemeState;
	}
}
