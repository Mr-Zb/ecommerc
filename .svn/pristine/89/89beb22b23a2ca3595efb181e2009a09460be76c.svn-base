package com.fun.client.repository;

import com.fun.client.domain.MemLoginLog;
import com.fun.framework.web.dto.QueryDto;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MemLoginLogMapper {
	Integer insert(@Param("memLoginLog") MemLoginLog paramMemLoginLog);

	Integer insertBatch(@Param("memLoginLogs") List<MemLoginLog> paramList);

	Integer update(@Param("memLoginLog") MemLoginLog paramMemLoginLog1,
                   @Param("where") MemLoginLog paramMemLoginLog2);

	Integer updateById(@Param("memLoginLog") MemLoginLog paramMemLoginLog,
                       @Param("memLoginLogId") Integer paramInteger);

	Integer updateActive(@Param("memLoginLog") MemLoginLog paramMemLoginLog1,
                         @Param("where") MemLoginLog paramMemLoginLog2);

	Integer updateActiveById(@Param("memLoginLog") MemLoginLog paramMemLoginLog,
                             @Param("memLoginLogId") Integer paramInteger);

	List<MemLoginLog> select(@Param("memLoginLog") MemLoginLog paramMemLoginLog);

	MemLoginLog selectById(@Param("memLoginLogId") Integer paramInteger);

	Integer delete(@Param("where") MemLoginLog paramMemLoginLog);

	Integer deleteById(@Param("memLoginLogId") Integer paramInteger);

	Page<MemLoginLog> listLoginRecords(@Param("loginLog") MemLoginLog loginLog,@Param("where") QueryDto where);
}
