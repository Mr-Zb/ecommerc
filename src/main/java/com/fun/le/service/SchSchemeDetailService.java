package com.fun.le.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fun.framework.support.BusinessException;
import com.fun.le.entities.SchSchemeDetail;
import com.fun.le.repository.SchSchemeDetailMapper;

@Service
public class SchSchemeDetailService  {

	@Autowired
	private SchSchemeDetailMapper schSchemeDetailMapper;

	public Integer insert(Integer userId, SchSchemeDetail schSchemeDetail) throws BusinessException {
		schSchemeDetail.setCreateTime(new Date());
		schSchemeDetail.setCreateUser(userId);
		schSchemeDetail.setUpdateTime(new Date());
		schSchemeDetail.setUpdateUser(userId);
		schSchemeDetail.setDataVersion(Integer.valueOf(1));
		return this.schSchemeDetailMapper.insert(schSchemeDetail);
	}

	public Integer insert(Integer userId, List<SchSchemeDetail> schSchemeDetails) throws BusinessException {
		for (SchSchemeDetail schSchemeDetail : schSchemeDetails) {
			schSchemeDetail.setCreateTime(new Date());
			schSchemeDetail.setCreateUser(userId);
			schSchemeDetail.setUpdateTime(new Date());
			schSchemeDetail.setUpdateUser(userId);
			schSchemeDetail.setDataVersion(Integer.valueOf(1));
		}
		return this.schSchemeDetailMapper.insertBatch(schSchemeDetails);
	}

	public Integer update(Integer userId, SchSchemeDetail schSchemeDetail, SchSchemeDetail where)
			throws BusinessException {
		schSchemeDetail.setUpdateTime(new Date());
		schSchemeDetail.setUpdateUser(userId);
		return this.schSchemeDetailMapper.update(schSchemeDetail, where);
	}

	public Integer updateById(Integer userId, SchSchemeDetail schSchemeDetail, Integer schSchemeDetailId)
			throws BusinessException {
		schSchemeDetail.setUpdateTime(new Date());
		schSchemeDetail.setUpdateUser(userId);
		return this.schSchemeDetailMapper.updateById(schSchemeDetail, schSchemeDetailId);
	}

	public Integer updateActive(Integer userId, SchSchemeDetail schSchemeDetail, SchSchemeDetail where)
			throws BusinessException {
		schSchemeDetail.setUpdateTime(new Date());
		schSchemeDetail.setUpdateUser(userId);
		return this.schSchemeDetailMapper.updateActive(schSchemeDetail, where);
	}

	public Integer updateActiveById(Integer userId, SchSchemeDetail schSchemeDetail, Integer schSchemeDetailId)
			throws BusinessException {
		schSchemeDetail.setUpdateTime(new Date());
		schSchemeDetail.setUpdateUser(userId);
		return this.schSchemeDetailMapper.updateActiveById(schSchemeDetail, schSchemeDetailId);
	}

	public List<SchSchemeDetail> select(Integer userId, SchSchemeDetail schSchemeDetail) throws BusinessException {
		return this.schSchemeDetailMapper.select(schSchemeDetail);
	}
	
	public SchSchemeDetail selectById(Integer userId, Integer schSchemeDetailId) throws BusinessException {
		return this.schSchemeDetailMapper.selectById(schSchemeDetailId);
	}
	//
	public List<SchSchemeDetail> selectBySchemeId(Integer userId, Integer schSchemeDetailId,Integer userId1) throws BusinessException {
		return this.schSchemeDetailMapper.selectBySchemeId(schSchemeDetailId,userId1);
	}


	public Integer delete(Integer userId, SchSchemeDetail where) throws BusinessException {
		return this.schSchemeDetailMapper.delete(where);
	}

	public Integer deleteById(Integer userId, Integer schSchemeDetailId) throws BusinessException {
		return this.schSchemeDetailMapper.deleteById(schSchemeDetailId);
	}
}
