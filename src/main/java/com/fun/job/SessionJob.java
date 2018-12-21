package com.fun.job;

import com.fun.Application;
import com.fun.admin.service.LotService;
import com.fun.framework.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

/**
 * 生成投注已截止的方案
 * @author zby
 *
 */
@Slf4j
@DisallowConcurrentExecution
public class SessionJob extends QuartzJobBean {
	//登录超时计算，秒为单位
	int timeout = 1800;
	@Autowired
	private RedisTemplate redisTemplate;
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
//			ConcurrentMap<Long, Date> map =  Constants.sessionIds.asMap();
		Map<Object, Object> map = redisTemplate.opsForHash().entries(Constants.SESSIONIDS);
			map.forEach((k,v)->{
//				Integer k1 = (Integer) k;
				Date v1 = (Date) v;
				Calendar nowBefore = Calendar.getInstance();
				nowBefore.add(Calendar.SECOND, -timeout);
				SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				System.out.println(sdf.format(nowBefore.getTimeInMillis()) );
				Date before = nowBefore.getTime();
				if (v1.getTime() < before.getTime()){
//					Constants.sessionIds.invalidate(k);
					redisTemplate.opsForHash().delete(Constants.SESSIONIDS,k);
				}
			});
	}

//	public static void main(String[] args) {
//		Calendar nowBefore = Calendar.getInstance();
//		nowBefore.add(Calendar.MINUTE, -30);
//		nowBefore.getTime();
//		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		System.out.println(  sdf.format(nowBefore.getTimeInMillis()) );
//	}
}
