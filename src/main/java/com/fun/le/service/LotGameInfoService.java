package com.fun.le.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fun.framework.support.BusinessException;
import com.fun.le.entities.LotGameInfo;
import com.fun.le.repository.LotGameInfoMapper;

@Service
public class LotGameInfoService {

	@Autowired
	private LotGameInfoMapper lotGameInfoMapper;

	public Integer insert(Integer userId, LotGameInfo lotGameInfo) throws BusinessException {
		lotGameInfo.setCreateTime(new Date());
		lotGameInfo.setCreateUser(userId);
		lotGameInfo.setUpdateTime(new Date());
		lotGameInfo.setUpdateUser(userId);
		lotGameInfo.setDataVersion(Integer.valueOf(1));
		return this.lotGameInfoMapper.insert(lotGameInfo);
	}

	public Integer insert(Integer userId, List<LotGameInfo> lotGameInfos) throws BusinessException {
		for (LotGameInfo lotGameInfo : lotGameInfos) {
			lotGameInfo.setCreateTime(new Date());
			lotGameInfo.setCreateUser(userId);
			lotGameInfo.setUpdateTime(new Date());
			lotGameInfo.setUpdateUser(userId);
			lotGameInfo.setDataVersion(Integer.valueOf(1));
		}
		return this.lotGameInfoMapper.insertBatch(lotGameInfos);
	}

	public Integer update(Integer userId, LotGameInfo lotGameInfo, LotGameInfo where) throws BusinessException {
		lotGameInfo.setUpdateTime(new Date());
		lotGameInfo.setUpdateUser(userId);
		return this.lotGameInfoMapper.update(lotGameInfo, where);
	}

	public Integer updateById(Integer userId, LotGameInfo lotGameInfo, Integer lotGameInfoId) throws BusinessException {
		lotGameInfo.setUpdateTime(new Date());
		lotGameInfo.setUpdateUser(userId);
		return this.lotGameInfoMapper.updateById(lotGameInfo, lotGameInfoId);
	}

	public Integer updateActive(Integer userId, LotGameInfo lotGameInfo, LotGameInfo where) throws BusinessException {
		lotGameInfo.setUpdateTime(new Date());
		lotGameInfo.setUpdateUser(userId);
		return this.lotGameInfoMapper.updateActive(lotGameInfo, where);
	}

	public Integer updateActiveById(Integer userId, LotGameInfo lotGameInfo, Integer lotGameInfoId)
			throws BusinessException {
		lotGameInfo.setUpdateTime(new Date());
		lotGameInfo.setUpdateUser(userId);
		return this.lotGameInfoMapper.updateActiveById(lotGameInfo, lotGameInfoId);
	}

	public List<LotGameInfo> select(Integer userId, LotGameInfo lotGameInfo) throws BusinessException {
		return this.lotGameInfoMapper.select(lotGameInfo);
	}

	public LotGameInfo selectById(Integer userId, Integer lotGameInfoId) throws BusinessException {
		return this.lotGameInfoMapper.selectById(lotGameInfoId);
	}

	public Integer delete(Integer userId, LotGameInfo where) throws BusinessException {
		return this.lotGameInfoMapper.delete(where);
	}

	public Integer deleteById(Integer userId, Integer lotGameInfoId) throws BusinessException {
		return this.lotGameInfoMapper.deleteById(lotGameInfoId);
	}
}
