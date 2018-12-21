package com.fun.le.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fun.framework.support.BusinessException;
import com.fun.le.entities.LotProductInfo;
import com.fun.le.repository.LotProductInfoMapper;

@Service
public class LotProductInfoService {

	@Autowired
	private LotProductInfoMapper lotProductInfoMapper;

	public Integer insert(Integer userId, LotProductInfo lotProductInfo) throws BusinessException {
		lotProductInfo.setCreateTime(new Date());
		lotProductInfo.setCreateUser(userId);
		lotProductInfo.setUpdateTime(new Date());
		lotProductInfo.setUpdateUser(userId);
		lotProductInfo.setDataVersion(Integer.valueOf(1));
		return this.lotProductInfoMapper.insert(lotProductInfo);
	}

	public Integer insert(Integer userId, List<LotProductInfo> lotProductInfos) throws BusinessException {
		for (LotProductInfo lotProductInfo : lotProductInfos) {
			lotProductInfo.setCreateTime(new Date());
			lotProductInfo.setCreateUser(userId);
			lotProductInfo.setUpdateTime(new Date());
			lotProductInfo.setUpdateUser(userId);
			lotProductInfo.setDataVersion(Integer.valueOf(1));
		}
		return this.lotProductInfoMapper.insertBatch(lotProductInfos);
	}

	public Integer update(Integer userId, LotProductInfo lotProductInfo, LotProductInfo where)
			throws BusinessException {
		lotProductInfo.setUpdateTime(new Date());
		lotProductInfo.setUpdateUser(userId);
		return this.lotProductInfoMapper.update(lotProductInfo, where);
	}

	public Integer updateById(Integer userId, LotProductInfo lotProductInfo, Integer lotProductInfoId)
			throws BusinessException {
		lotProductInfo.setUpdateTime(new Date());
		lotProductInfo.setUpdateUser(userId);
		return this.lotProductInfoMapper.updateById(lotProductInfo, lotProductInfoId);
	}

	public Integer updateActive(Integer userId, LotProductInfo lotProductInfo, LotProductInfo where)
			throws BusinessException {
		lotProductInfo.setUpdateTime(new Date());
		lotProductInfo.setUpdateUser(userId);
		return this.lotProductInfoMapper.updateActive(lotProductInfo, where);
	}

	public Integer updateActiveById(Integer userId, LotProductInfo lotProductInfo, Integer lotProductInfoId)
			throws BusinessException {
		lotProductInfo.setUpdateTime(new Date());
		lotProductInfo.setUpdateUser(userId);
		return this.lotProductInfoMapper.updateActiveById(lotProductInfo, lotProductInfoId);
	}

	public List<LotProductInfo> select(Integer userId, LotProductInfo lotProductInfo) throws BusinessException {
		return this.lotProductInfoMapper.select(lotProductInfo);
	}

	public LotProductInfo selectById(Integer userId, Integer lotProductInfoId) throws BusinessException {
		return this.lotProductInfoMapper.selectById(lotProductInfoId);
	}

	public Integer delete(Integer userId, LotProductInfo where) throws BusinessException {
		return this.lotProductInfoMapper.delete(where);
	}

	public Integer deleteById(Integer userId, Integer lotProductInfoId) throws BusinessException {
		return this.lotProductInfoMapper.deleteById(lotProductInfoId);
	}
}
