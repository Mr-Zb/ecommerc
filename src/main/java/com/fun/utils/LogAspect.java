package com.fun.utils;

import com.fun.client.domain.MemUserInfo;
import com.fun.client.domain.OperationLog;
import com.fun.client.service.MemUserInfoService;
import com.fun.client.service.OperationLogService;
import com.fun.framework.support.BusinessException;
import com.fun.framework.utils.Constants;
import com.fun.framework.utils.RequestUtils;
import com.fun.framework.web.controller.BaseController;
import org.apache.commons.lang3.math.NumberUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

@Aspect
@Component
public class LogAspect extends BaseController{
   /* @Autowired
    private SysLogDao sysLogDao;*/
   @Autowired
   private MemUserInfoService memUserInfoService;
   @Autowired
   private OperationLogService operationLogService;

    @Pointcut("@annotation(com.fun.utils.Log)")
    public void pointcut() { }
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) throws Exception {
        Object result = null;
        long beginTime = System.currentTimeMillis();
        try {
            // 执行方法
            result = point.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        // 执行时长(毫秒)
      //  long time = System.currentTimeMillis() - beginTime;
        // 保存日志
        saveLog(point);
        return result;
    }
    private void saveLog(ProceedingJoinPoint joinPoint) throws Exception {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        OperationLog operationLog  = new OperationLog ();

        Log logAnnotation = method.getAnnotation(Log.class);
        if (logAnnotation != null) {
            // 注解上的描述
            operationLog.setContent(logAnnotation.value());
        }
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        int userId = getAuthentication(request).intValue();
        //int userId = NumberUtils.toInt(SecurityContextHolder.getContext().getAuthentication().getName());
        String ip = null ;
        //String ipAddress;
        try {
            if (userId >= 1) {
                 ip = RequestUtils.getIp(request);
               //  ipAddress = RequestUtils.getIpAddress(ip);
               // String agent = RequestUtils.getAgent(request);
                //  this.memService.addLoginLog(userId, ip, ipAddress, agent);
            }
        } catch (Exception ex2) {
        }
        MemUserInfo memUserInfo = memUserInfoService.selectById(userId);
        operationLog.setMemberId(userId);
        operationLog.setMemberName(memUserInfo.getLoginName());
        operationLog.setOperationIp(ip);
        operationLog.setMemberRemark(memUserInfo.getRemark());
        operationLogService.insert(userId,operationLog);
    }
}
