package com.fun.le.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.fun.le.entities.LotGameInfo;
@Mapper
public interface LotGameInfoMapper {
	Integer insert(@Param("lotGameInfo") LotGameInfo paramLotGameInfo);

	Integer insertBatch(@Param("lotGameInfos") List<LotGameInfo> paramList);

	Integer update(@Param("lotGameInfo") LotGameInfo paramLotGameInfo1,
                   @Param("where") LotGameInfo paramLotGameInfo2);

	Integer updateById(@Param("lotGameInfo") LotGameInfo paramLotGameInfo,
                       @Param("lotGameInfoId") Integer paramInteger);

	Integer updateActive(@Param("lotGameInfo") LotGameInfo paramLotGameInfo1,
                         @Param("where") LotGameInfo paramLotGameInfo2);

	Integer updateActiveById(@Param("lotGameInfo") LotGameInfo paramLotGameInfo,
                             @Param("lotGameInfoId") Integer paramInteger);

	List<LotGameInfo> select(@Param("lotGameInfo") LotGameInfo paramLotGameInfo);

	LotGameInfo selectById(@Param("lotGameInfoId") Integer paramInteger);

	Integer delete(@Param("where") LotGameInfo paramLotGameInfo);

	Integer deleteById(@Param("lotGameInfoId") Integer paramInteger);
}
