package com.fun.admin.controller;

import com.fun.client.domain.BannerInfo;
import com.fun.client.domain.OperationLog;
import com.fun.client.service.BannerInfoService;
import com.fun.client.service.OperationLogService;
import com.fun.framework.domain.AjaxReturn;
import com.fun.framework.domain.Pagination;
import com.fun.framework.support.BusinessException;
import com.fun.framework.web.controller.BaseController;
import com.fun.framework.web.dto.QueryDto;
import com.fun.le.entities.SysPropSetting;
import com.fun.le.service.SysPropSettingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class SysOperation extends BaseController {

    @Autowired
    private OperationLogService operationLogService;

    @Autowired(required = false)
    private SysPropSettingService sysPropSettingService;

    private @Autowired
    BannerInfoService bannerInfoService;

    @RequestMapping(path = {"sys-operation-list"}, method = {RequestMethod.POST})
    public AjaxReturn showOperationList(OperationLog operationLog, QueryDto queryDto){
        Pagination<OperationLog> operationLogPagination = operationLogService.listOperationLog(operationLog, queryDto);
        return operationLogPagination;
    }

    @ApiOperation("手动支付信息")
    @RequestMapping(path = {"sys-operation-pay-code"}, method = {RequestMethod.POST})
    public AjaxReturn backInfo(){
        Map<String, Object> map = new HashMap<>();
        SysPropSetting sysPropSetting1 = new SysPropSetting();
        //支付宝账号
        sysPropSetting1.setPropKey("sys.fin.alipay1.acc");
        List<SysPropSetting> alipay1acc = sysPropSettingService.select(sysPropSetting1);
        map.put("sys.fin.alipay1.acc",alipay1acc.get(0).getPropValue());
        //支付宝姓名
        sysPropSetting1.setPropKey("sys.fin.alipay1.nme");
        List<SysPropSetting> alipay1neme = sysPropSettingService.select(sysPropSetting1);
        map.put("sys.fin.alipay1.nme",alipay1neme.get(0).getPropValue());
        //支付宝二维码
        sysPropSetting1.setPropKey("sys.fin.alipay1.cde");
        List<SysPropSetting> alipay1code = sysPropSettingService.select(sysPropSetting1);
        map.put("sys.fin.alipay1.cde",alipay1code.get(0).getPropValue());
        //微信帐号
        sysPropSetting1.setPropKey("sys.fin.wepay1.acc");
        List<SysPropSetting> wepay1 = sysPropSettingService.select(sysPropSetting1);
        map.put("sys.fin.wepay1.acc",wepay1.get(0).getPropValue());
        //微信姓名
        sysPropSetting1.setPropKey("sys.fin.wepay1.nme");
        List<SysPropSetting> wepay1nme = sysPropSettingService.select(sysPropSetting1);
        map.put("sys.fin.wepay1.nme",wepay1nme.get(0).getPropValue());
        //微信二维码
        sysPropSetting1.setPropKey("sys.fin.wepay1.cde");
        List<SysPropSetting> wepay1code = sysPropSettingService.select(sysPropSetting1);
        map.put("sys.fin.wepay1.cde",wepay1code.get(0).getPropValue());
        return new AjaxReturn(200,null,map);
    }

    /**
     *
     * @return
     */
    @RequestMapping(path = {"sys-share-generalize"}, method = {RequestMethod.POST})
    public AjaxReturn share(){
        Map<String, Object> map = new HashMap<>();
        SysPropSetting sysPropSetting1 = new SysPropSetting();
        //android下载地址
        sysPropSetting1.setPropKey("sys.picture.and");
        List<SysPropSetting> download = sysPropSettingService.select(sysPropSetting1);
        map.put("sys.picture.and",download.get(0).getPropValue());
        //android下载地址
        sysPropSetting1.setPropKey("sys.picture.ios");
        List<SysPropSetting> ios = sysPropSettingService.select(sysPropSetting1);
        map.put("sys.picture.ios",ios.get(0).getPropValue());
        return new AjaxReturn(200,null,map);
    }
    /**
     * 展示系统参数
     * @return
     */
    @RequestMapping(path = {"sys-operation-info"}, method = {RequestMethod.POST})
    public AjaxReturn showSysInfo(){
        Map<String, Object> map = new HashMap<>();
        SysPropSetting sysPropSetting1 = new SysPropSetting();
        //红包中奖概率
        sysPropSetting1.setPropKey("sys.user.red.envelop");
        List<SysPropSetting> red = sysPropSettingService.select(sysPropSetting1);
        map.put("sys.user.red.envelop",red.get(0).getPropValue());
        //系统版本
        sysPropSetting1.setPropKey("sys.version");
        List<SysPropSetting> version = sysPropSettingService.select(sysPropSetting1);
        map.put("sys.version",version.get(0).getPropValue());
        //android下载地址
        sysPropSetting1.setPropKey("sys.download.and");
        List<SysPropSetting> download = sysPropSettingService.select(sysPropSetting1);
        map.put("sys.download.and",download.get(0).getPropValue());
        //ios下载地址
        sysPropSetting1.setPropKey("sys.download.ios");
        List<SysPropSetting> ios = sysPropSettingService.select(sysPropSetting1);
        map.put("sys.download.ios",ios.get(0).getPropValue());
        //androider二维码
        sysPropSetting1.setPropKey("sys.picture.and");
        List<SysPropSetting> picture = sysPropSettingService.select(sysPropSetting1);
        map.put("sys.picture.and",picture.get(0).getPropValue());
        //ios二维码
        sysPropSetting1.setPropKey("sys.picture.ios");
        List<SysPropSetting> iosPicture = sysPropSettingService.select(sysPropSetting1);
        map.put("sys.picture.ios",iosPicture.get(0).getPropValue());
        //公告信息
        sysPropSetting1.setPropKey("sys.goods.notice");
        List<SysPropSetting> registration = sysPropSettingService.select(sysPropSetting1);
        map.put("sys.goods.notice",registration.get(0).getPropValue());
        BannerInfo bannerInfo = new BannerInfo();
        bannerInfo.setBannerLocation(1);
        List<BannerInfo> bannerInfos = bannerInfoService.selectByState(bannerInfo);
        List<String> list = new ArrayList<>();
        bannerInfos.forEach(banner->{
            list.add(banner.getBannerSrc());
        });
        bannerInfo.setBannerLocation(2);
        List<BannerInfo> bannerInfos2 = bannerInfoService.selectByState(bannerInfo);
        List<String> list1 = new ArrayList<>();
        bannerInfos2.forEach(banner->{
            list1.add(banner.getBannerSrc());
        });
        map.put("homePageBanner",list);
        map.put("integralBanner",list1);
        //支付宝账号
        sysPropSetting1.setPropKey("sys.fin.alipay1.acc");
        List<SysPropSetting> alipay1acc = sysPropSettingService.select(sysPropSetting1);
        map.put("sys.fin.alipay1.acc",alipay1acc.get(0).getPropValue());
        //支付宝姓名
        sysPropSetting1.setPropKey("sys.fin.alipay1.nme");
        List<SysPropSetting> alipay1neme = sysPropSettingService.select(sysPropSetting1);
        map.put("sys.fin.alipay1.nme",alipay1neme.get(0).getPropValue());
        //支付宝二维码
        sysPropSetting1.setPropKey("sys.fin.alipay1.cde");
        List<SysPropSetting> alipay1code = sysPropSettingService.select(sysPropSetting1);
        map.put("sys.fin.alipay1.cde",alipay1code.get(0).getPropValue());
        //微信帐号
        sysPropSetting1.setPropKey("sys.fin.wepay1.acc");
        List<SysPropSetting> wepay1 = sysPropSettingService.select(sysPropSetting1);
        map.put("sys.fin.wepay1.acc",wepay1.get(0).getPropValue());
        //微信姓名
        sysPropSetting1.setPropKey("sys.fin.wepay1.nme");
        List<SysPropSetting> wepay1nme = sysPropSettingService.select(sysPropSetting1);
        map.put("sys.fin.wepay1.nme",wepay1nme.get(0).getPropValue());
        //微信二维码
        sysPropSetting1.setPropKey("sys.fin.wepay1.cde");
        List<SysPropSetting> wepay1code = sysPropSettingService.select(sysPropSetting1);
        map.put("sys.fin.wepay1.cde",wepay1code.get(0).getPropValue());
        //客服QQ
        sysPropSetting1.setPropKey("sys.service.qq");
       List<SysPropSetting> qqsservice = sysPropSettingService.select(sysPropSetting1);
        map.put("sys.service.qq",qqsservice.get(0).getPropValue());
        return new AjaxReturn(200,null,map);
    }

    /**+
     * 修改系统参数
     * @return
     * @throws Exception
     */
    @RequestMapping(path = {"sys-operation-update"}, method = {RequestMethod.POST})
    public AjaxReturn updateSysInfo(String sysPropSetting1,String sysPropSetting2,String sysPropSettingAnd,String sysPropSettingIos,
                                    String sysPictureAnd,String sysPictureIos,
                                    String sysPropSetting4,String[] param1,String[] param2,String alipayAccount
                                    ,String alipayName,String alipayCode,String wepayAccount
                                    ,String wepayName,String wepayCode,String qq) throws Exception {
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        int userId = getAuthentication(request).intValue();
                sysPropSettingService.updateActiveNew(userId,sysPropSetting1,sysPropSetting2,
                        sysPropSettingAnd,sysPropSettingIos,sysPictureAnd,sysPictureIos,sysPropSetting4,param1,param2,
                        alipayAccount,alipayName,alipayCode,wepayAccount,wepayName,wepayCode,qq);
        return new AjaxReturn(200,null,null);
    }
}
