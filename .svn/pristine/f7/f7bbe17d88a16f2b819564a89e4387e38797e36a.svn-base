package com.fun.client.controller;

import com.fun.framework.domain.AjaxReturn;
import com.fun.framework.support.BusinessException;
import com.fun.framework.web.controller.BaseController;
import com.fun.le.entities.SysPropSetting;
import com.fun.le.service.SysPropSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SysPropSettingController extends BaseController {
    private @Autowired
    SysPropSettingService sysPropSettingService;

    /**
     * 分享推广赔率设置
     *
     * @param sysPropSetting
     * @return
     * @throws Exception
     */
    @ApiIgnore
    @RequestMapping(path = {"mem-prop-setting"}, method = {RequestMethod.POST})
    public AjaxReturn setting(SysPropSetting sysPropSetting) throws Exception {
        int userId = getAuthentication().intValue();
        sysPropSetting.setCreateUser(userId);
        sysPropSetting.setPropKey("sys.user.extension");
        sysPropSetting.setRemark("用户下级推广比例");
        sysPropSettingService.select(userId, sysPropSetting);
        this.sysPropSettingService.insert(userId, sysPropSetting);
        return new AjaxReturn(200, null, null);
    }

    /**
     * 更新用户赔率设置
     *
     * @param sysPropSetting
     * @return
     * @throws BusinessException
     */
    @ApiIgnore
    @RequestMapping(path = {"mem-prop-update"}, method = {RequestMethod.POST})
    public AjaxReturn updatePropSetting(SysPropSetting sysPropSetting) throws Exception {
        int userId = getAuthentication().intValue();
        SysPropSetting sysPropSetting1 = new SysPropSetting();
        sysPropSetting1.setCreateUser(userId);
        List<SysPropSetting> select = sysPropSettingService.select(userId, sysPropSetting1);
        if (select.get(0).getPropValue().isEmpty()) {
            sysPropSettingService.updateByUserId(sysPropSetting, userId);
            return new AjaxReturn(200, null, null);
        } else {
            return new AjaxReturn(500, null, null);
        }
    }

    /**
     * 查询用户赔率设置
     *
     * @param sysPropSetting
     * @return
     * @throws Exception
     */
    @ApiIgnore
    @RequestMapping(path = {"select-prop-setting"}, method = {RequestMethod.POST})
    public AjaxReturn selectPropSetting(SysPropSetting sysPropSetting) throws Exception {
        int userId = getAuthentication().intValue();
        //  int userId =1;
        sysPropSetting.setCreateUser(userId);
        List<SysPropSetting> list = sysPropSettingService.selectByUserId(userId);
        return new AjaxReturn(200, null, list);
    }

    /*阿里大鱼短信接口设置*/
    @ApiIgnore
    @RequestMapping(path = {"message-prop-setting"}, method = {RequestMethod.POST})
    public AjaxReturn settings(String APPkey, String secretKey, String signature, String template, String variableName, HttpServletRequest request) throws Exception {
        int userId = getAuthentication(request);
        List<SysPropSetting> sysPropSettings = new ArrayList<>();
        SysPropSetting sysPropSetting = new SysPropSetting();
        sysPropSetting.setRemark("阿里大鱼APPkey");
        sysPropSetting.setPropValue(APPkey);
        sysPropSetting.setPropKey("sys.ali.appKey");

        SysPropSetting sysPropSetting1 = new SysPropSetting();
        sysPropSetting1.setRemark("阿里大鱼secretKey");
        sysPropSetting1.setPropValue(secretKey);
        sysPropSetting1.setPropKey("sys.ali.secretKey");

        SysPropSetting sysPropSetting2 = new SysPropSetting();
        sysPropSetting2.setRemark("阿里大鱼签名");
        sysPropSetting2.setPropValue(signature);
        sysPropSetting2.setPropKey("sys.ali.signature");

        SysPropSetting sysPropSetting3 = new SysPropSetting();
        sysPropSetting3.setRemark("阿里大鱼模板名称");
        sysPropSetting3.setPropValue(template);
        sysPropSetting3.setPropKey("sys.ali.template");

        SysPropSetting sysPropSetting4 = new SysPropSetting();
        sysPropSetting4.setRemark("阿里大鱼模板中的变量名");
        sysPropSetting4.setPropValue(variableName);
        sysPropSetting4.setPropKey("sys.ali.variableName");

        sysPropSettings.add(sysPropSetting);
        sysPropSettings.add(sysPropSetting1);
        sysPropSettings.add(sysPropSetting2);
        sysPropSettings.add(sysPropSetting3);
        sysPropSettings.add(sysPropSetting4);

        this.sysPropSettingService.insert(userId, sysPropSettings);
        return new AjaxReturn(200, "设置成功", null);
    }

    /*查询阿里大鱼短信设置*/
    @ApiIgnore
    @RequestMapping(path = {"select-aliMessage-setting"}, method = {RequestMethod.POST})
    public AjaxReturn selectALiMessage() {
        List<SysPropSetting> sysPropSettings = this.sysPropSettingService.selectALiMessageSetting();
        return new AjaxReturn(200, null, sysPropSettings);
    }

    /*获取版本号和客服QQ*/
    @ApiIgnore
    @RequestMapping(path = {"select-data"}, method = {RequestMethod.POST})
    public AjaxReturn selectDataVersion() {
        List<SysPropSetting> list = this.sysPropSettingService.selectDataVersion();
        return new AjaxReturn(200, null, list);
    }

    @ApiIgnore
    @RequestMapping(path = {"select-data-version"}, method = {RequestMethod.POST})
    public AjaxReturn selectMessage(){
        String[] strings = new String[4];
        String propKey1 = "sys.version";
        String propKey2 = "sys.service.qq";
        String propKey3 = "sys.download.and";
        String propKey4 = "sys.download.ios";
        String dateVersion1 = this.sysPropSettingService.selectMessage(propKey1);
        String dateVersion2= this.sysPropSettingService.selectMessage(propKey2);
        String dateVersion3 = this.sysPropSettingService.selectMessage(propKey3);
        String dateVersion4 = this.sysPropSettingService.selectMessage(propKey4);
        strings[0] = dateVersion1;
        strings[1] = dateVersion2;
        strings[2] = dateVersion3;
        strings[3] = dateVersion4;
        return new AjaxReturn(200,null,strings);
    }
}
