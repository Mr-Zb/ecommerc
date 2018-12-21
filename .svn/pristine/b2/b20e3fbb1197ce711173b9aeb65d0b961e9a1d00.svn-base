package com.fun.api.web.controller;

import com.fun.client.domain.MemUserInfo;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fun.api.domain.SysAttachment;
import com.fun.api.service.AttachmentService;
import com.fun.framework.domain.AjaxReturn;
import com.fun.framework.web.controller.BaseController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@Api(value = "attachment", consumes = "application/json", produces = "application/json", protocols = "http")
public class AttachmentController extends BaseController {
	private @Autowired AttachmentService attachmentService;

	/**
	 * 文件上传
	 * 
	 * @param file
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(path = { "/api/upload" }, method = { RequestMethod.GET, RequestMethod.POST })
	@ApiOperation(value = "upload", notes = "upload", response = MemUserInfo.class, httpMethod = "POST")
	public AjaxReturn upload(@RequestParam(value = "file", required = true) MultipartFile file) throws Exception {
		log.debug(">>upload");
		long userId = getAuthentication();
		Validate.isTrue(file != null && !file.isEmpty(), "msg:文件不能为空");
		byte[] data = file.getBytes();
		String contentType = file.getContentType();
		String fileName = file.getOriginalFilename();
		SysAttachment attachment = attachmentService.upload(userId, contentType, fileName, data);
		log.debug("<<upload");
		return new AjaxReturn(200, null, attachment.getPkId());
	}

	/**
	 * 原文件下载
	 *
	 * @param id
	 * @return
			 * @throws Exception
	 */
	@RequestMapping(path = { "/v1/{id}" }, method = { RequestMethod.GET, RequestMethod.POST })
	@ApiOperation(value = "upload", notes = "upload", response = MemUserInfo.class, httpMethod = "GET")
	public ResponseEntity<byte[]> download1(@PathVariable("id") Long id) throws Exception {
		SysAttachment attachment = attachmentService.get(id);
		if (attachment != null) {
			byte[] bytes = attachment.getFileData();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.valueOf(attachment.getDocType()));
			headers.setContentLength(bytes.length);
			headers.setCacheControl("max-age");
			headers.setExpires(Long.MAX_VALUE);
			return new ResponseEntity<byte[]>(bytes, headers, HttpStatus.OK);
		}
		return null;
	}
}
