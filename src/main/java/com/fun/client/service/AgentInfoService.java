package com.fun.client.service;

import com.fun.client.domain.AgentInfo;
import com.fun.client.repository.AgentInfoMapper;
import com.fun.framework.domain.Pagination;
import com.fun.framework.service.BaseService;
import com.fun.framework.web.dto.QueryDto;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AgentInfoService extends BaseService {
    @Autowired
    private AgentInfoMapper agentInfoMapper;
    public Pagination selectProft(String loginName,String userName,String agentName,QueryDto queryDto){
        PageHelper.startPage(queryDto.getPage(), queryDto.getRows(), true);
        Page<AgentInfo> page = agentInfoMapper.selectProft(loginName, userName, agentName,queryDto);
        if (page.getResult().get(0) == null){
            Page<Object> objects = new Page<>();
            objects.setTotal(0);
            return  new Pagination<>(objects.getTotal(), objects.getResult());
        }
        return  new Pagination<>(page.getTotal(), page.getResult());
    }
}
