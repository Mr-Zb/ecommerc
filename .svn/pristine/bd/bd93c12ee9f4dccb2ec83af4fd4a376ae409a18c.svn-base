"use strict";

// 所选号码对应的注数
var ssc_cq_3x_zx_hz = [ 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, 63, 69, 73, 75, 75, 73, 69, 63, 55, 45, 36, 28, 21, 15, 10, 6, 3, 1 ];
var ssc_cq_3x_z3_hz = [ 0, 1, 2, 1, 3, 3, 3, 4, 5, 4, 5, 5, 4, 5, 5, 4, 5, 5, 4, 5, 4, 3, 3, 3, 1, 2, 1, 0 ];
var ssc_cq_3x_z6_hz = [ 0, 0, 0, 1, 1, 2, 3, 4, 5, 7, 8, 9, 10, 10, 10, 10, 9, 8, 7, 5, 4, 3, 2, 1, 1, 0, 0, 0 ];
var ssc_cq_2x_zx_hz = [ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 ];
var ssc_cq_2x_zu_hz = [ 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 5, 4, 4, 3, 3, 2, 2, 1, 1 ];
var ssc_cq_3x_z3_fs = [ 0, 0, 2, 6, 12, 20, 30, 42, 56, 72, 90 ];
var ssc_cq_3x_z6_fs = [ 0, 0, 0, 1, 4, 10, 20, 35, 56, 84, 120 ];
var ssc_cq_2x_zu_fs = [ 0, 0, 1, 3, 6, 10, 15, 21, 28, 36, 45 ];

/**
 * <h3>五星直选复试</h3>
 * 
 * <pre>
 * 从个、十、百、千、万位中各选1个或多个号码，所选号码与开奖号码按位一致，即中奖100000元
 * </pre>
 * 
 * @param detail
 */
function verify_1101(detail) {
	var codes = detail.gameContext.split(',');
	detail.betting = codes[0].length * codes[1].length * codes[2].length * codes[3].length * codes[4].length;
	detail.amount1 = 2.00;
	detail.amount2 = detail.amount1 * detail.betting;
}

/**
 * <h3>五星直选单式</h3>
 * 
 * <pre>
 * 任选5个号码组成1个有效投注，所选号码与开奖号码按位一致，即中奖100000元
 * </pre>
 * 
 * @param detail
 */
function verify_1102(detail) {
	var codes = detail.gameContext.split(',');
	detail.betting = codes[0].length * codes[1].length * codes[2].length * codes[3].length * codes[4].length;
	detail.amount1 = 2.00;
	detail.amount2 = detail.amount1 * detail.betting;
}

/**
 * <h3>五星通选复试</h3>
 * 
 * <pre>
 * 从个、十、百、千、万位中各选1个或多个号码，所选号码与开奖号码按位一致，即中奖20000元；所选号码与开奖号码前三位或后三位按位一致，即中奖200元；所选号码与开奖号码前二位或者后二位按位一致，即中奖20元（高等奖通吃低等奖）
 * </pre>
 * 
 * @param detail
 */
function verify_1103(detail) {
	var codes = detail.gameContext.split(',');
	detail.betting = codes[0].length * codes[1].length * codes[2].length * codes[3].length * codes[4].length;
	detail.amount1 = 2.00;
	detail.amount2 = detail.amount1 * detail.betting;
}

/**
 * <h3>五星通选单式</h3>
 * 
 * <pre>
 * 任选5个号码组成1个有效投注，所选号码与开奖号码按位一致，即中奖20000元；所选号码与开奖号码前三位或后三位按位一致，即中奖200元；所选号码与开奖号码前二位或者后二位按位一致，即中奖20元（高等奖通吃低等奖）
 * </pre>
 * 
 * @param detail
 */
function verify_1104(detail) {
	var codes = detail.gameContext.split(',');
	detail.betting = codes[0].length * codes[1].length * codes[2].length * codes[3].length * codes[4].length;
	detail.amount1 = 2.00;
	detail.amount2 = detail.amount1 * detail.betting;
}

