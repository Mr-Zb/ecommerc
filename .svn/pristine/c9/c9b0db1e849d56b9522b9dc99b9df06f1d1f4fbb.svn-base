package com.fun.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fun.api.domain.AdminPayInfoQueryDto;
import com.fun.api.domain.PayInfo;
import com.fun.api.repository.AdminPayInfoMapper;
import com.fun.framework.domain.Pagination;
import com.fun.framework.service.BaseService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class AdminPayInfoService extends BaseService {
	private @Autowired AdminPayInfoMapper adminPayInfoMapper;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Pagination<PayInfo> listPayInfos(Long userId, AdminPayInfoQueryDto queryDto) throws Exception {
		
		PageHelper.startPage(queryDto.getPage(), queryDto.getRows(), true);
		Page<PayInfo> page = adminPayInfoMapper.listPayInfos(queryDto);
		
		return new Pagination<PayInfo>(page.getTotal(), page.getResult());
	}

}
