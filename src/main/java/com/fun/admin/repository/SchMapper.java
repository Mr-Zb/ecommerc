package com.fun.admin.repository;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.fun.admin.dto.BuyDetailsDto;
import com.fun.admin.dto.WinningDetailsDto;
import com.fun.framework.web.dto.QueryDto;
import com.fun.le.entities.SchSchemeInfo;
import com.github.pagehelper.Page;
@Mapper
public interface SchMapper
{
  Page<SchSchemeInfo> listTogeterList(@Param("userId") Integer paramInteger1, @Param("prodId") Integer paramInteger2, @Param("minSchedule") Integer paramInteger3, @Param("maxSchedule") Integer paramInteger4, @Param("minAmount") Double paramDouble1, @Param("maxAmount") Double paramDouble2, @Param("member") String paramString);

  Page<SchSchemeInfo> listTogeterList1(@Param("userId") Integer paramInteger1, @Param("prodId") Integer paramInteger2, @Param("minSchedule") Integer paramInteger3, @Param("maxSchedule") Integer paramInteger4, @Param("minAmount") Double paramDouble1, @Param("maxAmount") Double paramDouble2, @Param("member") String paramString);

  
  List<SchSchemeInfo> listSchemesForEndTask(@Param("endTime") Date paramDate);

  List<SchSchemeInfo> listSchemesForRewardTask(@Param("openTime") Date paramDate);

  Page<SchSchemeInfo> listSchemeDetails(@Param("offerType") Integer paramInteger, @Param("scheme") SchSchemeInfo paramSchSchemeInfo, @Param("where") QueryDto queryDto);
//
  List<SchSchemeInfo> listSchemeDetailsNew(@Param("offerType") Integer paramInteger, @Param("scheme") SchSchemeInfo paramSchSchemeInfo, @Param("where") QueryDto queryDto);

  Page<BuyDetailsDto> listBuyDetails(@Param("offerType") Integer paramInteger, @Param("scheme") BuyDetailsDto paramBuyDetailsDto, @Param("where") QueryDto queryDto);
//
  List<BuyDetailsDto> listBuyDetailsNew(@Param("where") QueryDto queryDto);
  Page<WinningDetailsDto> winningdetails(@Param("offerType") Integer paramInteger, @Param("scheme") WinningDetailsDto paramWinningDetailsDto, @Param("where") QueryDto queryDto);
}