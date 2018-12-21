package com.fun.le.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fun.framework.support.BusinessException;
import com.fun.le.entities.LotOpenTime;
import com.fun.le.repository.LotOpenTimeMapper;

@Service
public class LotOpenTimeService  {

	@Autowired
	private LotOpenTimeMapper lotOpenTimeMapper;

	public Integer insert(Integer userId, LotOpenTime lotOpenTime) throws BusinessException {
		lotOpenTime.setCreateTime(new Date());
		lotOpenTime.setCreateUser(userId);
		lotOpenTime.setUpdateTime(new Date());
		lotOpenTime.setUpdateUser(userId);
		lotOpenTime.setDataVersion(Integer.valueOf(1));
		return this.lotOpenTimeMapper.insert(lotOpenTime);
	}

	public Integer insert(Integer userId, List<LotOpenTime> lotOpenTimes) throws BusinessException {
		for (LotOpenTime lotOpenTime : lotOpenTimes) {
			lotOpenTime.setCreateTime(new Date());
			lotOpenTime.setCreateUser(userId);
			lotOpenTime.setUpdateTime(new Date());
			lotOpenTime.setUpdateUser(userId);
			lotOpenTime.setDataVersion(Integer.valueOf(1));
		}
		return this.lotOpenTimeMapper.insertBatch(lotOpenTimes);
	}

	public Integer update(Integer userId, LotOpenTime lotOpenTime, LotOpenTime where) throws BusinessException {
		lotOpenTime.setUpdateTime(new Date());
		lotOpenTime.setUpdateUser(userId);
		return this.lotOpenTimeMapper.update(lotOpenTime, where);
	}

	public Integer updateById(Integer userId, LotOpenTime lotOpenTime, Integer lotOpenTimeId) throws BusinessException {
		lotOpenTime.setUpdateTime(new Date());
		lotOpenTime.setUpdateUser(userId);
		return this.lotOpenTimeMapper.updateById(lotOpenTime, lotOpenTimeId);
	}

	public Integer updateActive(Integer userId, LotOpenTime lotOpenTime, LotOpenTime where) throws BusinessException {
		lotOpenTime.setUpdateTime(new Date());
		lotOpenTime.setUpdateUser(userId);
		return this.lotOpenTimeMapper.updateActive(lotOpenTime, where);
	}

	public Integer updateActiveById(Integer userId, LotOpenTime lotOpenTime, Integer lotOpenTimeId)
			throws BusinessException {
		lotOpenTime.setUpdateTime(new Date());
		lotOpenTime.setUpdateUser(userId);
		return this.lotOpenTimeMapper.updateActiveById(lotOpenTime, lotOpenTimeId);
	}

	public List<LotOpenTime> select(Integer userId, LotOpenTime lotOpenTime) throws BusinessException {
		return this.lotOpenTimeMapper.select(lotOpenTime);
	}

	public LotOpenTime selectById(Integer userId, Integer lotOpenTimeId) throws BusinessException {
		return this.lotOpenTimeMapper.selectById(lotOpenTimeId);
	}

	public Integer delete(Integer userId, LotOpenTime where) throws BusinessException {
		return this.lotOpenTimeMapper.delete(where);
	}

	public Integer deleteById(Integer userId, Integer lotOpenTimeId) throws BusinessException {
		return this.lotOpenTimeMapper.deleteById(lotOpenTimeId);
	}
}
