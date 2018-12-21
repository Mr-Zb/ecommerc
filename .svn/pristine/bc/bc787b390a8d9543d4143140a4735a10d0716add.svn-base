package com.fun.client.repository;

import com.fun.client.domain.FinRechargeOption;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface FinRechargeOptionMapper {
    /**
     * 插入数据
     * @param finRechargeOption
     * @return
     */
    Integer insert(@Param("finRechargeOption") FinRechargeOption finRechargeOption);

    /**
     * 修改数据
     * @param finRechargeOption
     * @return
     */
    FinRechargeOption update(@Param("finRechargeOption") FinRechargeOption finRechargeOption);

    /**
     * 查询数据
     * @param finRechargeOption
     * @return
     */
    List<FinRechargeOption> select(@Param("finRechargeOption") FinRechargeOption finRechargeOption);

    /**
     * 根据ID查询
     * @param finRechargeOptionId
     * @return
     */
    FinRechargeOption selectById(@Param("finRechargeOptionId") Integer finRechargeOptionId);
}
