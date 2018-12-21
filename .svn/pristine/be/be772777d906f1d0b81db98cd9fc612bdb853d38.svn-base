package com.fun.le.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.fun.le.entities.LotOpenTime;
@Mapper
public interface LotOpenTimeMapper {
	Integer insert(@Param("lotOpenTime") LotOpenTime paramLotOpenTime);

	Integer insertBatch(@Param("lotOpenTimes") List<LotOpenTime> paramList);

	Integer update(@Param("lotOpenTime") LotOpenTime paramLotOpenTime1,
                   @Param("where") LotOpenTime paramLotOpenTime2);

	Integer updateById(@Param("lotOpenTime") LotOpenTime paramLotOpenTime,
                       @Param("lotOpenTimeId") Integer paramInteger);

	Integer updateActive(@Param("lotOpenTime") LotOpenTime paramLotOpenTime1,
                         @Param("where") LotOpenTime paramLotOpenTime2);

	Integer updateActiveById(@Param("lotOpenTime") LotOpenTime paramLotOpenTime,
                             @Param("lotOpenTimeId") Integer paramInteger);

	List<LotOpenTime> select(@Param("lotOpenTime") LotOpenTime paramLotOpenTime);

	LotOpenTime selectById(@Param("lotOpenTimeId") Integer paramInteger);

	Integer delete(@Param("where") LotOpenTime paramLotOpenTime);

	Integer deleteById(@Param("lotOpenTimeId") Integer paramInteger);
}
