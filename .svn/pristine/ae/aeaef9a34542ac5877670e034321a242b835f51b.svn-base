"use strict";

// 定义工具函数

/**
 * 字符串排序
 * 
 * @param str
 * @param separator
 * @param howmany
 * @returns
 */
function sortStr(str, separator, howmany) {
	return str.split(separator || '', howmany).sort().join("");
}

/**
 * 字符串无顺序比较
 * 
 * @param str1
 * @param str2
 * @returns
 */
function comapreStr(str1, str2) {
	return sortStr(str1, str2);
}

/**
 * 组合个数
 * 
 * @param n
 * @param m
 * @returns {Number}
 */
function Combination(n, m) {
	var n1 = 1, n2 = 1;
	for (var i = n, j = 1; j <= m; n1 *= i--, n2 *= j++) {

	}
	return n1 / n2;
}

function unique(arr) {
	var result = [];
	for ( var x in arr) {
		if (result.indexOf(arr[x]) == -1) {
			result.push(arr[x]);
		}
	}
	return result;
}
