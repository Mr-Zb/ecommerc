package com.fun.client.service;

import java.util.Date;
import java.util.List;

import com.fun.client.domain.MemLoginLog;
import com.fun.client.repository.MemLoginLogMapper;
import com.fun.framework.domain.Pagination;
import com.fun.framework.web.dto.QueryDto;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemLoginLogService{

	@Autowired
	private MemLoginLogMapper memLoginLogMapper;

	public Integer insert(Integer userId, MemLoginLog memLoginLog){
		memLoginLog.setCreateTime(new Date());
		memLoginLog.setCreateUser(userId);
		memLoginLog.setUpdateTime(new Date());
		memLoginLog.setUpdateUser(userId);
		memLoginLog.setDataVersion(Integer.valueOf(1));
		return this.memLoginLogMapper.insert(memLoginLog);
	}

	public Integer insert(Integer userId, List<MemLoginLog> memLoginLogs) {
		for (MemLoginLog memLoginLog : memLoginLogs) {
			memLoginLog.setCreateTime(new Date());
			memLoginLog.setCreateUser(userId);
			memLoginLog.setUpdateTime(new Date());
			memLoginLog.setUpdateUser(userId);
			memLoginLog.setDataVersion(Integer.valueOf(1));
		}
		return this.memLoginLogMapper.insertBatch(memLoginLogs);
	}

	public Integer update(Integer userId, MemLoginLog memLoginLog, MemLoginLog where) {
		memLoginLog.setUpdateTime(new Date());
		memLoginLog.setUpdateUser(userId);
		return this.memLoginLogMapper.update(memLoginLog, where);
	}

	public Integer updateById(Integer userId, MemLoginLog memLoginLog, Integer memLoginLogId){
		memLoginLog.setUpdateTime(new Date());
		memLoginLog.setUpdateUser(userId);
		return this.memLoginLogMapper.updateById(memLoginLog, memLoginLogId);
	}

	public Integer updateActive(Integer userId, MemLoginLog memLoginLog, MemLoginLog where){
		memLoginLog.setUpdateTime(new Date());
		memLoginLog.setUpdateUser(userId);
		return this.memLoginLogMapper.updateActive(memLoginLog, where);
	}

	public Integer updateActiveById(Integer userId, MemLoginLog memLoginLog, Integer memLoginLogId){
		memLoginLog.setUpdateTime(new Date());
		memLoginLog.setUpdateUser(userId);
		return this.memLoginLogMapper.updateActiveById(memLoginLog, memLoginLogId);
	}

	public List<MemLoginLog> select(Integer userId, MemLoginLog memLoginLog) {
		return this.memLoginLogMapper.select(memLoginLog);
	}

	public MemLoginLog selectById(Integer userId, Integer memLoginLogId){
		return this.memLoginLogMapper.selectById(memLoginLogId);
	}

	public Integer delete(Integer userId, MemLoginLog where){
		return this.memLoginLogMapper.delete(where);
	}

	public Integer deleteById(Integer userId, Integer memLoginLogId){
		return this.memLoginLogMapper.deleteById(memLoginLogId);
	}

	public Pagination<MemLoginLog> listLoginRecords(MemLoginLog loginLog,QueryDto queryDto){
		PageHelper.startPage(queryDto.getPage(), queryDto.getRows(), true);
		if (queryDto.getBeginDate() != null) {
			queryDto.setBeginDate(new DateTime(queryDto.getBeginDate()).withTime(0, 0, 0, 0).toDate());
		}
		if (queryDto.getEndDate() != null) {
			queryDto.setEndDate(new DateTime(queryDto.getEndDate()).withTime(23, 59, 59, 999).toDate());
		}
		Page<MemLoginLog> page = this.memLoginLogMapper.listLoginRecords(loginLog,queryDto);
		return new Pagination<>(page.getTotal(), page.getResult());
	}
}
