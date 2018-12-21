package com.fun.client.service;

import com.fun.client.domain.PromotionLog;
import com.fun.client.repository.PromotionLogMapper;
import com.fun.framework.domain.Pagination;
import com.fun.framework.service.BaseService;
import com.fun.framework.web.dto.QueryDto;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PromotionLogService extends BaseService {
    private @Autowired
    PromotionLogMapper promotionLogMapper;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class}, readOnly = false)
    public Integer add(PromotionLog promotionLog) {
        return promotionLogMapper.addPromotionLog(promotionLog);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class}, readOnly = false)
    public Pagination<PromotionLog> promotionLogList(PromotionLog promotionLog, QueryDto queryDto,Integer id,Integer gameType) {
        PageHelper.startPage(queryDto.getPage(), queryDto.getRows(), true);
        Page<PromotionLog> page = this.promotionLogMapper.promotionLogList(promotionLog,queryDto,id,gameType);
        return new Pagination<PromotionLog>(page.getTotal(),page.getResult());

    }
}
