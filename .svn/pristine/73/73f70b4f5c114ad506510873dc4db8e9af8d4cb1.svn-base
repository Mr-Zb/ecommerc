package com.fun.api.web.controller;

import com.fun.api.domain.OrderManage;
import com.fun.api.service.OrderManageService;
import com.fun.framework.domain.AjaxReturn;
import com.fun.framework.domain.Pagination;
import com.fun.framework.web.controller.BaseController;
import com.fun.framework.web.dto.QueryDto;
import com.fun.framework.web.support.annotation.Secure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;


@RestController
@RequestMapping("/api")
public class PromotionManageController extends BaseController {

    private @Autowired
    OrderManageService orderManageService;

    /**
     * 促销管理-大吉大利
     *
     * @param orderManage
     * @param queryDto
     * @return
     */
    @ApiIgnore
   // @Secure(has = {"le:djdl:list"})
    @RequestMapping(path = {"order-manage-djdl-list"}, method = {RequestMethod.POST})
    public AjaxReturn promotionManageDjdlList(OrderManage orderManage, QueryDto queryDto) {
        if (orderManage == null) {
            orderManage = new OrderManage();
        }
        if (queryDto == null) {
            queryDto = new QueryDto();
        }
        Pagination<OrderManage> pagination = this.orderManageService.promotionManageDjdlList(orderManage, queryDto);
        return pagination;
    }

    /**
     * 促销管理-拆红包
     *
     * @param orderManage
     * @param queryDto
     * @return
     */
    @ApiIgnore
   // @Secure(has = {"le:chb:list"})
    @RequestMapping(path = {"order-manage-chb-list"}, method = {RequestMethod.POST})
    public AjaxReturn promotionManageQhbList(OrderManage orderManage, QueryDto queryDto) {
        if (orderManage == null) {
            orderManage = new OrderManage();
        }
        if (queryDto == null) {
            queryDto = new QueryDto();
        }
        return this.orderManageService.promotionManageQhbList(orderManage, queryDto);
    }
}