/**
 * <h3>三星直选复式</h3>
 * 
 * <pre>
 * 从个、十、百位中各选1个或多个号码，所选号码与开奖号码后三位按位一致，即中奖1000元
 * </pre>
 * 
 * @param detail
 */
function verify_1105(detail) {
	var codes = detail.gameContext.split(',');
	detail.betting = codes[0].length * codes[1].length * codes[2].length;
	detail.amount1 = 2.00;
	detail.amount2 = detail.amount1 * detail.betting;
}

/**
 * <h3>三星直选单式</h3>
 * 
 * <pre>
 * 任选3个号码组成1个有效投注，所选号码与开奖号码后三位按位一致，即中奖1000元
 * </pre>
 * 
 * @param detail
 */
function verify_1106(detail) {
	var codes = detail.gameContext.split(',');
	detail.betting = codes[0].length * codes[1].length * codes[2].length;
	detail.amount1 = 2.00;
	detail.amount2 = detail.amount1 * detail.betting;
}

/**
 * <h3>三星直选和值</h3>
 * 
 * <pre>
 * 从0～27中任选1个或多个号码，所选号码与开奖号码后三位和值一致，即中奖1000元。
 * </pre>
 * 
 * @param detail
 */
function verify_1107(detail) {
	var codes = detail.gameContext.split(',');
	var betting = 0;
	for ( var x in codes) {
		betting += ssc_cq_3x_zx_hz[codes[x]];
	}
	detail.betting = betting;
	detail.amount1 = 2.00;
	detail.amount2 = detail.amount1 * detail.betting;
}

/**
 * <h3>三星直选胆拖</h3>
 * 
 * <pre>
 * 从0～9中任选1个或2个号码作为胆码，从0～9中排除胆码后所剩号码中选择一个或多个号码作为拖码，胆码+拖码≥3个。选择1个胆码时，猜中（1胆码+2拖码）即中奖2注，奖金1000*2=2000元；选择2个胆码时，猜中（2胆码+1拖码）即中奖2注，奖金1000*2=2000元（不含组三和豹子）。
 * </pre>
 * 
 * @param detail
 */
function verify_1108(detail) {
	var codes = detail.gameContext.split(",", 2);

	if ((codes[0].length + codes[1].length) < 3) {
		detail.betting = 0;
	} else if (codes[0].length == 1) {
		detail.betting = codes[0].length * 3 * codes[1].length * (codes[1].length - 1);
	} else if (codes[0].length == 2) {
		detail.betting = codes[0].length * 3 * codes[1].length;
	}
	detail.amount1 = 2.00;
	detail.amount2 = detail.amount1 * detail.betting;

	var arr1 = [];
	arr1 = arr1.concat(codes[0].split(''), codes[1].split(''));
	var arr2 = unique(arr1);

	if (arr1.length != arr2.length) {
		detail.betting = 0;
		detail.amount1 = 0;
		detail.amount2 = 0;
	}
}

/**
 * <h3>三星组三复式</h3>
 * 
 * <pre>
 * 从0～9中任选2个或多个号码，当开奖号码后三位中有任意两位数字相同时，所选号码与开奖号码后三位号码相同（顺序不限，不含豹子），即中奖320元
 * </pre>
 * 
 * @param detail
 */
function verify_1109(detail) {
	var codes = detail.gameContext.replace(/\D/gi, "").split("");

	detail.betting = ssc_cq_3x_z3_fs[codes.length];
	detail.amount1 = 2.00;
	detail.amount2 = detail.amount1 * detail.betting;
}

/**
 * <h3>三星组三单式</h3>
 * 
 * <pre>
 * 任选2个号码组成1个有效投注，当开奖号码后三位中有任意两位数字相同时，所选号码与开奖号码后三位号码相同（顺序不限，不含豹子），即中奖320元
 * </pre>
 * 
 * @param detail
 */
