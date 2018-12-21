package com.fun.framework.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.session.ConcurrentSessionFilter;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import org.springframework.security.web.session.SimpleRedirectSessionInformationExpiredStrategy;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.annotation.Resource;

@Configuration
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().permitAll();
		http.csrf().disable();
		http.headers().disable();
//		http.sessionManagement().maximumSessions(1).maxSessionsPreventsLogin(true).sessionRegistry(sessionRegistry());
//		http.addFilterAt(usernamePasswordAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
		//session并发控制过滤器
//		http.addFilterAt(new ConcurrentSessionFilter(sessionRegistry,sessionInformationExpiredStrategy()),ConcurrentSessionFilter.class);
	}
	//session失效跳转
	private SessionInformationExpiredStrategy sessionInformationExpiredStrategy() {
		return new SimpleRedirectSessionInformationExpiredStrategy("/login");
	}
	@Bean
	public SessionRegistry sessionRegistry() {
		return new SessionRegistryImpl();
	}

//	private UsernamePasswordAuthenticationFilter usernamePasswordAuthenticationFilter() throws Exception {
//		UsernamePasswordAuthenticationFilter usernamePasswordAuthenticationFilter = new CuzUsernamePasswordAuthenticationFilter();
//		usernamePasswordAuthenticationFilter.setPostOnly(true);
//		usernamePasswordAuthenticationFilter.setAuthenticationManager(this.authenticationManager());
//		usernamePasswordAuthenticationFilter.setUsernameParameter("name_key");
//		usernamePasswordAuthenticationFilter.setPasswordParameter("pwd_key");
//		usernamePasswordAuthenticationFilter.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/checkLogin", "POST"));
//		usernamePasswordAuthenticationFilter.setAuthenticationFailureHandler(simpleUrlAuthenticationFailureHandler());
//		usernamePasswordAuthenticationFilter.setAuthenticationSuccessHandler(authenticationSuccessHandler());
//		//session并发控制,因为默认的并发控制方法是空方法.这里必须自己配置一个
//		usernamePasswordAuthenticationFilter.setSessionAuthenticationStrategy(new ConcurrentSessionControlAuthenticationStrategy(sessionRegistry));
//		return usernamePasswordAuthenticationFilter;
//	}
}