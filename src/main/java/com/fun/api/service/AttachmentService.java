package com.fun.api.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fun.api.domain.SysAttachment;
import com.fun.api.repository.AttachmentMapper;
import com.fun.api.repository.SysAttachmentMapper;
import com.fun.framework.service.BaseService;

import lombok.Synchronized;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AttachmentService extends BaseService {
	private @Autowired SysAttachmentMapper sysAttachmentMapper;
	private @Autowired AttachmentMapper attachmentMapper;

	@Cacheable(value = "cache-attachment-by-id", key = "'item-' + #id", unless = "#result eq null")
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public SysAttachment get(Long id) throws Exception {
		log.debug(">>>get");
		log.debug("<<<get");
		return attachmentMapper.getById(id);
	}

	@Synchronized
	@CachePut(value = "cache-attachment-by-id", key = "'item-' + #result.pkId")
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public SysAttachment upload(Long userId, String contentType, String fileName, byte[] data) throws Exception {
		log.debug(">>>upload");
		long pkId = attachmentMapper.getLastId();
		SysAttachment sysAttachment = new SysAttachment();
		sysAttachment.setPkId(pkId);
		sysAttachment.setMemId(userId);
		sysAttachment.setCreateTime(new Date());
		sysAttachment.setFileType(0);
		sysAttachment.setDocType(contentType);
		sysAttachment.setFileName(fileName);
		sysAttachment.setFileLength(data.length);
		sysAttachment.setFileData(data);

		sysAttachmentMapper.insert(sysAttachment);
		log.debug("<<<upload");
		return sysAttachment;
	}

}
