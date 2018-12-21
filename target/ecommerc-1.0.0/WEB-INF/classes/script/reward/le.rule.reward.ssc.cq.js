"use strict";
/**
 * <h3>五星直选复试</h3>
 * 
 * <pre>
 * 从个、十、百、千、万位中各选1个或多个号码，所选号码与开奖号码按位一致，即中奖 &lt;span class='red'&gt;100000&lt;/span&gt; 元
 * </pre>
 * 
 * @param detail
 * @param opencode
 */
function reward_1101(detail, opencode) {
	var codes = opencode.split('');
	var contexts = detail.gameContext.split(',');
	if (contexts[0].indexOf(codes[0]) != -1 //
			&& contexts[1].indexOf(codes[1]) != -1//
			&& contexts[2].indexOf(codes[2]) != -1 //
			&& contexts[3].indexOf(codes[3]) != -1//
			&& contexts[4].indexOf(codes[4]) != -1) {
		var gameInfo = prodService.getGameById(detail.gameId);
		detail.amount2 = Number(gameInfo.reward || '0');
	}
}

/**
 * <h3>五星直选单式</h3>
 * 
 * <pre>
 * 任选5个号码组成1个有效投注，所选号码与开奖号码按位一致，即中奖 &lt;span class='red'&gt;100000&lt;/span&gt; 元
 * </pre>
 * 
 * @param detail
 * @param opencode
 */
function reward_1102(detail, opencode) {
	var codes = opencode.split('');
	var contexts = detail.gameContext.split(',');
	if (contexts[0].indexOf(codes[0]) != -1 //
			&& contexts[1].indexOf(codes[1]) != -1//
			&& contexts[2].indexOf(codes[2]) != -1 //
			&& contexts[3].indexOf(codes[3]) != -1//
			&& contexts[4].indexOf(codes[4]) != -1) {
		var gameInfo = prodService.getGameById(detail.gameId);
		detail.amount2 = Number(gameInfo.reward || '0');
	}
}

/**
 * <h3>五星通选复试</h3>
 * 
 * <pre>
 * 从个、十、百、千、万位中各选1个或多个号码，所选号码与开奖号码按位一致，即中奖 &lt;span class='red'&gt;20000&lt;/span&gt; 元；所选号码与开奖号码前三位或后三位按位一致，即中奖 &lt;span class='red'&gt;200&lt;/span&gt; 元；所选号码与开奖号码前二位或者后二位按位一致，即中奖 &lt;span class='red'&gt;20&lt;/span&gt; 元（高等奖通吃低等奖）
 * </pre>
 * 
 * @param detail
 * @param opencode
 */
function reward_1103(detail, opencode) {
	var codes = opencode.split('');
	var contexts = detail.gameContext.split(',');
	var amount = 0.00;
	var gameInfo = prodService.getGameById(detail.gameId);
	var reward = gameInfo.reward.split('\|');
	if (contexts[0].indexOf(codes[0]) != -1 //
			&& contexts[1].indexOf(codes[1]) != -1//
			&& contexts[2].indexOf(codes[2]) != -1 //
			&& contexts[3].indexOf(codes[3]) != -1//
			&& contexts[4].indexOf(codes[4]) != -1) {
		amount += Number(reward[0]);
	}

	if (contexts[0].indexOf(codes[0]) != -1 //
			&& contexts[1].indexOf(codes[1]) != -1//
			&& contexts[2].indexOf(codes[2]) != -1) {
		amount += Number(reward[1]);
	} else if (contexts[2].indexOf(codes[2]) != -1 //
			&& contexts[3].indexOf(codes[3]) != -1//
			&& contexts[4].indexOf(codes[4]) != -1) {
		amount += Number(reward[1]);
	}

	if (contexts[0].indexOf(codes[0]) != -1 //
			&& contexts[1].indexOf(codes[1]) != -1) {
		amount += Number(reward[2]);
	} else if (contexts[3].indexOf(codes[3]) != -1//
			&& contexts[4].indexOf(codes[4]) != -1) {
		amount += Number(reward[2]);
	}
	detail.amount2 = amount;
}