function verify_1110(detail) {
	var codes = detail.gameContext.replace(/\D/gi, "").split("");

	detail.betting = ssc_cq_3x_z3_fs[codes.length];
	detail.amount1 = 2.00;
	detail.amount2 = detail.amount1 * detail.betting;
}

/**
 * <h3>三星组三和值</h3>
 * 
 * <pre>
 * 从1～26中任选1个或多个号码，当开奖号码后三位中有任意两位数字相同时，所选号码与开奖号码后三位和值一致（不含豹子），即中奖320元。
 * </pre>
 * 
 * @param detail
 */
function verify_1111(detail) {
	var codes = detail.gameContext.split(',');
	var betting = 0;
	for ( var x in codes) {
		betting += ssc_cq_3x_z3_hz[codes[x]];
	}
	detail.betting = betting;
	detail.amount1 = 2.00;
	detail.amount2 = detail.amount1 * detail.betting;
}

/**
 * <h3>三星组三胆拖</h3>
 * 
 * <pre>
 * 从0～9中任选1个号码作为胆码，从0～9中排除胆码后所剩号码中选择一个或多个号码作为拖码，胆码+拖码≥2个。猜中（1胆码+1拖码）即中奖2注，奖金320*2=640元（不含豹子）。
 * </pre>
 * 
 * @param detail
 */
function verify_1112(detail) {
	var codes = detail.gameContext.split(",", 2);

	if ((codes[0].length + codes[1].length) < 2) {
		detail.betting = 0;
	} else if (codes[0].length == 1) {
		detail.betting = codes[0].length * 2 * codes[1].length;
	}

	detail.amount1 = 2.00;
	detail.amount2 = detail.amount1 * detail.betting;
	
	var arr1 = [];
	arr1 = arr1.concat(codes[0].split(''), codes[1].split(''));
	var arr2 = unique(arr1);

	if (arr1.length != arr2.length) {
		detail.betting = 0;
		detail.amount1 = 0;
		detail.amount2 = 0;
	}
}

/**
 * <h3>三星组六复式</h3>
 * 
 * <pre>
 * 从0～9中任选3个或多个号码，当开奖号码三位数各不相同时，所选号码与开奖号码后三位号码相同（顺序不限），即中奖160元
 * </pre>
 * 
 * @param detail
 */
function verify_1113(detail) {
	var codes = detail.gameContext.replace(/\D/gi, "").split("");
	detail.betting = ssc_cq_3x_z6_fs[codes.length];
	detail.amount1 = 2.00;
	detail.amount2 = detail.amount1 * detail.betting;
}

/**
 * <h3>三星组六单式</h3>
 * 
 * <pre>
 * 任选3个号码组成1个有效投注，当开奖号码三位数各不相同时，所选号码与开奖号码后三位号码相同（顺序不限），即中奖160元
 * </pre>
 * 
 * @param detail
 */
function verify_1114(detail) {
	var codes = detail.gameContext.replace(/\D/gi, "").split("");

	detail.betting = ssc_cq_3x_z6_fs[codes.length];
	detail.amount1 = 2.00;
	detail.amount2 = detail.amount1 * detail.betting;
}

/**
 * <h3>三星组六和值</h3>
 * 
 * <pre>
 * 从3～24中任选1个或多个号码，当开奖号码三位数各不相同时，所选号码与开奖号码后三位和值一致，即中奖160元
 * </pre>
 * 
 * @param detail
 */
function verify_1115(detail) {
	var codes = detail.gameContext.split(',');
	var betting = 0;
	for ( var x in codes) {
		betting += ssc_cq_3x_z6_hz[codes[x]];
	}
	detail.betting = betting;
	detail.amount1 = 2.00;
	detail.amount2 = detail.amount1 * detail.betting;
}

/**
 * <h3>三星组六胆拖</h3>
 * 
 * <pre>
 * 从0～9中任选1个或2个号码作为胆码，从0～9中排除胆码后所剩号码中选择一个或多个号码作为拖码，胆码+拖码≥3个。选择1个胆码时，猜中（1胆码+2拖码）即中奖160元；选择2个胆码时，猜中（2胆码+1拖码）即中奖160元；
 * </pre>
 * 
 * @param detail
 */
