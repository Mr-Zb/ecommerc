package com.fun.api.web.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fun.framework.domain.AjaxReturn;
import com.fun.framework.utils.Constants;
import com.google.code.kaptcha.impl.DefaultKaptcha;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(value = "validation", consumes = "application/json", produces = "application/json", protocols = "http")
public class ValidationController {
	private @Autowired DefaultKaptcha captchaProducer;

	/**
	 * 输出验证码
	 * 
	 * @param map
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(path = { "/validation" }, method = { RequestMethod.GET, RequestMethod.POST })
	@ApiOperation(value = "validation", notes = "validation", response = AjaxReturn.class, httpMethod = "POST")
	public AjaxReturn validation(HttpServletRequest request) throws IOException {
		try (ByteArrayOutputStream baos = new ByteArrayOutputStream();) {
			int i = RandomUtils.nextInt(10), j = RandomUtils.nextInt(10);
			String capText = i + "+" + j + "=?";
			BufferedImage bi = captchaProducer.createImage(capText);
			ImageIO.write(bi, "jpg", baos);
			request.getSession().setAttribute(Constants.KEY_VALIDATION, String.valueOf(i + j));
			return new AjaxReturn(200, null, Base64.getEncoder().encodeToString(baos.toByteArray()));
		}
	}
}
