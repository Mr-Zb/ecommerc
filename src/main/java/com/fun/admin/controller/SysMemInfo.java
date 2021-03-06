package com.fun.admin.controller;

import com.fun.admin.dto.MemInfoDetail;
import com.fun.client.domain.MemUserInfo;
import com.fun.client.domain.ReturnCount;
import com.fun.client.service.MemUserInfoService;
import com.fun.framework.domain.AjaxReturn;
import com.fun.framework.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SysMemInfo extends BaseController {
    @Autowired
    private MemUserInfoService memUserInfoService;

    @RequestMapping(path = {"show-mem-info"}, method = {RequestMethod.POST})
    public AjaxReturn showMemList(Integer Id) {
        MemUserInfo memUserInfo = memUserInfoService.selectById(Id);
        ReturnCount returnCount = memUserInfoService.selectRechargeCount(Id);
        ReturnCount returnCount1 = memUserInfoService.selectWithdrawCount(Id);
        MemInfoDetail memInfoDetail = new MemInfoDetail();
        memInfoDetail.setAgentName(memUserInfo.getAgentName());
        memInfoDetail.setPkId(memUserInfo.getPkId());
        memInfoDetail.setBankAccount(memUserInfo.getBankAccount());
        memInfoDetail.setBankAccountName(memUserInfo.getBankAccountName());
        memInfoDetail.setBankSubName(memUserInfo.getBankSubName());
        memInfoDetail.setBankName(memUserInfo.getBankName());
        memInfoDetail.setCapital1(memUserInfo.getCapital1());
        memInfoDetail.setLoginName(memUserInfo.getLoginName());
        memInfoDetail.setRechargeAmount(returnCount.getSumAmount());
        memInfoDetail.setWithdrawAmount(returnCount1.getSumAmount());
        memInfoDetail.setRechargeNum(returnCount.getCount());
        memInfoDetail.setWithdrawNum(returnCount1.getCount());
        memInfoDetail.setRemark(memUserInfo.getRemark());
        return new AjaxReturn(200, null, memInfoDetail);
    }

    /**
     * 搜索下级
     *
     * @param Id
     * @return
     */
    @RequestMapping(path = {"show-mem-subordinate-info"}, method = {RequestMethod.POST})
    public AjaxReturn showUserSubordinate(Integer Id) {
        List<MemUserInfo> memUserInfos = memUserInfoService.selectSubordinate(Id);
        for (int i = 0; i < memUserInfos.size(); i++) {
            List<MemUserInfo> memUserInfos1 = memUserInfoService.selectSubordinate(memUserInfos.get(i).getPkId());
            memUserInfos.get(i).setUserType(memUserInfos1.size());//用户下级人数
        }
        return new AjaxReturn(200, null, memUserInfos);
    }

    /**
     * 搜索用户
     *
     * @return
     */
    @RequestMapping(path = {"mem-subordinate-info"}, method = {RequestMethod.POST})
    public AjaxReturn showSubordinate(String loginName) {
        List<Object> list = new ArrayList<>();
        for (; ; ) {
            MemUserInfo memUserInfo = memUserInfoService.selectLoginName(loginName);
            MemUserInfo memUserInfo1 = new MemUserInfo();
            memUserInfo1.setLoginName(memUserInfo.getLoginName());
            memUserInfo1.setPkId(memUserInfo.getPkId());
            list.add(0, memUserInfo1);
            loginName = memUserInfo.getAgentName();
            if (memUserInfo.getAgentId() < 1) {
                return new AjaxReturn(200, null, list);
            }
        }
    }
}
