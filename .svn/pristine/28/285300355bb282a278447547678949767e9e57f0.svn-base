package com.fun.api.web.controller;

import com.fun.framework.web.dto.QueryDto;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fun.framework.domain.AjaxReturn;
import com.fun.framework.web.controller.BaseController;
import com.fun.framework.web.support.annotation.Secure;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api")
@Api(value = "admin-index", consumes = "application/json", produces = "application/json", protocols = "http")
public class AdminIndexController extends BaseController {

	@Secure(any = { "le:admin" })
	@RequestMapping(path = { "/admin-index", "/admin-statistics" }, method = { RequestMethod.GET, RequestMethod.POST })
	public AjaxReturn listMerchants(@ModelAttribute QueryDto queryDto) throws Exception {
		log.debug(">>pwd");
		return new AjaxReturn(200, null, null);
	}
}

