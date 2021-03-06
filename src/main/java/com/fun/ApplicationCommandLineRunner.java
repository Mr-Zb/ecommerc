package com.fun;

import com.fun.admin.service.LotService;
import com.fun.admin.service.PropService;
import com.fun.admin.service.SchService;
import com.fun.job.LotEndTaskEnterJob;
import com.fun.job.LotRewardTastEnterJob;
import com.fun.job.SessionJob;
import org.quartz.JobBuilder;
import org.quartz.Scheduler;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.fun.framework.utils.Constants;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ApplicationCommandLineRunner implements ApplicationRunner {

	@Autowired
	private PropService propService;
	@Autowired
	private LotService lotService;
	@Autowired
	private SchService schService;
	@Autowired
	private Scheduler scheduler;
	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.info("正在初始化系统...");
		propService.loadProps();
		log.info("初始化自动任务=>生成投注已截止的方案");
		scheduler.scheduleJob(JobBuilder.newJob(LotEndTaskEnterJob.class).build(), TriggerBuilder.newTrigger().withIdentity("async-end-task-enter")//
				.startNow()//
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(10).repeatForever())//
				.build());
		log.info("初始化自动任务=>生成中奖方案");
		scheduler.scheduleJob(JobBuilder.newJob(LotRewardTastEnterJob.class).build(), TriggerBuilder.newTrigger().withIdentity("async-reward-tast-enter")
				.startNow()
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(10).repeatForever())
				.build());
		log.info("初始化自动任务=>用户在线计算");
		scheduler.scheduleJob(JobBuilder.newJob(SessionJob.class).build(), TriggerBuilder.newTrigger().withIdentity("session-tast-enter")//
				.startNow()//
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(60).repeatForever())//
				.build());
		Constants.init = true;
		log.info("初始化系统...done");
	}

}
