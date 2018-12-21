package com.fun.framework.web.support.interceptor;

import java.io.Writer;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fun.framework.domain.AjaxReturn;
import com.fun.framework.utils.Constants;
import com.fun.framework.utils.NumberUtils;
import com.fun.framework.utils.RequestUtils;
import com.fun.framework.utils.StringUtils;
import com.fun.framework.web.support.annotation.Secure;

@SuppressWarnings("all")
public class SecureHandlerInterceptorAdapter extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if (!Constants.init) {// 如果系统未初始化完成，则不返回任何响应内容
			return false;
		}
		if (handler instanceof HandlerMethod) {
			// 获取方法注解，根据注解的类型
			HandlerMethod handlerMethod = (HandlerMethod) handler;
			Secure secure = handlerMethod.getMethodAnnotation(Secure.class);
			if (secure != null) {
				if (isAuthenticated() && isAuthority(secure.has(), secure.any(), secure.not())) {
					Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
					long userId = NumberUtils.toLong(authentication.getName());
					String sessionId1 = request.getSession().getId();
					String sessionId2 = Constants.sessions.getIfPresent(userId);
					if (StringUtils.equalsIgnoreCase(sessionId1, sessionId2)) {
						Constants.sessions.put(userId, sessionId1);
						return true;
					}
				}

				try (Writer writer = response.getWriter();) {
					response.setCharacterEncoding("UTF-8");
					response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
					response.setStatus(200);
					response.setLocale(Locale.CHINA);
					JSON.writeJSONString(writer, new AjaxReturn(401, "请求超时", null), SerializerFeature.BrowserCompatible);
				}
				return false;
			}
		}
		return super.preHandle(request, response, handler);
	}

	/**
	 * 是否登录
	 * 
	 * @param token
	 * @param request
	 * @return
	 */
	private boolean isAuthenticated() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null && authentication.isAuthenticated()) {
			long userId = NumberUtils.toLong(authentication.getName());
			if (userId > 0L) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 是否有权限
	 * 
	 * @param token
	 * @param secure
	 * @return
	 */
	private boolean isAuthority(String[] has, String[] any, String[] not) {
		if ((has == null || has.length <= 0) && (any == null || any.length <= 0) && (not == null || not.length <= 0)) {
			return true;
		}
		Set<String> authorities = AuthorityUtils.authorityListToSet(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
		return hasAllAuthority(has, authorities) && hasAnyAuthority(any, authorities) && notAuthority(not, authorities);
	}

	/**
	 * @param has
	 * @param authorities
	 * @return
	 */
	private boolean hasAllAuthority(String[] has, Set<String> authorities) {
		if (has != null && has.length > 0) {
			for (String authority : has) {
				if (!authorities.contains(authority)) {
					return false;
				}
			}
			return true;
		}
		return true;
	}

	/**
	 * @param any
	 * @param authorities
	 * @return
	 */
	private boolean hasAnyAuthority(String[] any, Set<String> authorities) {
		if (any != null && any.length > 0) {
			for (String authority : any) {
				if (authorities.contains(authority)) {
					return true;
				}
			}
			return false;
		}
		return true;
	}

	/**
	 * @param not
	 * @param authorities
	 * @return
	 */
	private boolean notAuthority(String[] not, Set<String> authorities) {
		if (not != null && not.length > 0) {
			for (String authority : not) {
				if (authorities.contains(authority)) {
					return false;
				}
			}
			return true;
		}
		return true;
	}
}
