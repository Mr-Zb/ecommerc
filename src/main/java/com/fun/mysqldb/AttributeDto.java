package com.fun.mysqldb;

import java.io.Serializable;

public class AttributeDto implements Serializable{

	private static final long serialVersionUID = -6760761797480102968L;
	private Integer pkId;
	private String platformId;
	private String platformName;
	private String version;
	private String payUrl;
	private String payId;
	private String payName;
	private Integer isBank;
	private Integer isMerge;
	public Integer getPkId() {
		return pkId;
	}
	public void setPkId(Integer pkId) {
		this.pkId = pkId;
	}
	public String getPlatformId() {
		return platformId;
	}
	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}
	public String getPlatformName() {
		return platformName;
	}
	public void setPlatformName(String platformName) {
		this.platformName = platformName;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getPayUrl() {
		return payUrl;
	}
	public void setPayUrl(String payUrl) {
		this.payUrl = payUrl;
	}
	public String getPayId() {
		return payId;
	}
	public void setPayId(String payId) {
		this.payId = payId;
	}
	public String getPayName() {
		return payName;
	}
	public void setPayName(String payName) {
		this.payName = payName;
	}
	public Integer getIsBank() {
		return isBank;
	}
	public void setIsBank(Integer isBank) {
		this.isBank = isBank;
	}
	public Integer getIsMerge() {
		return isMerge;
	}
	public void setIsMerge(Integer isMerge) {
		this.isMerge = isMerge;
	}
	
}
