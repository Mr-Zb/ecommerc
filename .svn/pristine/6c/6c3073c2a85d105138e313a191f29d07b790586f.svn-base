package com.fun.client.repository;

import com.fun.client.domain.FinRechargeLog;
import com.fun.framework.web.dto.QueryDto;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FinRechargeLogMapper {
	Integer insert(@Param("finRechargeLog") FinRechargeLog paramFinRechargeLog);

	Integer insertBatch(@Param("finRechargeLogs") List<FinRechargeLog> paramList);

	Integer update(@Param("finRechargeLog") FinRechargeLog paramFinRechargeLog1,
                   @Param("where") FinRechargeLog paramFinRechargeLog2);

	Integer updateById(@Param("finRechargeLog") FinRechargeLog paramFinRechargeLog,
                       @Param("finRechargeLogId") Integer paramInteger);

	Integer updateActive(@Param("finRechargeLog") FinRechargeLog paramFinRechargeLog1,
                         @Param("where") FinRechargeLog paramFinRechargeLog2);

	Integer updateActiveById(@Param("finRechargeLog") FinRechargeLog paramFinRechargeLog,
                             @Param("finRechargeLogId") Integer paramInteger);

	List<FinRechargeLog> select(@Param("finRechargeLog") FinRechargeLog paramFinRechargeLog);

	FinRechargeLog selectById(@Param("finRechargeLogId") Integer paramInteger);
	
	FinRechargeLog selectLastByUserId(@Param("memberId") Integer memberId);

	Integer delete(@Param("where") FinRechargeLog paramFinRechargeLog);

	Integer deleteById(@Param("finRechargeLogId") Integer paramInteger);

	Page<FinRechargeLog> selectFinRechargeList(@Param("finRechargeLog") FinRechargeLog finRechargeLog, @Param("where")QueryDto where);

	Integer rechargeCheck(@Param("rechargeState") Integer rechargeState,@Param("pkId") Integer pkId);

}
