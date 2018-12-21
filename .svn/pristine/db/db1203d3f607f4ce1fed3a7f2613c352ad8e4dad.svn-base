package com.fun.framework.web.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.fun.framework.utils.Constants;
import com.fun.framework.utils.DateFormatUtils;
import com.fun.framework.utils.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.fun.framework.utils.NumberUtils;
import com.fun.framework.web.support.binder.DateEditor;
import com.fun.framework.web.support.binder.DoubleEditor;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
public abstract class BaseController {

	@Resource
	private RedisTemplate redisTemplate;

	private Map<Integer, String> sync1 = new HashMap<Integer, String>();
	/**
	 * 获取登录用户信息，如果用户没有登录，则返回0
	 * 
	 * @return
	 * @throws Exception
	 */
	public Long getAuthentication() throws Exception {
		long userId = 0L;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null && authentication.isAuthenticated()) {
			userId = NumberUtils.toLong(authentication.getName());
		}
		if (userId >0){
//			Constants.sessionIds.put(userId,DateFormatUtils.parse("yyyy-MM-dd HH:mm:ss",new Date()));
			redisTemplate.opsForHash().put(Constants.SESSIONIDS, (int) userId,DateFormatUtils.parse("yyyy-MM-dd HH:mm:ss",new Date()));
		}
		return userId;
	}
	public Integer getAuthentication(HttpServletRequest request) throws Exception {
		String token = request.getHeader("token");
		if (StringUtils.isBlank(token)){
		    return 0;
        }
		Integer userId = (Integer) redisTemplate.opsForHash().get(Constants.TOKEN,token);
		return userId;
	}
	/**d
	 * 时间类型绑定
	 * 
	 * @param binder
	 * @throws Exception
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) throws Exception {
		binder.registerCustomEditor(Date.class, new DateEditor());
		binder.registerCustomEditor(Float.class, new DoubleEditor());
		binder.registerCustomEditor(Double.class, new DoubleEditor());
	}



	protected String getlock(Integer userId) {
		if (!this.sync1.containsKey(userId)) {
			this.sync1.put(userId, StringUtils.systemUuid());
		}
		return this.sync1.get(userId);
	}

}
