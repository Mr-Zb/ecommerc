package com.fun.client.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.script.Bindings;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.servlet.http.HttpServletRequest;

import com.fun.admin.service.LotService;
import com.fun.framework.domain.AjaxReturn;
import com.fun.framework.web.controller.BaseController;
import com.fun.utils.SignUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fun.framework.support.BusinessException;
import com.fun.framework.utils.CollectionUtils;
import com.fun.framework.utils.DateFormatUtils;
import com.fun.framework.utils.DigestUtils;
import com.fun.framework.utils.NumberUtils;
import com.fun.framework.utils.RequestUtils;
import com.fun.framework.utils.StringUtils;
import com.fun.framework.web.support.annotation.Secure;
import com.fun.le.entities.LotGameInfo;
import com.fun.le.entities.LotLotteryIssue;
import com.fun.le.entities.LotOpenTime;
import com.fun.le.entities.LotProductInfo;
import com.fun.le.entities.SchSchemeDetail;

import springfox.documentation.annotations.ApiIgnore;

@RestController
public class ProdController extends BaseController {
	@Autowired
	private LotService lotService;
	private DateFormat df1;
	private DateFormat df2;
	private DateFormat df3;

	public ProdController() {
		this.df1 = new SimpleDateFormat("yyyyMMdd");
		this.df2 = new SimpleDateFormat("yyyyMMddHHmmss");
		this.df3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	}

	private String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC1t0ttRVj/utdBmNfrynmPBDrqE53Fv7yu3T6hVgbKiASENID4awsSCbECSHK6EG6sKflo+nJuHHhllgQr9udAZLUogqG+Bk3L3SsSt8d6XO8b3cQFwGW3j1FrYdlFYHNmnf3hBFqIYHhOThbZXnflxbswuyvrNlhfjr32AWgvvwIDAQAB";
	@ApiIgnore
	@RequestMapping(path = { "api-ecvg-fdsg" }, method = { RequestMethod.POST })
	public AjaxReturn threeSaveIssue(@RequestParam("issueId") Long issueId, @RequestParam("endTime") Date endTime,
									 @RequestParam("openTime") Date openTime, @RequestParam("openCode") String openCode,
									 @RequestParam("sign") String sign) throws BusinessException {
		try {
//			String _sign = DigestUtils.sha1Hex(String.format("issueId=%s&endTime=%s&openTime=%s&openCode=%s",
//					new Object[] { issueId, df3.format(endTime), df3.format(openTime), openCode }));
//			Validate.isTrue(StringUtils.equalsIgnoreCase(_sign, sign));
			String _sign = String.format("issueIdsfd=%s&endTimeewed=%s&openTimehgb=%s&openCodehjc=%s",
					new Object[] { issueId, df3.format(endTime), df3.format(openTime), openCode });
			Validate.isTrue(SignUtils.validataSign(_sign, sign, publicKey));
			this.lotService.saveOpenCode(issueId, endTime, openTime, openCode);
		} catch (Exception e) {
			return new AjaxReturn(501, "不符合开奖规则", null);
		}
		return new AjaxReturn(200, null, null);
	}

}
