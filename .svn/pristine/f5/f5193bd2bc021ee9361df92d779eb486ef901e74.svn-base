package com.fun.client.repository;

import com.fun.client.domain.PromotionLog;
import com.fun.framework.web.dto.QueryDto;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface PromotionLogMapper {
    /**
     * 新增促销列表
     * @param promotionLog
     * @return
     */
    Integer addPromotionLog(@Param("promotionLog") PromotionLog promotionLog);

    Page<PromotionLog> promotionLogList(@Param("promotionLog") PromotionLog promotionLog, @Param("where") QueryDto queryDto,Integer id,Integer gameType);
}
