package com.fun.admin.repository;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.fun.le.entities.LotLotteryIssue;
import com.fun.le.entities.LotProductInfo;
import com.fun.le.entities.SchSchemeIssue;
import com.github.pagehelper.Page;
@Mapper
public interface LotMapper
{
  List<LotLotteryIssue> listOpenIssues(@Param("productIds") List<Integer> paramList, @Param("beginTime") Date paramDate1, @Param("endTime") Date paramDate2);

  LotLotteryIssue currentOpenTime(@Param("productId") Integer paramInteger, @Param("now") Date paramDate);

  LotLotteryIssue currentEndTime(@Param("productId") Integer paramInteger, @Param("now") Date paramDate);

  List<LotLotteryIssue> listCurrentIssues(@Param("productId") Integer paramInteger, @Param("beginDate") Date paramDate1, @Param("endDate") Date paramDate2);

  List<LotLotteryIssue> listCurrentOpenIssues(@Param("productId") Integer paramInteger);

  LotLotteryIssue getLotIssue(@Param("productId") Integer paramInteger, @Param("issue") String paramString);

  List<LotLotteryIssue> listOmittedIssues(@Param("productId") Integer paramInteger);

  Integer updateLotterIssueTimes(@Param("productId") String paramString1, @Param("issue") String paramString2, @Param("beginTime") String paramString3, @Param("endTime") String paramString4, @Param("openTime") String paramString5);

  Page<LotLotteryIssue> listIssues(@Param("prodId") Integer paramInteger, @Param("beginDate") Date paramDate1, @Param("endDate") Date paramDate2);

  List<LotLotteryIssue> listCheckIssues(@Param("prodId") Integer paramInteger, @Param("issues") List<SchSchemeIssue> paramList, @Param("end") Date paramDate);

  List<LotLotteryIssue> listCheckIssue(@Param("prodId") Integer paramInteger, @Param("issue") SchSchemeIssue schSchemeIssue, @Param("end") Date paramDate);

  List<LotLotteryIssue> listIssuesByTend(@Param("prodId") Integer paramInteger1, @Param("issue") String paramString, @Param("limit") Integer paramInteger2);

  List<LotProductInfo> listCurrentCodes();

  LotLotteryIssue getLastOpenCode(@Param("prodId") Integer paramInteger);
  
  LotLotteryIssue getLastOpenIssue(@Param("prodId") Integer paramInteger, @Param("now") Date paramDate);

  LotLotteryIssue getNextOpenIssue(@Param("prodId") Integer paramInteger, @Param("now") Date paramDate);

  void filing(@Param("beginDate") Date paramDate1, @Param("endDate") Date paramDate2, @Param("version") Integer paramInteger);

  List<LotLotteryIssue> listIssuesByPage(@Param("prodId") Integer paramInteger);

  void saveOpenCode(@Param("lotLotteryIssue") LotLotteryIssue paramLotLotteryIssue);
  
  void saveOpenCodeNew(@Param("lotLotteryIssue") LotLotteryIssue paramLotLotteryIssue);

  @Delete({"DELETE FROM t_lot_lottery_issue WHERE pk_id IN (${pkIds})"})
  void deleteIssuesByIds(@Param("pkIds") String paramString);
}