function verify_1116(detail) {
	var codes = detail.gameContext.split(",", 2);

	if ((codes[0].length + codes[1].length) < 3) {
		detail.betting = 0;
	} else if (codes[0].length == 1) {
		detail.betting = codes[0].length * 3 * codes[1].length * (codes[1].length - 1) / 6;
	} else {
		detail.betting = codes[0].length * 3 * codes[1].length / 6;
	}

	detail.amount1 = 2.00;
	detail.amount2 = detail.amount1 * detail.betting;
	
	var arr1 = [];
	arr1 = arr1.concat(codes[0].split(''), codes[1].split(''));
	var arr2 = unique(arr1);

	if (arr1.length != arr2.length) {
		detail.betting = 0;
		detail.amount1 = 0;
		detail.amount2 = 0;
	}
}

/**
 * <h3>二星直选复式</h3>
 * 
 * <pre>
 * 从个、十位中各选1个或多个号码，所选号码与开奖号码后两位按位一致，即中奖100元
 * </pre>
 * 
 * @param detail
 */
function verify_1117(detail) {
	var codes = detail.gameContext.split(',');
	detail.betting = codes[0].length * codes[1].length;
	detail.amount1 = 2.00;
	detail.amount2 = detail.amount1 * detail.betting;
}

/**
 * <h3>二星直选单式</h3>
 * 
 * <pre>
 * 任选2个号码组成1个有效投注，所选号码与开奖号码后两位按位一致，即中奖100元
 * </pre>
 * 
 * @param detail
 */
function verify_1118(detail) {
	var codes = detail.gameContext.split(',');
	detail.betting = codes[0].length * codes[1].length;
	detail.amount1 = 2.00;
	detail.amount2 = detail.amount1 * detail.betting;
}

/**
 * <h3>二星直选和值</h3>
 * 
 * <pre>
 * 从0～18中任选1个或多个号码，所选号码与开奖号码后两位和值一致，即中奖100元。
 * </pre>
 * 
 * @param detail
 */
function verify_1119(detail) {
	var codes = detail.gameContext.split(',');
	var betting = 0;
	for ( var x in codes) {
		betting += ssc_cq_2x_zx_hz[codes[x]];
	}
	detail.betting = betting;
	detail.amount1 = 2.00;
	detail.amount2 = detail.amount1 * detail.betting;
}

/**
 * <h3>二星直选胆拖</h3>
 * 
 * <pre>
 * 从0～9中任选1个号码作为胆码，从0～9中排除胆码后所剩号码中选择一个或多个号码作为拖码，胆码+拖码≥2个。猜中（1胆码+1拖码）即中奖2注，奖金100*2=200元（不包对子）。
 * </pre>
 * 
 * @param detail
 */
function verify_1120(detail) {
	var codes = detail.gameContext.split(",", 2);

	if ((codes[0].length + codes[1].length) < 2) {
		detail.betting = 0;
	} else if (codes[0].length == 1) {
		detail.betting = codes[0].length * 2 * codes[1].length;
	}
	detail.amount1 = 2.00;
	detail.amount2 = detail.amount1 * detail.betting;
	
	var arr1 = [];
	arr1 = arr1.concat(codes[0].split(''), codes[1].split(''));
	var arr2 = unique(arr1);

	if (arr1.length != arr2.length) {
		detail.betting = 0;
		detail.amount1 = 0;
		detail.amount2 = 0;
	}
}

/**
 * <h3>二星组选复式</h3>
 * 
 * <pre>
 * 从0～9中选2～6个号码，所选号码与开奖号码后二位相同（顺序不限，不含对子），即中奖50元
 * </pre>
 * 
 * @param detail
 */
function verify_1121(detail) {
	var codes = detail.gameContext.replace(/\D/gi, "").split("");

	detail.betting = ssc_cq_2x_zu_fs[codes.length];
	detail.amount1 = 2.00;
	detail.amount2 = detail.amount1 * detail.betting;
}

