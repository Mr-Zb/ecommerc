package com.fun.client.service;

import com.fun.client.domain.LogisticsInfo;
import com.fun.client.repository.LogisticsInfoMapper;
import com.fun.framework.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class LogisticsInfoService extends BaseService{
    private @Autowired LogisticsInfoMapper logisticsInfoMapper;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class}, readOnly = false)
    public Integer addLogisticsInfo(LogisticsInfo logisticsInfo,Integer userId){
        logisticsInfo.setCreateTime(new Date());
        logisticsInfo.setCreateUser(userId);
        logisticsInfo.setUpdateTime(new Date());
        logisticsInfo.setUpdateUser(userId);
        logisticsInfo.setDataVersion(1);
        return this.logisticsInfoMapper.addLogisticsInfo(logisticsInfo,userId);
    }
}
