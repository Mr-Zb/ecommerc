package com.fun.api.web.controller;

import com.fun.client.domain.FinManage;
import com.fun.client.service.GoodsOrderInfoService;
import com.fun.framework.domain.AjaxReturn;
import com.fun.framework.web.controller.BaseController;
import com.fun.framework.web.dto.QueryDto;
import com.fun.framework.web.support.annotation.Secure;
import com.fun.le.entities.FinCapitalLog;
import com.fun.le.service.FinCapitalLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/api")
public class FinCapitalLogController extends BaseController {

    private @Autowired
    FinCapitalLogService finCapitalLogService;
    private @Autowired
    GoodsOrderInfoService goodsOrderInfoService;

    /**
     * 查询资金详情
     *
     * @param finCapitalLog
     * @param
     * @return
     */
    @ApiIgnore
    @RequestMapping(path = {"fin-capital-log-select"}, method = {RequestMethod.POST})
    public AjaxReturn selectById(FinCapitalLog finCapitalLog, QueryDto queryDto,Integer capitalType) throws Exception {
        if (finCapitalLog == null) {
            finCapitalLog = new FinCapitalLog();
        }
        if (queryDto == null) {
            queryDto = new QueryDto();
        }
        return finCapitalLogService.select(finCapitalLog,queryDto,capitalType);
    }

//    /**
//     * 获取用户余额
//     * undo
//     * @return
//     */
//    @ApiIgnore
//    @RequestMapping(path = {"fin-capital-select"}, method = {RequestMethod.POST})
//    private AjaxReturn countUserAmount() throws Exception {
//        int userId = getAuthentication().intValue();
//        Double list = finCapitalLogService.countUserAmount(userId);
//        return new AjaxReturn(200,null,list);
//    }

    /**
     * 中奖明细
     * @param finManage
     * @param queryDto
     * @return
     */
    @ApiIgnore
   // @Secure(has = {"le:fina:winner:list"})
    @RequestMapping(path = {"user-promotion-list"})
    public AjaxReturn userPromotionList(FinManage finManage, QueryDto queryDto){
        if (finManage == null) {
            finManage = new FinManage();
        }
        if (queryDto == null) {
            queryDto = new QueryDto();
        }
        return this.goodsOrderInfoService.userPromotionList(finManage,queryDto);
    }
}
