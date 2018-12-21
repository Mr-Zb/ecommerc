package com.fun.api.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.fun.framework.utils.Constants;
import com.fun.framework.utils.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fun.framework.domain.AjaxReturn;
import com.fun.framework.web.controller.BaseController;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
@Api(value = "logout", consumes = "application/json", produces = "application/json", protocols = "http")
public class LogoutController extends BaseController {

    @Resource
    private RedisTemplate redisTemplate;

	@Autowired
	private SessionRegistry sessionRegistry;
	@RequestMapping(path = { "/logout" }, method = { RequestMethod.GET, RequestMethod.POST })
	public AjaxReturn logout(HttpServletRequest request) throws Exception {

		//List<Object> list = this.sessionRegistry.getAllPrincipals();
//		request.getSession().invalidate();
//		request.getSession().removeAttribute("sessionId_"+request.getSession().getId());
		Integer userId = getAuthentication(request);
		if (userId != null && userId >0){
		    String token = request.getHeader("token");
            redisTemplate.opsForHash().delete(Constants.TOKEN,token);
            return new AjaxReturn(200, "已退出", null);
        }
        Integer frontUserId = getAuthentication().intValue();
        redisTemplate.opsForHash().delete(Constants.SESSIONIDS,frontUserId);
		return new AjaxReturn(200, null, null);
	}
}
