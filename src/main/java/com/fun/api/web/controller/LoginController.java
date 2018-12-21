package com.fun.api.web.controller;

import java.util.*;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import com.fun.client.domain.MemLoginLog;
import com.fun.client.domain.MemUserInfo;
import com.fun.client.service.MemLoginLogService;
import com.fun.framework.domain.LoginReturn;
import com.fun.framework.utils.*;
import com.fun.framework.web.dto.QueryDto;
import com.fun.le.entities.SysAuthMenu;
import com.fun.le.service.SysAuthMenuService;
import com.fun.utils.GoogleAuthenticator;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.fun.api.service.LoginService;
import com.fun.framework.domain.AjaxReturn;
import com.github.benmanes.caffeine.cache.Cache;
import com.fun.framework.web.controller.BaseController;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api")
public class LoginController extends BaseController {
	private @Autowired LoginService loginService;

	@Autowired
	private RedisTemplate redisTemplate;
	@Autowired
	private SysAuthMenuService sysAuthMenuService;
	@Autowired
	private MemLoginLogService loginLogService;

	private final Cache<String, Integer> cache = Caffeine.newBuilder().expireAfterWrite(60, TimeUnit.SECONDS)
			.initialCapacity(10000).maximumSize(100000).build();

	@RequestMapping(path = { "/login" }, method = { RequestMethod.GET, RequestMethod.POST })
	public LoginReturn login(//
			@RequestParam(value = "u") String userName, //
			@RequestParam(value = "p") String userPwd, //
			String code,
//			@RequestParam(value = "v", required = false, defaultValue = "") String valdate, //
			HttpServletRequest request//
	) throws Exception {
		log.debug(">>login");
		Validate.isTrue(StringUtils.isNotBlank(userName), "msg:用户名格式不正确");
		Validate.isTrue(StringUtils.isNotBlank(userPwd), "msg:密码格式不正确");
		// 获取账户信息
		MemUserInfo memUserInfo = loginService.findByUserName(userName);
		Validate.isTrue(memUserInfo != null, "msg:用户名或密码不正确");
		Validate.isTrue(StringUtils.equalsIgnoreCase(memUserInfo.getLoginPwd(), DigestUtils.md5Hex(userPwd)),
				"msg:用户名或密码不正确");

		// 获取权限转换
		Set<GrantedAuthority> authorities = Sets.newLinkedHashSet();
		authorities.add(new SimpleGrantedAuthority("le:authority"));
		//--10管理员--20代理--30超级会员--40测试会员--50普通会员
		if (memUserInfo.getUserType().intValue() == 10) {
			authorities.add(new SimpleGrantedAuthority("le:admin"));//管理员
			if(!"adminking".equals(memUserInfo.getLoginName())){
				if(StringUtils.isBlank(code)){
					return new LoginReturn(500, "Google验证码不能为空！", null,null,null,null,null);
				}
				if (!StringUtils.isNumeric(code)){
					return new LoginReturn(500, "Google验证码格式不正确！", null,null,null,null,null);
				}
				long t = System.currentTimeMillis();
				GoogleAuthenticator ga = new GoogleAuthenticator();
				ga.setWindowSize(5);
				if("".equals(redisTemplate.opsForValue().get(userName)+"")){
					return new LoginReturn(500, "您的帐号没有绑定谷歌验证码！", null,null,null,null,null);
				}
				boolean r = ga.check_code((String) redisTemplate.opsForValue().get(userName), Integer.parseInt(code), t);
				if (!r){
					return new LoginReturn(500, "Google验证码错误！", null,null,null,null,null);
				}
			}
		}else if (memUserInfo.getUserType().intValue() == 20)
			authorities.add(new SimpleGrantedAuthority("le:agent"));//代理
		else if (memUserInfo.getUserType().intValue() == 30)
			authorities.add(new SimpleGrantedAuthority("le:supper"));//超级会员
		else if (memUserInfo.getUserType().intValue() == 40)
			authorities.add(new SimpleGrantedAuthority("le:virtual"));//虚拟
		else if (memUserInfo.getUserType().intValue() == 50) {
			authorities.add(new SimpleGrantedAuthority("le:mem"));//普通会员
		}
		List<SysAuthMenu> allsSysAuthMenus = sysAuthMenuService.select(1,new SysAuthMenu());
		if (memUserInfo.getUserType().intValue() == 50){
			Map<Integer,String> resourcesMap = new HashMap<>();
			for (SysAuthMenu resource : allsSysAuthMenus) {
				resourcesMap.put(resource.getPkId(), resource.getAuthCode());
			}
			String authCodes = memUserInfo.getAuthCodes();
			if (StringUtils.isNotBlank(authCodes)) {
				List<Integer> list = JSON.parseArray(authCodes, Integer.class);
				for (Integer pkId : list) {
					authorities.add(new SimpleGrantedAuthority(resourcesMap.getOrDefault(pkId, "le:authority")));
				}
			}
		}

		// 登录到系统
		UserDetails userDetails = new User(String.valueOf(memUserInfo.getPkId()), memUserInfo.getLoginPwd(), authorities);
		PreAuthenticatedAuthenticationToken token = new PreAuthenticatedAuthenticationToken(userDetails,
				userDetails.getPassword(), userDetails.getAuthorities());
		token.setDetails(new WebAuthenticationDetails(request));
		SecurityContextHolder.getContext().setAuthentication(token);
		int userId = NumberUtils.toInt(SecurityContextHolder.getContext().getAuthentication().getName());
		Map<String, Object> map = Maps.newHashMap();
		map.put("userName", memUserInfo.getLoginName());
		map.put("userType", memUserInfo.getUserType());
		map.put("userId",memUserInfo.getPkId());
		//管理员拼接权限
		if (memUserInfo.getUserType() ==10){
			List<String> authCodes = JSON.parseArray(memUserInfo.getAuthCodes(), String.class);
			for (int i=0;i<allsSysAuthMenus.size();i++){
				for (int j=0;j<authCodes.size();j++){
					if ((allsSysAuthMenus.get(i).getPkId()+"").equals(authCodes.get(j))){
						allsSysAuthMenus.get(i).setAuth(true);
					}
				}
			}
			for (int i=0;i<allsSysAuthMenus.size();i++){
				map.put(allsSysAuthMenus.get(i).getMenuLink(),allsSysAuthMenus.get(i).getAuth());
			}
		}

		String sessionId = request.getSession().getId();
		Constants.sessions.put(memUserInfo.getPkId().longValue(), sessionId);
		//前台判断是否在线
		String tokenStr =null;
		if (memUserInfo.getUserType() == 10){
			//后台token判断
			tokenStr = StringUtils.systemUuid();
			map.put("token",tokenStr);
			redisTemplate.opsForHash().put(Constants.TOKEN,tokenStr,memUserInfo.getPkId());
			System.out.println("保存的token："+tokenStr);
//			Constants.tokens.put(tokenStr,memUserInfo.getPkId().longValue());
		}else {
//			Constants.sessionIds.put(memUserInfo.getPkId().longValue(),DateFormatUtils.parse("yyyy-MM-dd HH:mm:ss",new Date()));
			redisTemplate.opsForHash().put(Constants.SESSIONIDS,memUserInfo.getPkId(),DateFormatUtils.parse("yyyy-MM-dd HH:mm:ss",new Date()));
		}
		request.getSession().setMaxInactiveInterval(0);//设置session永久有效，方便getAuthentication()获取用户值

		//登陆日志
		MemLoginLog loginLog = new MemLoginLog();
		String ip = RequestUtils.getIp(request);
		String ipAddress = RequestUtils.getIpAddress(ip);
		String agent = RequestUtils.getAgent(request);
		loginLog.setCurrLoginAddress(ipAddress);
		loginLog.setCurrLoginDevice(agent);
		loginLog.setCurrLoginIp(ip);
		loginLog.setCurrLoginTime(new Date());
		loginLog.setLoginName(memUserInfo.getLoginName());
		loginLog.setMemberId(memUserInfo.getPkId());
		if(memUserInfo.getBankAccountName()!=null){
			loginLog.setMemberName(memUserInfo.getBankAccountName());
		}else {
			loginLog.setMemberName("");
		}
		if (memUserInfo.getRemark()!=null){
			loginLog.setRemark(memUserInfo.getRemark());
		}else {
		loginLog.setRemark("");
		}
		loginLog.setResultFlag(1);
		loginLog.setUserType(memUserInfo.getUserType());
		this.loginLogService.insert(userId, loginLog);
		log.debug("<<login");
		return new LoginReturn(200, null, map,tokenStr,memUserInfo.getPkId(),memUserInfo.getUserType(),memUserInfo.getLoginName());
	}

	@RequestMapping(path = { "/valid" }, method = { RequestMethod.GET, RequestMethod.POST })
	public AjaxReturn valid(@RequestParam(value = "token") String token) {
		Integer userId = (Integer) redisTemplate.opsForHash().get(Constants.TOKEN,token);
		System.out.println("传过来的token："+token);
		if ( userId!=null && userId>0){
			return new AjaxReturn(200, null, null);
		}else {
			return new AjaxReturn(501, "token失效", null);
		}
	}

	@RequestMapping(path = { "api-mem-login-list" }, method = { RequestMethod.POST })
	public AjaxReturn listLoginRecords(MemLoginLog loginLog,QueryDto queryDto) {
		return this.loginLogService.listLoginRecords(loginLog,queryDto);
	}
}