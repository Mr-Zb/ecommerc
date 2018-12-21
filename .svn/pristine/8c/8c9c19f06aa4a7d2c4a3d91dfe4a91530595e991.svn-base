package com.fun.client.controller;

import com.fun.client.service.*;
import com.fun.framework.domain.AjaxReturn;
import com.fun.framework.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/api")
public class CancelTheOrderController extends BaseController {
    private @Autowired
    CancelTheOrderService cancelTheOrderServiceService;

    /**
     * 取消订单(退货)
     * @param
     * @return
     * @throws Exception
     */
    @ApiIgnore
    @RequestMapping(path = {"cancel-order"}, method = {RequestMethod.POST})
    public AjaxReturn cancelTheOrder(String orderNo) throws Exception {
        int userId = getAuthentication().intValue();
        return new AjaxReturn(200,this.cancelTheOrderServiceService.cancelTheOrder(userId,orderNo),null);
    }
}
