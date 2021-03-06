package com.fun;

import java.util.Properties;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.scheduling.annotation.EnableAsync;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication
//@ServletComponentScan
@MapperScan(basePackages = {"com.fun.admin.repository","com.fun.api.repository","com.fun.client.repository","com.fun.le.repository"})
@EnableAsync
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	/**
	 * 文件上传临时路径
	 */
	@Bean
	MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		factory.setLocation("/www/wwwroot/sjy999.com/images");
		return factory.createMultipartConfig();
	}
	@Bean(name = "captchaProducer")
	public DefaultKaptcha getKaptchaBean() {
		DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
		Properties properties = new Properties();
		properties.setProperty("kaptcha.border", "no");
		properties.setProperty("kaptcha.border.color", "105,179,90");
		properties.setProperty("kaptcha.textproducer.font.color", "blue");
		properties.setProperty("kaptcha.image.width", "150");
		properties.setProperty("kaptcha.image.height", "50");
		properties.setProperty("kaptcha.noise.color", "yellow");
		properties.setProperty("kaptcha.session.key", "code");
		properties.setProperty("kaptcha.textproducer.char.length", "4");
		properties.setProperty("kaptcha.textproducer.font.names", "Arial, Courier");
		properties.setProperty("kaptcha.background.clear.from", "white");
		properties.setProperty("kaptcha.background.clear.to", "white");
		properties.setProperty("kaptcha.textproducer.char.string", "0123456789");
		properties.setProperty("kaptcha.textproducer.font.size", "45");
		properties.setProperty("kaptcha.textproducer.char.space", "5");
		Config config = new Config(properties);
		defaultKaptcha.setConfig(config);
		return defaultKaptcha;
}
}