/**
 * <h3>五星通选单式</h3>
 * 
 * <pre>
 * 从个、十、百、千、万位中各选1个或多个号码，所选号码与开奖号码按位一致，即中奖 &lt;span class='red'&gt;20000&lt;/span&gt; 元；所选号码与开奖号码前三位或后三位按位一致，即中奖 &lt;span class='red'&gt;200&lt;/span&gt; 元；所选号码与开奖号码前二位或者后二位按位一致，即中奖 &lt;span class='red'&gt;20&lt;/span&gt; 元（高等奖通吃低等奖）
 * </pre>
 * 
 * @param detail
 * @param opencode
 */
function reward_1104(detail, opencode) {
	var codes = opencode.split('');
	var contexts = detail.gameContext.split(',');
	var amount = 0.00;
	var gameInfo = prodService.getGameById(detail.gameId);
	var reward = gameInfo.reward.split('\|');
	if (contexts[0].indexOf(codes[0]) != -1 //
			&& contexts[1].indexOf(codes[1]) != -1//
			&& contexts[2].indexOf(codes[2]) != -1 //
			&& contexts[3].indexOf(codes[3]) != -1//
			&& contexts[4].indexOf(codes[4]) != -1) {
		amount += Number(reward[0]);
	}

	if (contexts[0].indexOf(codes[0]) != -1 //
			&& contexts[1].indexOf(codes[1]) != -1//
			&& contexts[2].indexOf(codes[2]) != -1) {
		amount += Number(reward[1]);
	} else if (contexts[2].indexOf(codes[2]) != -1 //
			&& contexts[3].indexOf(codes[3]) != -1//
			&& contexts[4].indexOf(codes[4]) != -1) {
		amount += Number(reward[1]);
	}

	if (contexts[0].indexOf(codes[0]) != -1 //
			&& contexts[1].indexOf(codes[1]) != -1) {
		amount += Number(reward[2]);
	} else if (contexts[3].indexOf(codes[3]) != -1//
			&& contexts[4].indexOf(codes[4]) != -1) {
		amount += Number(reward[2]);
	}
	detail.amount2 = amount;
}

/**
 * <h3>三星直选复式</h3>
 * 
 * <pre>
 * 从个、十、百位中各选1个或多个号码，所选号码与开奖号码后三位按位一致，即中奖 &lt;span class='red'&gt;1000&lt;/span&gt; 元
 * </pre>
 * 
 * @param detail
 * @param opencode
 */
function reward_1105(detail, opencode) {
	var codes = opencode.split('');
	var contexts = detail.gameContext.split(',');
	if (contexts[0].indexOf(codes[2]) != -1 //
			&& contexts[1].indexOf(codes[3]) != -1//
			&& contexts[2].indexOf(codes[4]) != -1) {
		var gameInfo = prodService.getGameById(detail.gameId);
		detail.amount2 = Number(gameInfo.reward || '0');
	}
}

/**
 * <h3>三星直选单式</h3>
 * 
 * <pre>
 * 任选3个号码组成1个有效投注，所选号码与开奖号码后三位按位一致，即中奖 &lt;span class='red'&gt;1000&lt;/span&gt; 元
 * </pre>
 * 
 * @param detail
 * @param opencode
 */
function reward_1106(detail, opencode) {
	var codes = opencode.split('');
	var contexts = detail.gameContext.split(',');
	if (contexts[0].indexOf(codes[2]) != -1 //
			&& contexts[1].indexOf(codes[3]) != -1//
			&& contexts[2].indexOf(codes[4]) != -1) {
		var gameInfo = prodService.getGameById(detail.gameId);
		detail.amount2 = Number(gameInfo.reward || '0');
	}
}

/**
 * <h3>三星直选和值</h3>
 * 
 * <pre>
 * 从0～27中任选1个或多个号码，所选号码与开奖号码后三位和值一致，即中奖 &lt;span class='red'&gt;1000&lt;/span&gt; 元。
 * </pre>
 * 
 * @param detail
 * @param opencode
 */
function reward_1107(detail, opencode) {
	var codes = opencode.split('');
	var hz = Number(codes[2]) + Number(codes[3]) + Number(codes[4]);
	var contexts = detail.gameContext.split(',');
	for ( var x in contexts) {
		if (Number(contexts[x]) == hz) {
			var gameInfo = prodService.getGameById(detail.gameId);
			detail.amount2 = Number(gameInfo.reward || '0');
			break;
		}
	}
}

