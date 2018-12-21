package com.fun.le.service;

import java.util.Date;
import java.util.List;

import com.fun.framework.domain.Pagination;
import com.fun.framework.web.dto.QueryDto;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fun.framework.support.BusinessException;
import com.fun.le.entities.SchSchemeIssue;
import com.fun.le.repository.SchSchemeIssueMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SchSchemeIssueService {

	@Autowired
	private SchSchemeIssueMapper schSchemeIssueMapper;

	public Integer insert(Integer userId, SchSchemeIssue schSchemeIssue) throws BusinessException {
		schSchemeIssue.setCreateTime(new Date());
		schSchemeIssue.setCreateUser(userId);
		schSchemeIssue.setUpdateTime(new Date());
		schSchemeIssue.setUpdateUser(userId);
		schSchemeIssue.setDataVersion(Integer.valueOf(1));
		return this.schSchemeIssueMapper.insert(schSchemeIssue);
	}

	public Integer insert(Integer userId, List<SchSchemeIssue> schSchemeIssues) throws BusinessException {
		for (SchSchemeIssue schSchemeIssue : schSchemeIssues) {
			schSchemeIssue.setCreateTime(new Date());
			schSchemeIssue.setCreateUser(userId);
			schSchemeIssue.setUpdateTime(new Date());
			schSchemeIssue.setUpdateUser(userId);
			schSchemeIssue.setDataVersion(Integer.valueOf(1));
		}
		return this.schSchemeIssueMapper.insertBatch(schSchemeIssues);
	}

	public Integer update(Integer userId, SchSchemeIssue schSchemeIssue, SchSchemeIssue where)
			throws BusinessException {
		schSchemeIssue.setUpdateTime(new Date());
		schSchemeIssue.setUpdateUser(userId);
		return this.schSchemeIssueMapper.update(schSchemeIssue, where);
	}

	public Integer updateById(Integer userId, SchSchemeIssue schSchemeIssue, Integer schSchemeIssueId)
			throws BusinessException {
		schSchemeIssue.setUpdateTime(new Date());
		schSchemeIssue.setUpdateUser(userId);
		return this.schSchemeIssueMapper.updateById(schSchemeIssue, schSchemeIssueId);
	}

	public Integer updateActive(Integer userId, SchSchemeIssue schSchemeIssue, SchSchemeIssue where)
			throws BusinessException {
		schSchemeIssue.setUpdateTime(new Date());
		schSchemeIssue.setUpdateUser(userId);
		return this.schSchemeIssueMapper.updateActive(schSchemeIssue, where);
	}

	public Integer updateActiveById(Integer userId, SchSchemeIssue schSchemeIssue, Integer schSchemeIssueId)
			throws BusinessException {
		schSchemeIssue.setUpdateTime(new Date());
		schSchemeIssue.setUpdateUser(userId);
		return this.schSchemeIssueMapper.updateActiveById(schSchemeIssue, schSchemeIssueId);
	}

	public List<SchSchemeIssue> select(Integer userId, SchSchemeIssue schSchemeIssue) throws BusinessException {
		return this.schSchemeIssueMapper.select(schSchemeIssue);
	}

	public SchSchemeIssue selectById(Integer schSchemeIssueId) throws BusinessException {
		return this.schSchemeIssueMapper.selectById(schSchemeIssueId);
	}

	public Integer delete(Integer userId, SchSchemeIssue where) throws BusinessException {
		return this.schSchemeIssueMapper.delete(where);
	}

	public Integer deleteById(Integer userId, Integer schSchemeIssueId) throws BusinessException {
		return this.schSchemeIssueMapper.deleteById(schSchemeIssueId);
	}


	@Transactional(propagation = Propagation.SUPPORTS, rollbackFor = { Exception.class }, readOnly = true)
	public Pagination<SchSchemeIssue> listIssues(QueryDto queryDto)
			throws BusinessException {
		PageHelper.startPage(queryDto.getPage(), queryDto.getRows(), true);
		Page<SchSchemeIssue> page = this.schSchemeIssueMapper.listIssues(queryDto);
		return new Pagination<>(page.getTotal(), page.getResult());
	}

}
