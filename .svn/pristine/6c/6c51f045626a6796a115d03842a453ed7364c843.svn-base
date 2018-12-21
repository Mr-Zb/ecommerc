package com.fun.client.repository;

import com.fun.client.domain.OperationLog;
import com.fun.framework.web.dto.QueryDto;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OperationLogMapper{
	Integer insert(@Param("operationLog") OperationLog paramOperationLog);

	Integer insertBatch(@Param("operationLogs") List<OperationLog> paramList);

	Integer update(@Param("operationLog") OperationLog paramOperationLog1,
                   @Param("where") OperationLog paramOperationLog2);

	Integer updateById(@Param("operationLog") OperationLog paramOperationLog,
                       @Param("operationLogId") Integer paramInteger);

	List<OperationLog> select(@Param("operationLog") OperationLog paramOperationLog);

	List<OperationLog> selectOperationLogById(@Param("operationLogId") Integer memberId);
	
	Page<OperationLog> listOperationLog(@Param("operationLog") OperationLog operationLog, @Param("where") QueryDto queryDto);

	OperationLog selectById(@Param("operationLogId") Integer paramInteger);
	
}