/**
 * <h3>三星直选胆拖</h3>
 * 
 * <pre>
 * 从0～9中任选1个或2个号码作为胆码，从0～9中排除胆码后所剩号码中选择一个或多个号码作为拖码，胆码+拖码≥3个。选择1个胆码时，猜中（1胆码+2拖码）即中奖2注，奖金 &lt;span class='red'&gt;1000*2=2000&lt;/span&gt; 元；选择2个胆码时，猜中（2胆码+1拖码）即中奖2注，奖金 &lt;span class='red'&gt;1000*2=2000&lt;/span&gt; 元（不含组三和豹子）。
 * </pre>
 * 
 * @param detail
 * @param opencode
 */
function reward_1108(detail, opencode) {
	var bc = detail.gameContext.split(',');
	var bc1 = bc[0].split('');
	var bc2 = bc[1].split('');
	var code = opencode.substring(2);
	// 去掉组三和豹子号
	if (code[0] == code[1] || code[1] == code[2] || code[2] == code[0]) {
		return;
	}

	var total = 0;
	for ( var x in bc1) {
		if (code.indexOf(bc1[x]) == -1) {
			return;
		}
		total++;
	}

	for ( var x in bc2) {
		if (code.indexOf(bc2[x]) != -1) {
			total++;
		}
	}
	if (total >= 3) {
		var gameInfo = prodService.getGameById(detail.gameId);
		detail.amount2 = Number(gameInfo.reward || '0');
	}
}

/**
 * <h3>三星组三复式</h3>
 * 
 * <pre>
 * 从0～9中任选2个或多个号码，当开奖号码后三位中有任意两位数字相同时，所选号码与开奖号码后三位号码相同（顺序不限，不含豹子），即中奖 &lt;span class='red'&gt;320&lt;/span&gt; 元
 * </pre>
 * 
 * @param detail
 * @param opencode
 */
function reward_1109(detail, opencode) {
	var code = opencode.substring(2);
	// 去掉组三和豹子号
	if (code[0] == code[1] && code[1] == code[2] && code[2] == code[0]) {
		return;
	} else if (code[0] != code[1] && code[1] != code[2] && code[2] != code[0]) {
		return;
	}
	if (detail.gameContext.indexOf(code[0]) != -1 //
			&& detail.gameContext.indexOf(code[1]) != -1//
			&& detail.gameContext.indexOf(code[2]) != -1) {
		var gameInfo = prodService.getGameById(detail.gameId);
		detail.amount2 = Number(gameInfo.reward || '0');
	}
}

/**
 * <h3>三星组三单式</h3>
 * 
 * <pre>
 * 任选2个号码组成1个有效投注，当开奖号码后三位中有任意两位数字相同时，所选号码与开奖号码后三位号码相同（顺序不限，不含豹子），即中奖 &lt;span class='red'&gt;320&lt;/span&gt; 元
 * </pre>
 * 
 * @param detail
 * @param opencode
 */
function reward_1110(detail, opencode) {
	var code = opencode.substring(2);
	// 去掉组三和豹子号
	if (code[0] == code[1] && code[1] == code[2] && code[2] == code[0]) {
		return;
	} else if (code[0] != code[1] && code[1] != code[2] && code[2] != code[0]) {
		return;
	}
	if (detail.gameContext.indexOf(code[0]) != -1 //
			&& detail.gameContext.indexOf(code[1]) != -1//
			&& detail.gameContext.indexOf(code[2]) != -1) {
		var gameInfo = prodService.getGameById(detail.gameId);
		detail.amount2 = Number(gameInfo.reward || '0');
	}
}

/**
 * <h3>三星组三和值</h3>
 * 
 * <pre>
 * 从1～26中任选1个或多个号码，当开奖号码后三位中有任意两位数字相同时，所选号码与开奖号码后三位和值一致（不含豹子），即中奖 &lt;span class='red'&gt;320&lt;/span&gt; 元。
 * </pre>
 * 
 * @param detail
 * @param opencode
 */
function reward_1111(detail, opencode) {
	var code = opencode.substring(2);
	// 去掉组三和豹子号
	if (code[0] == code[1] && code[1] == code[2] && code[2] == code[0]) {
		return;
	} else if (code[0] != code[1] && code[1] != code[2] && code[2] != code[0]) {
		return;
	}

	var hz = Number(code[0]) + Number(code[1]) + Number(code[2]);
	var contexts = detail.gameContext.split(',');
	for ( var x in contexts) {
		if (Number(contexts[x]) == hz) {
			var gameInfo = prodService.getGameById(detail.gameId);
			detail.amount2 = Number(gameInfo.reward || '0');
			break;
		}
	}
}

