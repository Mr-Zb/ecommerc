package com.fun.client.controller;

import com.fun.client.domain.ExtensionInfo;
import com.fun.client.service.ExtensionInfoService;
import com.fun.framework.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ExtensionInfoController extends BaseController {
    @Autowired
    private ExtensionInfoService extensionInfoService;

    /**
     * 新增数据
     * 推广记录
     * @param extensionInfo
     * @return
     */
    @ApiIgnore
    @RequestMapping(path = {"/extension-info-add"}, method = {RequestMethod.POST})
    public Integer insert(ExtensionInfo extensionInfo) {
        return this.extensionInfoService.insert(extensionInfo);
    }

    /**
     * 查询数据
     *推广记录
     * @param extensionInfo
     * @return
     */
    @ApiIgnore
    @RequestMapping(path = {"/extension-info-list"}, method = {RequestMethod.POST})
    public List<ExtensionInfo> select(ExtensionInfo extensionInfo) {
        return this.extensionInfoService.select(extensionInfo);
    }

    /**
     * 根据ID查询
     *
     * @param userId
     * @return
     */
    @ApiIgnore
    @RequestMapping(path = {"/extension-info-selectById"}, method = {RequestMethod.POST})
    public ExtensionInfo selectById(Integer userId) {
        return this.extensionInfoService.selectById(userId);
    }

    @ApiIgnore
    @RequestMapping(path = {"/extension-info-update"}, method = {RequestMethod.POST})
    public Integer update(ExtensionInfo extensionInfo) {
        return this.extensionInfoService.update(extensionInfo);
    }
}
