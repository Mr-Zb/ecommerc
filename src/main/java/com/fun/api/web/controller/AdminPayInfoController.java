package com.fun.api.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fun.api.domain.AdminPayInfoQueryDto;
import com.fun.api.domain.PayInfo;
import com.fun.api.service.AdminPayInfoService;
import com.fun.framework.domain.AjaxReturn;
import com.fun.framework.domain.Pagination;
import com.fun.framework.web.controller.BaseController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api")
public class AdminPayInfoController extends BaseController {
	private @Autowired AdminPayInfoService adminPayInfoService;

	@RequestMapping(path = { "/admin-pay-list" }, method = { RequestMethod.GET, RequestMethod.POST })
	public AjaxReturn listPayInfos(@ModelAttribute AdminPayInfoQueryDto queryDto) throws Exception {
		long userId = getAuthentication();
		Pagination<PayInfo> pagination = adminPayInfoService.listPayInfos(userId, queryDto);
		return pagination;
	}


}