/**
 * <h3>三星组三胆拖</h3>
 * 
 * <pre>
 * 从0～9中任选1个号码作为胆码，从0～9中排除胆码后所剩号码中选择一个或多个号码作为拖码，胆码+拖码≥2个。猜中（1胆码+1拖码）即中奖2注，奖金 &lt;span class='red'&gt;320*2=640&lt;/span&gt; 元（不含豹子）。
 * </pre>
 * 
 * @param detail
 * @param opencode
 */
function reward_1112(detail, opencode) {
	var code = opencode.substring(2);
	// 去掉组三和豹子号
	if (code[0] == code[1] && code[1] == code[2] && code[2] == code[0]) {
		return;
	} else if (code[0] != code[1] && code[1] != code[2] && code[2] != code[0]) {
		return;
	}

	var bc = detail.gameContext.split(',');
	var bc1 = bc[0].split('');
	var bc2 = bc[1].split('');

	var total = 0;
	for ( var x in bc1) {
		if (code.indexOf(bc1[x]) == -1) {
			return;
		}
		total++;
	}

	for ( var x in bc2) {
		if (code.indexOf(bc2[x]) != -1) {
			total++;
		}
	}
	if (total >= 2) {
		var gameInfo = prodService.getGameById(detail.gameId);
		detail.amount2 = Number(gameInfo.reward || '0');
	}
}

/**
 * <h3>三星组六复式</h3>
 * 
 * <pre>
 * 从0～9中任选3个或多个号码，当开奖号码三位数各不相同时，所选号码与开奖号码后三位号码相同（顺序不限），即中奖 &lt;span class='red'&gt;160&lt;/span&gt; 元
 * </pre>
 * 
 * @param detail
 * @param opencode
 */
function reward_1113(detail, opencode) {
	var code = opencode.substring(2);
	// 去掉组三和豹子号
	if (code[0] == code[1] || code[1] == code[2] || code[2] == code[0]) {
		return;
	}

	if (detail.gameContext.indexOf(code[0]) != -1 //
			&& detail.gameContext.indexOf(code[1]) != -1//
			&& detail.gameContext.indexOf(code[2]) != -1) {
		var gameInfo = prodService.getGameById(detail.gameId);
		detail.amount2 = Number(gameInfo.reward || '0');
	}
}

/**
 * <h3>三星组六单式</h3>
 * 
 * <pre>
 * 任选3个号码组成1个有效投注，当开奖号码三位数各不相同时，所选号码与开奖号码后三位号码相同（顺序不限），即中奖 &lt;span class='red'&gt;160&lt;/span&gt; 元
 * </pre>
 * 
 * @param detail
 * @param opencode
 */
function reward_1114(detail, opencode) {
	var code = opencode.substring(2);
	// 去掉组三和豹子号
	if (code[0] == code[1] || code[1] == code[2] || code[2] == code[0]) {
		return;
	}

	if (detail.gameContext.indexOf(code[0]) != -1 //
			&& detail.gameContext.indexOf(code[1]) != -1//
			&& detail.gameContext.indexOf(code[2]) != -1) {
		var gameInfo = prodService.getGameById(detail.gameId);
		detail.amount2 = Number(gameInfo.reward || '0');
	}
}

/**
 * <h3>三星组六和值</h3>
 * 
 * <pre>
 * 从3～24中任选1个或多个号码，当开奖号码三位数各不相同时，所选号码与开奖号码后三位和值一致，即中奖 &lt;span class='red'&gt;160&lt;/span&gt; 元
 * </pre>
 * 
 * @param detail
 * @param opencode
 */
function reward_1115(detail, opencode) {
	var code = opencode.substring(2);
	// 去掉组三和豹子号
	if (code[0] == code[1] || code[1] == code[2] || code[2] == code[0]) {
		return;
	}

	var hz = Number(code[0]) + Number(code[1]) + Number(code[2]);
	var contexts = detail.gameContext.split(',');
	for ( var x in contexts) {
		if (Number(contexts[x]) == hz) {
			var gameInfo = prodService.getGameById(detail.gameId);
			detail.amount2 = Number(gameInfo.reward || '0');
			break;
		}
	}
}

