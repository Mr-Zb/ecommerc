package com.fun.framework.web.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;

import com.alibaba.fastjson.support.spring.FastJsonpResponseBodyAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class JsonpResponseBodyAdvice extends FastJsonpResponseBodyAdvice {
	public JsonpResponseBodyAdvice() {
		super("callback", "jsonp"); // 指定jsonpParameterNames
		log.debug("启用JSONP");
	}
}
