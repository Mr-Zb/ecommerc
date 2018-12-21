package com.fun.client.service;

import java.util.Date;
import java.util.List;

import com.fun.client.domain.OperationLog;
import com.fun.client.repository.OperationLogMapper;
import com.fun.framework.domain.Pagination;
import com.fun.framework.web.dto.QueryDto;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OperationLogService{

	@Autowired
	private OperationLogMapper operationLogMapper;

	public Integer insert(Integer userId, OperationLog operationLog){
		operationLog.setCreateTime(new Date());
		operationLog.setCreateUser(userId);
		operationLog.setUpdateTime(new Date());
		operationLog.setUpdateUser(userId);
		operationLog.setDataVersion(Integer.valueOf(1));

		return this.operationLogMapper.insert(operationLog);
	}


	public Integer insert(Integer userId, List<OperationLog> operationLogs){
			((OperationLog) operationLogs).setCreateTime(new Date());
			((OperationLog) operationLogs).setCreateUser(userId);
			((OperationLog) operationLogs).setUpdateTime(new Date());
			((OperationLog) operationLogs).setUpdateUser(userId);
			((OperationLog) operationLogs).setDataVersion(Integer.valueOf(1));
			return this.operationLogMapper.insert((OperationLog) operationLogs);
	}


	public Integer update(Integer userId, OperationLog paramOperationLog1, OperationLog paramOperationLog2){
		paramOperationLog1.setUpdateTime(new Date());
		paramOperationLog1.setUpdateUser(userId);
		return this.operationLogMapper.update(paramOperationLog1, paramOperationLog2);
	}


	public Integer updateById(Integer paramInteger1, OperationLog paramOperationLog, Integer paramInteger2){
		paramOperationLog.setUpdateTime(new Date());
		paramOperationLog.setUpdateUser(paramInteger1);
		return this.operationLogMapper.updateById(paramOperationLog, paramInteger2);
	}


	public List<OperationLog> select(Integer paramInteger, OperationLog paramOperationLog){
		return this.operationLogMapper.select(paramOperationLog);
	}


	public OperationLog selectById(Integer paramInteger ){
		return this.operationLogMapper.selectById(paramInteger);
	}
	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Pagination<OperationLog> listOperationLog(OperationLog operationLog, QueryDto queryDto){
		PageHelper.startPage(queryDto.getPage(), queryDto.getRows(), true);
		if(queryDto.getBeginDate() != null){
			queryDto.setBeginDate(new DateTime(queryDto.getBeginDate()).withTime(0, 0, 0, 0).toDate());
		}
		if (queryDto.getEndDate() != null) {
			queryDto.setEndDate(new DateTime(queryDto.getEndDate()).withTime(23, 59, 59, 999).toDate());
		}
		Page<OperationLog> page = this.operationLogMapper.listOperationLog(operationLog, queryDto);
		return new Pagination<>(page.getTotal(),page.getResult());
	}


	public Integer updateActiveById(Integer paramInteger1, OperationLog paramOperationLog, Integer paramInteger2){
		// TODO Auto-generated method stub
		return null;
	}
}
