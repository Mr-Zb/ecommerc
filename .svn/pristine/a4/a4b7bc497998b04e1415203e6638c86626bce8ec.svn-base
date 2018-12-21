package com.fun.client.repository;

import com.fun.client.domain.AgentInfo;
import com.fun.framework.web.dto.QueryDto;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

public interface AgentInfoMapper {
    Page<AgentInfo> selectProft(@Param("loginName")String loginName, @Param("userName") String userName, @Param("agentName") String agentName, @Param("where") QueryDto where);
}
