package com.fun.client.service;

import com.fun.client.domain.FinRechargeOption;
import com.fun.client.repository.FinRechargeOptionMapper;
import com.fun.framework.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FinRechargeOptionService extends BaseService{
    private @Autowired FinRechargeOptionMapper finRechargeOptionMapper;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class}, readOnly = false)
    public Integer insert(FinRechargeOption finRechargeOption){
        return this.finRechargeOptionMapper.insert(finRechargeOption);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class}, readOnly = false)
    public FinRechargeOption update(FinRechargeOption finRechargeOption){
        return this.finRechargeOptionMapper.update(finRechargeOption);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class}, readOnly = false)
    public List<FinRechargeOption> select(FinRechargeOption finRechargeOption){
        return  this.finRechargeOptionMapper.select(finRechargeOption);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class}, readOnly = false)
    public FinRechargeOption selectById(Integer userId){
        return this.finRechargeOptionMapper.selectById(userId);
    }
}
