package com.fun.framework.utils;

public class SecurityUtils {
	public static final ThreadLocal<Long> userId = new ThreadLocal<Long>();

	/**
	 * 获取登录用户编号
	 * 
	 * @return
	 */
	public static Long getAuthentication() {
		return userId.get();
	}
}
