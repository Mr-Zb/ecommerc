package com.fun.client.service;

import com.fun.client.domain.IntegralOrderInfo;
import com.fun.client.repository.IntegralOrderInfoMapper;
import com.fun.framework.domain.Pagination;
import com.fun.framework.service.BaseService;
import com.fun.framework.web.dto.QueryDto;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class IntegralOrderInfoService extends BaseService {
    private @Autowired
    IntegralOrderInfoMapper integralOrderInfoMapper;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class}, readOnly = false)
    @Async
    public Integer insert(IntegralOrderInfo integralOrderInfo, Integer userId) {
        return this.integralOrderInfoMapper.insert(integralOrderInfo, userId);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class}, readOnly = false)
    public Pagination<IntegralOrderInfo> selectById(Integer userId, QueryDto queryDto) {
        PageHelper.startPage(queryDto.getPage(), queryDto.getRows(), true);
        Page<IntegralOrderInfo> page = this.integralOrderInfoMapper.selectById(userId, queryDto);
        return new Pagination<IntegralOrderInfo>(page.getTotal(), page.getResult());
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class}, readOnly = false)
    public Pagination<IntegralOrderInfo> selectExchange(Integer userId, QueryDto queryDto) {
        PageHelper.startPage(queryDto.getPage(), queryDto.getRows(), true);
        Page<IntegralOrderInfo> page = this.integralOrderInfoMapper.selectExchange(userId, queryDto);
        return new Pagination<IntegralOrderInfo>(page.getTotal(), page.getResult());
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class}, readOnly = false)
    public Double countUserIntegral(Integer userId) {
        return this.integralOrderInfoMapper.countUserIntegral(userId);
    }
}
