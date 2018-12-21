package com.fun.client.repository;


import com.fun.client.domain.ThreePayInfo;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface ThreePayInfoMapper {
	Integer updateById(@Param("threePayInfo") ThreePayInfo threePayInfo);
	Integer insert(@Param("threePayInfo") ThreePayInfo threePayInfo);
	Page<ThreePayInfo> select(@Param("threePayInfo") ThreePayInfo threePayInfo);
	List<ThreePayInfo> selectA(@Param("threePayInfo") ThreePayInfo threePayInfo);
	ThreePayInfo selectById(@Param("pkId") Integer pkId);
	List<ThreePayInfo> selectByState(@Param("threePayInfo") ThreePayInfo threePayInfo);
	Integer deleteById(@Param("threePayInfoId") Integer threePayInfoId);
	List<ThreePayInfo> selectByPlatformId(@Param("platformId") Integer platformId);
	List<ThreePayInfo> selectByName(@Param("threePayInfo") ThreePayInfo threePayInfo);
}
