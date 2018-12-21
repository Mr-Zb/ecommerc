package com.fun.api.service;

import com.fun.client.domain.MemUserInfo;
import com.fun.client.repository.MemUserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fun.framework.service.BaseService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LoginService extends BaseService {
	private @Autowired MemUserInfoMapper memUserInfoMapper;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public MemUserInfo findByUserName(String userName) throws Exception {
		MemUserInfo memUserInfo = memUserInfoMapper.selectLoginName(userName);
		return memUserInfo;
	}

}
