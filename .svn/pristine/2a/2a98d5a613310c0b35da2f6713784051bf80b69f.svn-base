package com.fun.le.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.fun.le.entities.LotProductInfo;
@Mapper
public interface LotProductInfoMapper {
	Integer insert(@Param("lotProductInfo") LotProductInfo paramLotProductInfo);

	Integer insertBatch(@Param("lotProductInfos") List<LotProductInfo> paramList);

	Integer update(@Param("lotProductInfo") LotProductInfo paramLotProductInfo1,
                   @Param("where") LotProductInfo paramLotProductInfo2);

	Integer updateById(@Param("lotProductInfo") LotProductInfo paramLotProductInfo,
                       @Param("lotProductInfoId") Integer paramInteger);

	Integer updateActive(@Param("lotProductInfo") LotProductInfo paramLotProductInfo1,
                         @Param("where") LotProductInfo paramLotProductInfo2);

	Integer updateActiveById(@Param("lotProductInfo") LotProductInfo paramLotProductInfo,
                             @Param("lotProductInfoId") Integer paramInteger);

	List<LotProductInfo> select(@Param("lotProductInfo") LotProductInfo paramLotProductInfo);

	LotProductInfo selectById(@Param("lotProductInfoId") Integer paramInteger);

	Integer delete(@Param("where") LotProductInfo paramLotProductInfo);

	Integer deleteById(@Param("lotProductInfoId") Integer paramInteger);
}
