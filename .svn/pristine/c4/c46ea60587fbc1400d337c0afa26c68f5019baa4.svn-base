package com.fun.le.repository;

import java.util.List;
import java.util.Set;

import com.fun.client.domain.MemTeam;
import com.fun.framework.web.dto.QueryDto;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.fun.le.entities.FinCapitalLog;

@Mapper
public interface FinCapitalLogMapper {
    Integer insert(@Param("finCapitalLog") FinCapitalLog paramFinCapitalLog);

    Integer insertBatch(@Param("finCapitalLogs") List<FinCapitalLog> paramList);

    Integer update(@Param("finCapitalLog") FinCapitalLog paramFinCapitalLog1, @Param("where") FinCapitalLog paramFinCapitalLog2);

    Integer updateById(@Param("finCapitalLog") FinCapitalLog paramFinCapitalLog, @Param("finCapitalLogId") Integer paramInteger);

    Integer updateActive(@Param("finCapitalLog") FinCapitalLog paramFinCapitalLog1, @Param("where") FinCapitalLog paramFinCapitalLog2);

    Integer updateActiveById(@Param("finCapitalLog") FinCapitalLog paramFinCapitalLog, @Param("finCapitalLogId") Integer paramInteger);

    Page<FinCapitalLog> select(@Param("finCapitalLog") FinCapitalLog paramFinCapitalLog, @Param("where") QueryDto queryDto, Integer c);

    FinCapitalLog selectById(@Param("finCapitalLogId") Integer paramInteger);

    Integer delete(@Param("where") FinCapitalLog paramFinCapitalLog);

    Integer deleteById(@Param("finCapitalLogId") Integer paramInteger);

    List<MemTeam> selectSubordinateInfo(Integer userId);

    //获取下级用户ID
    List<FinCapitalLog> countSubordinateUser(Integer userId);

    Set<FinCapitalLog> registerAndPromotionNum(Integer userId,@Param("where") QueryDto where);

    Set<FinCapitalLog> selectPayNum(@Param("where") QueryDto where);

    List<FinCapitalLog> promotionNum(@Param("where") QueryDto where);

    List<FinCapitalLog> selectPayCount(@Param("where") QueryDto where);

    Double rechargeCount(@Param("where") QueryDto where);

    List<FinCapitalLog> drawCount(@Param("where") QueryDto where);

    Double selectDrawMoney(@Param("where") QueryDto where);

    Double selectFirstRecharge(Integer userId);

    Double selectBetMoney(@Param("where") QueryDto where);

    Set<FinCapitalLog> selectSeven(@Param("num") Integer num);

}
