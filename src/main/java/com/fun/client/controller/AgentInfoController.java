package com.fun.client.controller;

import com.fun.client.service.AgentInfoService;
import com.fun.framework.domain.AjaxReturn;
import com.fun.framework.domain.Pagination;
import com.fun.framework.web.controller.BaseController;
import com.fun.framework.web.dto.QueryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api")
public class AgentInfoController extends BaseController {

    @Autowired
    private AgentInfoService agentInfoService;

    @RequestMapping(path = {"agent-proft-list"},method = {RequestMethod.POST})
    public AjaxReturn select(String loginName,String userName,String agentName,QueryDto queryDto){
        Pagination pagination = agentInfoService.selectProft(loginName, userName, agentName,queryDto);
        return  pagination;
    }
}
