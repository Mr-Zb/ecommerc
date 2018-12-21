package com.fun.le.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fun.framework.support.BusinessException;
import com.fun.le.entities.SchSchemeInfo;
import com.fun.le.repository.SchSchemeInfoMapper;

@Service
public class SchSchemeInfoService {

	@Autowired
	private SchSchemeInfoMapper schSchemeInfoMapper;

	public Integer insert(Integer userId, SchSchemeInfo schSchemeInfo) throws BusinessException {
		schSchemeInfo.setCreateTime(new Date());
		schSchemeInfo.setCreateUser(userId);
		schSchemeInfo.setUpdateTime(new Date());
		schSchemeInfo.setUpdateUser(userId);
		schSchemeInfo.setDataVersion(Integer.valueOf(1));
		return this.schSchemeInfoMapper.insert(schSchemeInfo);
	}

	public Integer insert(Integer userId, List<SchSchemeInfo> schSchemeInfos) throws BusinessException {
		for (SchSchemeInfo schSchemeInfo : schSchemeInfos) {
			schSchemeInfo.setCreateTime(new Date());
			schSchemeInfo.setCreateUser(userId);
			schSchemeInfo.setUpdateTime(new Date());
			schSchemeInfo.setUpdateUser(userId);
			schSchemeInfo.setDataVersion(Integer.valueOf(1));
		}
		return this.schSchemeInfoMapper.insertBatch(schSchemeInfos);
	}

	public Integer update(Integer userId, SchSchemeInfo schSchemeInfo, SchSchemeInfo where) throws BusinessException {
		schSchemeInfo.setUpdateTime(new Date());
		schSchemeInfo.setUpdateUser(userId);
		return this.schSchemeInfoMapper.update(schSchemeInfo, where);
	}

	public Integer updateById(Integer userId, SchSchemeInfo schSchemeInfo, Integer schSchemeInfoId)
			throws BusinessException {
		schSchemeInfo.setUpdateTime(new Date());
		schSchemeInfo.setUpdateUser(userId);
		return this.schSchemeInfoMapper.updateById(schSchemeInfo, schSchemeInfoId);
	}

	public Integer updateActive(Integer userId, SchSchemeInfo schSchemeInfo, SchSchemeInfo where)
			throws BusinessException {
		schSchemeInfo.setUpdateTime(new Date());
		schSchemeInfo.setUpdateUser(userId);
		return this.schSchemeInfoMapper.updateActive(schSchemeInfo, where);
	}

	public Integer updateActiveById(Integer userId, SchSchemeInfo schSchemeInfo, Integer schSchemeInfoId)
			throws BusinessException {
		schSchemeInfo.setUpdateTime(new Date());
		schSchemeInfo.setUpdateUser(userId);
		return this.schSchemeInfoMapper.updateActiveById(schSchemeInfo, schSchemeInfoId);
	}

	public List<SchSchemeInfo> select(Integer userId, SchSchemeInfo schSchemeInfo) throws BusinessException {
		return this.schSchemeInfoMapper.select(schSchemeInfo);
	}

	public SchSchemeInfo selectById(Integer userId, Integer schSchemeInfoId) throws BusinessException {
		return this.schSchemeInfoMapper.selectById(schSchemeInfoId);
	}

	public Integer delete(Integer userId, SchSchemeInfo where) throws BusinessException {
		return this.schSchemeInfoMapper.delete(where);
	}

	public Integer deleteById(Integer userId, Integer schSchemeInfoId) throws BusinessException {
		return this.schSchemeInfoMapper.deleteById(schSchemeInfoId);
	}
}
