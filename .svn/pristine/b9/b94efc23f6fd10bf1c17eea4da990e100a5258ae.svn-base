package com.fun.client.controller;

import com.fun.client.domain.IntegralOrderInfo;
import com.fun.client.service.IntegralOrderInfoService;
import com.fun.framework.domain.AjaxReturn;
import com.fun.framework.domain.Pagination;
import com.fun.framework.web.controller.BaseController;
import com.fun.framework.web.dto.QueryDto;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class IntegralOrderInfoController extends BaseController {

    private @Autowired
    IntegralOrderInfoService integralOrderInfoService;

    /**
     * 新增积分订单列表
     * @param integralOrderInfo
     * @return
     * @throws Exception
     */
    @ApiIgnore
    @RequestMapping(path = {"integral-order-info-insert"}, method = {RequestMethod.POST})
    public AjaxReturn update(IntegralOrderInfo integralOrderInfo) throws Exception {
        int userId = getAuthentication().intValue();
        integralOrderInfo.setCreateTime(new Date());
        this.integralOrderInfoService.insert(integralOrderInfo,userId);
        return new AjaxReturn(200, null, null);
    }

    /**
     * 查询积分订单列表
     * @return
     * @throws Exception
     */
    @ApiIgnore
    @RequestMapping(path = {"integral-order-info-selectById"}, method = {RequestMethod.POST})
    public AjaxReturn selectById(QueryDto queryDto) throws Exception {
       int userId = getAuthentication().intValue();
       Pagination<IntegralOrderInfo> list = this.integralOrderInfoService.selectById(userId,queryDto);
        return list;
    }

    @ApiIgnore
    @RequestMapping(path = {"integral-order-exchange-list"}, method = {RequestMethod.POST})
    public AjaxReturn selectOrderExchange(QueryDto queryDto) throws Exception {
         int userId = getAuthentication().intValue();
        if (queryDto == null) {
            queryDto = new QueryDto();
        }
        Pagination<IntegralOrderInfo> list = this.integralOrderInfoService.selectExchange(userId,queryDto);
        return list;
    }

}
