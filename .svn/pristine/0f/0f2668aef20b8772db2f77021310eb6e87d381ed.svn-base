package com.fun.framework.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fun.framework.domain.AjaxReturn;
import com.fun.framework.utils.StringUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ExceptionMappingAdvice {

	/**
	 * 参数验证
	 * 
	 * @param e
	 * @return
	 */
	@ExceptionHandler(value = MissingServletRequestParameterException.class)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public AjaxReturn exception(MissingServletRequestParameterException e) {
		return new AjaxReturn(501, "参数 [ <span class='blue'>" + e.getParameterName() + "</span> ] 不能为空", null);
	}

	/**
	 * 完整性验证
	 * 
	 * @param e
	 * @return
	 */
	@ExceptionHandler(value = IllegalArgumentException.class)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public AjaxReturn exception(IllegalArgumentException e) {
		String msg = e.getMessage();
		if (StringUtils.startsWith(msg, "msg:")) {
			msg = StringUtils.substring(msg, 4);
		} else {
			msg = "拒绝处理";
		}
		e.printStackTrace();
		return new AjaxReturn(501, msg, null);
	}

	/**
	 * 其它验证
	 * 
	 * @param throwable
	 * @return
	 */
	@ExceptionHandler(value = Throwable.class)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public AjaxReturn exception(Throwable throwable) {
		String msg = throwable.getMessage();
		if (StringUtils.startsWith(msg, "msg:")) {
			msg = StringUtils.substring(msg, 4);
		} else {
			msg = "拒绝处理";
		}
		log.error("错误", throwable);
		return new AjaxReturn(501, msg, null);
	}
}
