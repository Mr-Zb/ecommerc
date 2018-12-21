package com.fun.client.service;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import com.fun.client.domain.ThreePayInfo;
import com.fun.framework.utils.SignUtils1;
import org.apache.commons.codec.digest.DigestUtils;
import org.jsoup.helper.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


/**
 * 诚意支付
 * @author zby
 *
 */
@Service("pay-1-service")
public class Pay0001Service {
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());


	public ModelAndView threePay(HttpServletRequest req, ThreePayInfo threePayInfo, int uid) {
		//获取当前交易时间
		Date currTime = new Date();
		//时间以yyyyMMDDHHmmss的方式表示 
		SimpleDateFormat formatter2 = new SimpleDateFormat("yyyyMMddHHmmss",Locale.CHINA);
		String PayID = threePayInfo.getPayId()+"";//支付渠道
		String TradeDate=new String(formatter2.format(currTime));//下单日期
		String TransID = "CY"+TradeDate;//商户流水号
		String OrderMoneyStr = req.getParameter("OrderMoney");//订单金额
		String OrderMoney="";
		if (!StringUtil.isBlank(OrderMoneyStr)) {
			int money = (int) Math.round(Double.parseDouble(OrderMoneyStr)*100);
			OrderMoney = Integer.valueOf(money)+"";
		}
		
		//String PageUrl = req.getScheme()+"://"+req.getServerName()+":18080/api-three-pay-back-suc";//通知商户页面端地址
		String PageUrl = req.getParameter("PageUrl");
		String ReturnUrl = req.getScheme()+"://"+req.getServerName()+"/api-pay-back-001";//服务器底层通知地址
		String NoticeType = "1";//通知类型	
		String extend1 = uid+"";//扩展信息1
		String extend2 = "";//扩展信息2
		String extend3 = "";//扩展信息3
		String MARK = "|";
		//{MerchantID}|{PayID}|{TradeDate}|{TransID}|{OrderMoney}|{PageUrl}|{ReturnUrl}|{NoticeType}
		String signStr =new String(threePayInfo.getMemberId()+MARK+PayID+MARK+TradeDate+MARK+TransID+MARK+OrderMoney+MARK+PageUrl+MARK+ReturnUrl+MARK+NoticeType);//签名顺序
		logger.info(signStr);
		String sign = SignUtils1.Signaturer(signStr, threePayInfo.getRsaPrivateKey());//RSA加密
		String payUrl = threePayInfo.getPayUrl();// 
		String InterfaceVersion = "2.0";
		String KeyType = "1";
		StringBuffer sb = new StringBuffer();
		sb.append("MemberID="+threePayInfo.getMemberId());
		sb.append("&InterfaceVersion="+InterfaceVersion);
		sb.append("&KeyType="+KeyType);
		sb.append("&PayID="+PayID);
		sb.append("&TradeDate="+TradeDate);
		sb.append("&TransID="+TransID);
		sb.append("&OrderMoney="+OrderMoney);
		sb.append("&PageUrl="+PageUrl);
		sb.append("&ReturnUrl="+ReturnUrl);
		sb.append("&sign="+sign);
		sb.append("&NoticeType="+NoticeType);
		sb.append("&extend1="+extend1);
		logger.info(sb.toString());
		ModelAndView mav = new ModelAndView(new RedirectView(payUrl+"?"+sb.toString()));
		return mav;
	}


    private static byte[] getContentBytes(String content, String charset) {
        if (charset == null || "".equals(charset)) {
            return content.getBytes();
        }
        try {
            return content.getBytes(charset);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("MD5签名过程中出现错误,指定的编码集不对,您目前指定的编码集是:" + charset);
        }
    }
    public static String md5(String text, String input_charset) {
    	
        return DigestUtils.md5Hex(getContentBytes(text, input_charset));
    }
}
