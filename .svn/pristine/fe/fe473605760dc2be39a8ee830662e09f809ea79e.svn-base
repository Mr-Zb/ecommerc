package com.fun.job;

import com.fun.admin.service.LotService;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import lombok.extern.slf4j.Slf4j;

/**
 * 生成投注已截止的方案
 * @author zby
 *
 */
@Slf4j
@DisallowConcurrentExecution
public class LotEndTaskEnterJob extends QuartzJobBean {
	private @Autowired LotService lotService;
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		try {
			lotService.endTaskEnter();
		} catch (Exception e) {
			log.error("生成投注已截止的方案失败", e);
		}
	}

}