/**
 * <h3>三星组六胆拖</h3>
 * 
 * <pre>
 * 从0～9中任选1个或2个号码作为胆码，从0～9中排除胆码后所剩号码中选择一个或多个号码作为拖码，胆码+拖码≥3个。选择1个胆码时，猜中（1胆码+2拖码）即中奖 &lt;span class='red'&gt;160&lt;/span&gt; 元；选择2个胆码时，猜中（2胆码+1拖码）即中奖 &lt;span class='red'&gt;160&lt;/span&gt; 元；
 * </pre>
 * 
 * @param detail
 * @param opencode
 */
function reward_1116(detail, opencode) {
	var code = opencode.substring(2);
	// 去掉组三和豹子号
	if (code[0] == code[1] || code[1] == code[2] || code[2] == code[0]) {
		return;
	}

	var bc = detail.gameContext.split(',');
	var bc1 = bc[0].split('');
	var bc2 = bc[1].split('');

	var total = 0;
	for ( var x in bc1) {
		if (code.indexOf(bc1[x]) == -1) {
			return;
		}
		total++;
	}

	for ( var x in bc2) {
		if (code.indexOf(bc2[x]) != -1) {
			total++;
		}
	}
	if (total >= 3) {
		var gameInfo = prodService.getGameById(detail.gameId);
		detail.amount2 = Number(gameInfo.reward || '0');
	}
}

/**
 * <h3>二星直选复式</h3>
 * 
 * <pre>
 * 从个、十位中各选1个或多个号码，所选号码与开奖号码后两位按位一致，即中奖 &lt;span class='red'&gt;100&lt;/span&gt; 元
 * </pre>
 * 
 * @param detail
 * @param opencode
 */
function reward_1117(detail, opencode) {
	var code = opencode.substring(3);

	var contexts = detail.gameContext.split(',');
	if (contexts[0].indexOf(code[0]) != -1 //
			&& contexts[1].indexOf(code[1]) != -1) {
		var gameInfo = prodService.getGameById(detail.gameId);
		detail.amount2 = Number(gameInfo.reward || '0');
	}
}

/**
 * <h3>二星直选单式</h3>
 * 
 * <pre>
 * 任选2个号码组成1个有效投注，所选号码与开奖号码后两位按位一致，即中奖 &lt;span class='red'&gt;100&lt;/span&gt; 元
 * </pre>
 * 
 * @param detail
 * @param opencode
 */
function reward_1118(detail, opencode) {
	var code = opencode.substring(3);

	var contexts = detail.gameContext.split(',');
	if (contexts[0].indexOf(code[0]) != -1 //
			&& contexts[1].indexOf(code[1]) != -1) {
		var gameInfo = prodService.getGameById(detail.gameId);
		detail.amount2 = Number(gameInfo.reward || '0');
	}
}

/**
 * <h3>二星直选和值</h3>
 * 
 * <pre>
 * 从0～18中任选1个或多个号码，所选号码与开奖号码后两位和值一致，即中奖 &lt;span class='red'&gt;100&lt;/span&gt; 元。
 * </pre>
 * 
 * @param detail
 * @param opencode
 */
function reward_1119(detail, opencode) {
	var code = opencode.substring(3);

	var hz = Number(code[0]) + Number(code[1]);
	var contexts = detail.gameContext.split(',');
	for ( var x in contexts) {
		if (Number(contexts[x]) == hz) {
			var gameInfo = prodService.getGameById(detail.gameId);
			detail.amount2 = Number(gameInfo.reward || '0');
			break;
		}
	}
}

/**
 * <h3>二星直选胆拖</h3>
 * 
 * <pre>
 * 从0～9中任选1个号码作为胆码，从0～9中排除胆码后所剩号码中选择一个或多个号码作为拖码，胆码+拖码≥2个。猜中（1胆码+1拖码）即中奖2注，奖金 &lt;span class='red'&gt;100*2=200&lt;/span&gt; 元（不包对子）。
 * </pre>
 * 
 * @param detail
 * @param opencode
 */
