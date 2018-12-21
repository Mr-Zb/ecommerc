package com.fun.le.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.fun.le.entities.LotLotteryIssue;
@Mapper
public interface LotLotteryIssueMapper {
	Integer insert(@Param("lotLotteryIssue") LotLotteryIssue paramLotLotteryIssue);

	Integer insertBatch(@Param("lotLotteryIssues") List<LotLotteryIssue> paramList);

	Integer update(@Param("lotLotteryIssue") LotLotteryIssue paramLotLotteryIssue1,
                   @Param("where") LotLotteryIssue paramLotLotteryIssue2);

	Integer updateById(@Param("lotLotteryIssue") LotLotteryIssue paramLotLotteryIssue,
                       @Param("lotLotteryIssueId") Long paramLong);

	Integer updateActive(@Param("lotLotteryIssue") LotLotteryIssue paramLotLotteryIssue1,
                         @Param("where") LotLotteryIssue paramLotLotteryIssue2);

	Integer updateActiveById(@Param("lotLotteryIssue") LotLotteryIssue paramLotLotteryIssue,
                             @Param("lotLotteryIssueId") Long paramLong);

	List<LotLotteryIssue> select(@Param("lotLotteryIssue") LotLotteryIssue paramLotLotteryIssue);

	LotLotteryIssue selectById(@Param("lotLotteryIssueId") Long paramLong);

	Integer delete(@Param("where") LotLotteryIssue paramLotLotteryIssue);

	Integer deleteById(@Param("lotLotteryIssueId") Long paramLong);
}
