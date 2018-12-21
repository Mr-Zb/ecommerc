package com.fun.framework.web.support.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Log {
	/**
	 * 日志记录信息，可以使用的变量有({userId}会员变化--{userName}会员名称)
	 * 
	 * @return
	 */
	String info();

	/**
	 * 从请求参数时获取变量值
	 * 
	 * @return
	 */
	String[] params() default {};
}
