package com.fun.client.repository;

import com.fun.client.domain.IntegralOrderInfo;
import com.fun.framework.web.dto.QueryDto;
import com.github.pagehelper.Page;
import javafx.scene.control.Pagination;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface IntegralOrderInfoMapper {

    Integer insert(@Param("integralOrderInfo") IntegralOrderInfo integralOrderInfo,Integer userId);

    Page<IntegralOrderInfo> selectById(@Param("integralOrderInfoId") Integer userId, QueryDto queryDto);

    Page<IntegralOrderInfo> selectExchange(@Param("integralOrderInfoId") Integer userId,QueryDto queryDto);

    Integer updateById(@Param("integralOrderInfoId") Integer userId);

    Double countUserIntegral(Integer userId);
}
