package com.fun.framework.configure;

import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ValueFilter;
import com.alibaba.fastjson.support.spring.FastJsonpHttpMessageConverter4;
import com.fun.framework.utils.NumberUtils;
import com.fun.framework.web.support.interceptor.SecureHandlerInterceptorAdapter;

@Configuration
public class WebMvcConfigure extends WebMvcConfigurerAdapter {
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.clear();
		// 转换为utf-8编码，防止乱码
		StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
		stringHttpMessageConverter.setWriteAcceptCharset(false);
		stringHttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON_UTF8, MediaType.APPLICATION_JSON));
		converters.add(stringHttpMessageConverter);

		// 允许字节下载
		ByteArrayHttpMessageConverter byteArrayHttpMessageConverter = new ByteArrayHttpMessageConverter();
		converters.add(byteArrayHttpMessageConverter);

		// 使用fastjson输出json
		ValueFilter filter = new ValueFilter() {
			@Override
			public Object process(Object object, String name, Object value) {
				if (value instanceof BigDecimal || value instanceof Double || value instanceof Float) {
					return new BigDecimal(Math.round(NumberUtils.toDouble(value.toString()) * 10000d) / 10000d);
				}
				return value;
			}
		};
		FastJsonpHttpMessageConverter4 fastJsonHttpMessageConverter4 = new FastJsonpHttpMessageConverter4();
		fastJsonHttpMessageConverter4.getFastJsonConfig().setSerializerFeatures(SerializerFeature.BrowserCompatible);
		converters.add(fastJsonHttpMessageConverter4);
		super.configureMessageConverters(converters);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
		registry.addInterceptor(secureHandlerInterceptorAdapter()).addPathPatterns("/api/**");
		super.addInterceptors(registry);
	}

	/**
	 * 国际化配置
	 * 
	 * @return
	 */
	@Bean
	public LocaleResolver localeResolver() {
		CookieLocaleResolver slr = new CookieLocaleResolver();
		// 设置默认区域,
		slr.setDefaultLocale(Locale.CHINA);
		slr.setCookieMaxAge(3600);// 设置cookie有效期.
		return slr;
	}

	/**
	 * 国际化
	 * 
	 * @return
	 */
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
		// 设置请求地址的参数,默认为：locale
		lci.setParamName(LocaleChangeInterceptor.DEFAULT_PARAM_NAME);
		return lci;
	}

	/**
	 * 国际化
	 * 
	 * @return
	 */
	@Bean
	public SecureHandlerInterceptorAdapter secureHandlerInterceptorAdapter() {
		SecureHandlerInterceptorAdapter interceptor = new SecureHandlerInterceptorAdapter();
		return interceptor;
	}

	/**
	 * 跨域访问能力
	 *
	 * @return
	 */
	@Bean
	public CorsFilter corsFilter() {
		final UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		final CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.addAllowedOrigin("*");
		corsConfiguration.addAllowedHeader("*");
		corsConfiguration.addAllowedMethod("*");
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}
}