function reward_1120(detail, opencode) {
	var code = opencode.substring(2);

	var bc = detail.gameContext.split(',');
	var bc1 = bc[0].split('');
	var bc2 = bc[1].split('');

	var total = 0;
	for ( var x in bc1) {
		if (code.indexOf(bc1[x]) == -1) {
			return;
		}
		total++;
	}

	for ( var x in bc2) {
		if (code.indexOf(bc2[x]) != -1) {
			total++;
		}
	}
	if (total >= 2) {
		var gameInfo = prodService.getGameById(detail.gameId);
		detail.amount2 = Number(gameInfo.reward || '0');
	}
}

/**
 * <h3>二星组选复式</h3>
 * 
 * <pre>
 * 从0～9中选2～6个号码，所选号码与开奖号码后二位相同（顺序不限，不含对子），即中奖 &lt;span class='red'&gt;50&lt;/span&gt; 元
 * </pre>
 * 
 * @param detail
 * @param opencode
 */
function reward_1121(detail, opencode) {
	var code = opencode.substring(3);

	if (detail.gameContext.indexOf(code[0]) != -1 //
			&& detail.gameContext.indexOf(code[1]) != -1//
			&& code[0] != code[1]) {
		var gameInfo = prodService.getGameById(detail.gameId);
		detail.amount2 = Number(gameInfo.reward || '0');
	}
}

/**
 * <h3>二星组选单式</h3>
 * 
 * <pre>
 * 任选2个号码组成1个有效投注，所选号码与开奖号码后二位相同（顺序不限，不含对子），即中奖 &lt;span class='red'&gt;50&lt;/span&gt; 元
 * </pre>
 * 
 * @param detail
 * @param opencode
 */
function reward_1122(detail, opencode) {
	var code = opencode.substring(3);

	if (detail.gameContext.indexOf(code[0]) != -1 //
			&& detail.gameContext.indexOf(code[1]) != -1//
			&& code[0] != code[1]) {
		var gameInfo = prodService.getGameById(detail.gameId);
		detail.amount2 = Number(gameInfo.reward || '0');
	}
}

/**
 * <h3>二星组选和值</h3>
 * 
 * <pre>
 * 从0～18中任选1个或多个号码，所选号码与开奖号码后二位和值一致，即中奖 &lt;span class='red'&gt;50&lt;/span&gt; 元
 * </pre>
 * 
 * @param detail
 * @param opencode
 */
function reward_1123(detail, opencode) {
	var code = opencode.substring(3);

	var hz = Number(code[0]) + Number(code[1]);
	var contexts = detail.gameContext.split(',');
	for ( var x in contexts) {
		if (Number(contexts[x]) == hz) {
			var gameInfo = prodService.getGameById(detail.gameId);
			detail.amount2 = Number(gameInfo.reward || '0');
			break;
		}
	}
}

/**
 * <h3>二星组选胆拖</h3>
 * 
 * <pre>
 * 从0～9中任选1个号码作为胆码，从0～9中排除胆码后所剩号码中选择一个或多个号码作为拖码，胆码+拖码≥2个。猜中（1胆码+1拖码）即中奖2注，奖金 &lt;span class='red'&gt;50*2=100&lt;/span&gt; 元（不含对子）。
 * </pre>
 * 
 * @param detail
 * @param opencode
 */
function reward_1124(detail, opencode) {
	var code = opencode.substring(3);

	var bc = detail.gameContext.split(',');
	var bc1 = bc[0].split('');
	var bc2 = bc[1].split('');

	var total = 0;
	for ( var x in bc1) {
		if (code.indexOf(bc1[x]) == -1) {
			return;
		}
		total++;
	}

	for ( var x in bc2) {
		if (code.indexOf(bc2[x]) != -1) {
			total++;
		}
	}
	if (total >= 2) {
		var gameInfo = prodService.getGameById(detail.gameId);
		detail.amount2 = Number(gameInfo.reward || '0');
	}
}

/**
 * <h3>一星直选复试</h3>
 * 
 * <pre>
 * 从个位中选择1个或多个号码，所选号码与开奖号码最后1位一致，即中奖 &lt;span class='red'&gt;10&lt;/span&gt; 元
 * </pre>
 * 
 * @param detail
 * @param opencode
 */
function reward_1125(detail, opencode) {
	var code = opencode.substring(4);
	if (detail.gameContext.indexOf(code) != -1) {
		var gameInfo = prodService.getGameById(detail.gameId);
		detail.amount2 = Number(gameInfo.reward || '0');
	}
}

