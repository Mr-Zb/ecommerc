package com.fun.le.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fun.framework.support.BusinessException;
import com.fun.le.entities.LotLotteryIssue;
import com.fun.le.repository.LotLotteryIssueMapper;

@Service
public class LotLotteryIssueService  {

	@Autowired
	private LotLotteryIssueMapper lotLotteryIssueMapper;

	public Integer insert(Integer userId, LotLotteryIssue lotLotteryIssue) throws BusinessException {
		lotLotteryIssue.setCreateTime(new Date());
		lotLotteryIssue.setCreateUser(userId);
		lotLotteryIssue.setUpdateTime(new Date());
		lotLotteryIssue.setUpdateUser(userId);
		lotLotteryIssue.setDataVersion(Integer.valueOf(1));
		return this.lotLotteryIssueMapper.insert(lotLotteryIssue);
	}

	public Integer insert(Integer userId, List<LotLotteryIssue> lotLotteryIssues) throws BusinessException {
		for (LotLotteryIssue lotLotteryIssue : lotLotteryIssues) {
			lotLotteryIssue.setCreateTime(new Date());
			lotLotteryIssue.setCreateUser(userId);
			lotLotteryIssue.setUpdateTime(new Date());
			lotLotteryIssue.setUpdateUser(userId);
			lotLotteryIssue.setDataVersion(Integer.valueOf(1));
		}
		return this.lotLotteryIssueMapper.insertBatch(lotLotteryIssues);
	}

	public Integer update(Integer userId, LotLotteryIssue lotLotteryIssue, LotLotteryIssue where)
			throws BusinessException {
		lotLotteryIssue.setUpdateTime(new Date());
		lotLotteryIssue.setUpdateUser(userId);
		return this.lotLotteryIssueMapper.update(lotLotteryIssue, where);
	}

	public Integer updateById(Integer userId, LotLotteryIssue lotLotteryIssue, Long lotLotteryIssueId)
			throws BusinessException {
		lotLotteryIssue.setUpdateTime(new Date());
		lotLotteryIssue.setUpdateUser(userId);
		return this.lotLotteryIssueMapper.updateById(lotLotteryIssue, lotLotteryIssueId);
	}

	public Integer updateActive(Integer userId, LotLotteryIssue lotLotteryIssue, LotLotteryIssue where)
			throws BusinessException {
		lotLotteryIssue.setUpdateTime(new Date());
		lotLotteryIssue.setUpdateUser(userId);
		return this.lotLotteryIssueMapper.updateActive(lotLotteryIssue, where);
	}

	public Integer updateActiveById(Integer userId, LotLotteryIssue lotLotteryIssue, Long lotLotteryIssueId)
			throws BusinessException {
		lotLotteryIssue.setUpdateTime(new Date());
		lotLotteryIssue.setUpdateUser(userId);
		return this.lotLotteryIssueMapper.updateActiveById(lotLotteryIssue, lotLotteryIssueId);
	}

	public List<LotLotteryIssue> select(Integer userId, LotLotteryIssue lotLotteryIssue) throws BusinessException {
		return this.lotLotteryIssueMapper.select(lotLotteryIssue);
	}

	public LotLotteryIssue selectById(Integer userId, Long lotLotteryIssueId) throws BusinessException {
		return this.lotLotteryIssueMapper.selectById(lotLotteryIssueId);
	}

	public Integer delete(Integer userId, LotLotteryIssue where) throws BusinessException {
		return this.lotLotteryIssueMapper.delete(where);
	}

	public Integer deleteById(Integer userId, Long lotLotteryIssueId) throws BusinessException {
		return this.lotLotteryIssueMapper.deleteById(lotLotteryIssueId);
	}
}
