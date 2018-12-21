package com.fun.job;

import com.fun.admin.service.LotService;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;


import lombok.extern.slf4j.Slf4j;

/**
 * 生成中奖方案
 * @author zby
 *
 */
@Slf4j
@DisallowConcurrentExecution
public class LotRewardTastEnterJob extends QuartzJobBean {
	private @Autowired LotService lotService;
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		try {
			lotService.rewardTaskEnter();
		} catch (Exception e) {
			log.error("生成中奖方案方案失败", e);
		}
	}

}
