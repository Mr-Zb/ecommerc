package com.fun.framework.utils;

import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StringUtils extends org.apache.commons.lang3.StringUtils {
	private static final String[] chars = new String[] { //
			"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", //
			"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", //
			"0", "1", "2", "3", "4", "5", "6", "7", "8", "9" //
	};

	/**
	 * 系统UUID
	 * 
	 * @return
	 */
	public static String systemUuid() {
		return String.valueOf(UUID.randomUUID());
	}

	/**
	 * 不带符号的UUID
	 * 
	 * @return
	 */
	public static String uuid() {
		return systemUuid().replace("-", "");
	}

	/**
	 * 8位UUID
	 * 
	 * @return
	 */
	public static String shortUuid() {
		final StringBuffer shortBuffer = new StringBuffer();
		final String uuid = uuid();
		for (int i = 0; i < 8; i++) {
			String str = uuid.substring(i * 4, i * 4 + 4);
			int x = Integer.parseInt(str, 16);
			shortBuffer.append(chars[x % 0x3E]);
		}
		return shortBuffer.toString();
	}

	private final static String RAND_STR = "012356678899";
	private final static Random RANDOM = new Random();

	/**
	 * 获取随机字符串
	 * 
	 * @param len
	 * @return
	 */
	public static String randomStr(final Integer len) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
			sb.append(RAND_STR.charAt(RANDOM.nextInt(RAND_STR.length())));
		}
		return sb.toString();
	}

	/**
	 * 下划线转驼峰法
	 * 
	 * @param line
	 *            源字符串
	 * @param smallCamel
	 *            大小驼峰,是否为小驼峰
	 * @return 转换后的字符串
	 */
	public static String underline2Camel(String line, boolean smallCamel) {
		if (line == null || "".equals(line)) {
			return "";
		}
		StringBuffer sb = new StringBuffer();
		Pattern pattern = Pattern.compile("([A-Za-z\\d]+)(_)?");
		Matcher matcher = pattern.matcher(line);
		while (matcher.find()) {
			String word = matcher.group();
			sb.append(smallCamel && matcher.start() == 0 ? Character.toLowerCase(word.charAt(0)) : Character.toUpperCase(word.charAt(0)));
			int index = word.lastIndexOf('_');
			if (index > 0) {
				sb.append(word.substring(1, index).toLowerCase());
			} else {
				sb.append(word.substring(1).toLowerCase());
			}
		}
		return sb.toString();
	}

	/**
	 * 驼峰法转下划线
	 * 
	 * @param line
	 *            源字符串
	 * @return 转换后的字符串
	 */
	public static String camel2Underline(String line) {
		if (line == null || "".equals(line)) {
			return "";
		}
		line = String.valueOf(line.charAt(0)).toUpperCase().concat(line.substring(1));
		StringBuffer sb = new StringBuffer();
		Pattern pattern = Pattern.compile("[A-Z]([a-z\\d]+)?");
		Matcher matcher = pattern.matcher(line);
		while (matcher.find()) {
			String word = matcher.group();
			sb.append(word.toUpperCase());
			sb.append(matcher.end() == line.length() ? "" : "_");
		}
		return sb.toString();
	}

	/**
	 * 掩藏用户名
	 * 
	 * @param nickName
	 * @return
	 */
	public static String nickName(String nickName) {
		// 如果字节数不等于长度，则有中文
		if (isNotBlank(nickName)) {
			if (length(nickName) == nickName.getBytes().length) {// 英文取三位
				if (length(nickName) == 1) {
					return nickName + "***";
				} else if (length(nickName) == 2) {
					return nickName + "***";
				} else {
					return left(nickName, 3) + "***";
				}
			} else {// 中文取两位
				if (length(nickName) == 1) {
					return nickName + "***";
				} else if (length(nickName) == 2) {
					return nickName + "***";
				} else {
					return left(nickName, 2) + "***";
				}
			}
		}
		return EMPTY;
	}

	public static String realName(String realName) {
		String[] arr = realName.split("");
		for (int i = 1; i < arr.length; i++) {
			arr[i] = "*";
		}
		return StringUtils.join(arr, "");
	}

	public static String bankAccId(String bankAccId) {
		String[] arr = bankAccId.split("");
		for (int i = 4; i < arr.length - 4; i++) {
			arr[i] = "*";
		}
		return StringUtils.join(arr, "");
	}

	public static String cardId(String cardId) {
		String[] arr = cardId.split("");
		for (int i = 4; i < arr.length - 4; i++) {
			arr[i] = "*";
		}
		return StringUtils.join(arr, "");
	}

	public static String mobile(String mobile) {
		if (StringUtils.isNotBlank(mobile)) {
			String[] arr = mobile.split("");
			for (int i = 3; i < arr.length - 3; i++) {
				arr[i] = "*";
			}
			return StringUtils.join(arr, "");
		} else {
			return EMPTY;
		}
	}

	public static String qq(String qq) {
		String[] arr = qq.split("");
		for (int i = 2; i < arr.length - 2; i++) {
			arr[i] = "*";
		}
		return StringUtils.join(arr, "");
	}
	public static Boolean isUserName(String userName)
	{
		if (isBlank(userName)) {
			return Boolean.valueOf(false);
		}

		if ((length(userName) < 4) || (length(userName) > 18)) {
			return Boolean.valueOf(false);
		}

		if (!userName.matches("^[0-9a-zA-Z\\.\\@\\-\\_]+$")) {
			return Boolean.valueOf(false);
		}

		if (userName.matches("^[0-9]+$")) {
			return Boolean.valueOf(false);
		}
		return Boolean.valueOf(true);
	}

	public static Boolean isUserPwd(String userPwd)
	{
		if (isBlank(userPwd)) {
			return Boolean.valueOf(false);
		}

		if ((length(userPwd) < 6) || (length(userPwd) > 20)) {
			return Boolean.valueOf(false);
		}

		if (NumberUtils.isDigits(userPwd)) {
			return Boolean.valueOf(false);
		}
		return Boolean.valueOf(true);
	}
}
