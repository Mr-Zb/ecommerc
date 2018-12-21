package com.fun.framework.utils;

import org.apache.commons.codec.binary.Hex;

public class DigestUtils extends org.apache.commons.codec.digest.DigestUtils {

	/**
	 * 短密码
	 * 
	 * @param data
	 * @return
	 */
	public static String md5Hex(final String data) {
		return Hex.encodeHexString(md5(data));
	}
}