/**
 * <h3>大小单双复试</h3>
 * 
 * <pre>
 * 从个、十位中各选一种或者多种大、小、单、双特征，所选特征和开奖号码后二位特征相同，即中奖 &lt;span class='red'&gt;4&lt;/span&gt; 元
 * </pre>
 * 
 * @param detail
 * @param opencode
 */
function reward_1126(detail, opencode) {
	var code_1 = [ '5', '6', '7', '8', '9' ];
	var code_2 = [ '0', '1', '2', '3', '4' ];
	var code_3 = [ '1', '3', '5', '7', '9' ];
	var code_4 = [ '0', '2', '4', '6', '8' ];

	var code = opencode.substring(3);

	var bc1 = [];
	var bc2 = [];
	{// 求第一位
		if (code_1.indexOf(code[0]) != -1) {
			bc1.push('大');
		}
		if (code_2.indexOf(code[0]) != -1) {
			bc1.push('小');
		}
		if (code_3.indexOf(code[0]) != -1) {
			bc1.push('单');
		}
		if (code_4.indexOf(code[0]) != -1) {
			bc1.push('双');
		}
	}

	{// 求第二位
		if (code_1.indexOf(code[1]) != -1) {
			bc2.push('大');
		}
		if (code_2.indexOf(code[1]) != -1) {
			bc2.push('小');
		}
		if (code_3.indexOf(code[1]) != -1) {
			bc2.push('单');
		}
		if (code_4.indexOf(code[1]) != -1) {
			bc2.push('双');
		}
	}

	// 大小,小单
	var n1 = 0;
	var n2 = 0;
	var contexts = detail.gameContext.split(',');
	for ( var x in bc1) {
		if (contexts[0].indexOf(bc1[x]) != -1) {
			n1++;
		}
	}
	for ( var x in bc2) {
		if (contexts[1].indexOf(bc2[x]) != -1) {
			n2++;
		}
	}
	if (n1 * n2 > 0) {
		var gameInfo = prodService.getGameById(detail.gameId);
		detail.amount2 = Number(gameInfo.reward || '0') * n1 * n2;
	}
}

/**
 * <h3>定位胆复试</h3>
 * 
 * <pre>
 * 从个、十、百、千、万位中任选1个号码,所选号码与开奖号码按位一致，即中奖 &lt;span class='red'&gt;10&lt;/span&gt; 元
 * </pre>
 * 
 * @param detail
 * @param opencode
 */
function reward_1127(detail, opencode) {
	var codes = opencode.split('');
	var contexts = detail.gameContext.split(',');
	var gameInfo = prodService.getGameById(detail.gameId);
	var amount = 0.00;

	if (contexts[0].indexOf(codes[0]) != -1) {
		amount += Number(gameInfo.reward || '0');
	}

	if (contexts[1].indexOf(codes[1]) != -1) {
		amount += Number(gameInfo.reward || '0');
	}

	if (contexts[2].indexOf(codes[2]) != -1) {
		amount += Number(gameInfo.reward || '0');
	}

	if (contexts[3].indexOf(codes[3]) != -1) {
		amount += Number(gameInfo.reward || '0');
	}

	if (contexts[4].indexOf(codes[4]) != -1) {
		amount += Number(gameInfo.reward || '0');
	}
	detail.amount2 = amount;
}

/**
 * <h3>不定位胆复试</h3>
 * 
 * <pre>
 * 从0～9中任选1个或多个号码，当开奖号码中包含所选号码，即中奖 &lt;span class='red'&gt;5&lt;/span&gt; 元
 * </pre>
 * 
 * @param detail
 * @param opencode
 */
function reward_1128(detail, opencode) {
	var codes = opencode.split('');
	var gameInfo = prodService.getGameById(detail.gameId);
	var amount = 0.00;

	if (detail.gameContext.indexOf(codes[0]) != -1) {
		amount += Number(gameInfo.reward || '0');
	}

	if (detail.gameContext.indexOf(codes[1]) != -1) {
		amount += Number(gameInfo.reward || '0');
	}

	if (detail.gameContext.indexOf(codes[2]) != -1) {
		amount += Number(gameInfo.reward || '0');
	}

	if (detail.gameContext.indexOf(codes[3]) != -1) {
		amount += Number(gameInfo.reward || '0');
	}

	if (detail.gameContext.indexOf(codes[4]) != -1) {
		amount += Number(gameInfo.reward || '0');
	}
	detail.amount2 = amount;
}