/**
 * <h3>二星组选单式</h3>
 * 
 * <pre>
 * 任选2个号码组成1个有效投注，所选号码与开奖号码后二位相同（顺序不限，不含对子），即中奖50元
 * </pre>
 * 
 * @param detail
 */
function verify_1122(detail) {
	var codes = detail.gameContext.replace(/\D/gi, "").split("");

	detail.betting = ssc_cq_2x_zu_fs[codes.length];
	detail.amount1 = 2.00;
	detail.amount2 = detail.amount1 * detail.betting;
}

/**
 * <h3>二星组选和值</h3>
 * 
 * <pre>
 * 从0～18中任选1个或多个号码，所选号码与开奖号码后二位和值一致，即中奖50元
 * </pre>
 * 
 * @param detail
 */
function verify_1123(detail) {
	var codes = detail.gameContext.split(',');
	var betting = 0;
	for ( var x in codes) {
		betting += ssc_cq_2x_zu_hz[codes[x]];
	}
	detail.betting = betting;
	detail.amount1 = 2.00;
	detail.amount2 = detail.amount1 * detail.betting;
}

/**
 * <h3>二星组选胆拖</h3>
 * 
 * <pre>
 * 从0～9中任选1个号码作为胆码，从0～9中排除胆码后所剩号码中选择一个或多个号码作为拖码，胆码+拖码≥2个。猜中（1胆码+1拖码）即中奖2注，奖金50*2=100元（不含对子）。
 * </pre>
 * 
 * @param detail
 */
function verify_1124(detail) {
	var codes = detail.gameContext.split(",", 2);
	if (codes[0].length + codes[1].length < 2) {
		detail.betting = 0;
	} else {
		detail.betting = codes[1].length;
	}

	detail.amount1 = 2.00;
	detail.amount2 = detail.amount1 * detail.betting;
	
	var arr1 = [];
	arr1 = arr1.concat(codes[0].split(''), codes[1].split(''));
	var arr2 = unique(arr1);

	if (arr1.length != arr2.length) {
		detail.betting = 0;
		detail.amount1 = 0;
		detail.amount2 = 0;
	}
}

/**
 * <h3>一星直选复试</h3>
 * 
 * <pre>
 * 从个位中选择1个或多个号码，所选号码与开奖号码最后1位一致，即中奖10元
 * </pre>
 * 
 * @param detail
 */
function verify_1125(detail) {
	detail.betting = detail.gameContext.replace(/\D/gi, "").length;
	detail.amount1 = 2.00;
	detail.amount2 = detail.amount1 * detail.betting;
}

/**
 * <h3>大小单双复试</h3>
 * 
 * <pre>
 * 从个、十位中各选一种或者多种大、小、单、双特征，所选特征和开奖号码后二位特征相同，即中奖4元
 * </pre>
 * 
 * @param detail
 */
function verify_1126(detail) {
	var codes = detail.gameContext.split(',');
	detail.betting = codes[0].length * codes[1].length;
	detail.amount1 = 2.00;
	detail.amount2 = detail.amount1 * detail.betting;
}

/**
 * <h3>定位胆复试</h3>
 * 
 * <pre>
 * 从个、十、百、千、万位中任选1个号码,所选号码与开奖号码按位一致，即中奖10元
 * </pre>
 * 
 * @param detail
 */
function verify_1127(detail) {
	detail.betting = detail.gameContext.replace(/\D/gi, "").length;
	detail.amount1 = 2.00;
	detail.amount2 = detail.amount1 * detail.betting;
}

/**
 * <h3>不定位胆复试</h3>
 * 
 * <pre>
 * 从0～9中任选1个或多个号码，当开奖号码中包含所选号码，即中奖？元
 * </pre>
 * 
 * @param detail
 */
function verify_1128(detail) {
	detail.betting = detail.gameContext.replace(/\D/gi, "").length;
	detail.amount1 = 2.00;
	detail.amount2 = detail.amount1 * detail.betting;
}
