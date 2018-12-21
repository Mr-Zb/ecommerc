package com.fun.client.controller;

import com.fun.client.domain.FinManage;
import com.fun.client.service.GoodsOrderInfoService;
import com.fun.framework.domain.AjaxReturn;
import com.fun.framework.domain.Pagination;
import com.fun.framework.web.controller.BaseController;
import com.fun.framework.web.dto.QueryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/api")
public class PromotionLogController extends BaseController {
    private @Autowired
    GoodsOrderInfoService goodsOrderInfoService;

   // 查询促销记录列表
    @ApiIgnore
    @RequestMapping(path = {"promotion-log-list"}, method = {RequestMethod.POST})
    public AjaxReturn promotionLogList(FinManage finManage, QueryDto queryDto) {
        Pagination<FinManage> page = this.goodsOrderInfoService.userPromotionList(finManage, queryDto);
        return page;
    }
}
