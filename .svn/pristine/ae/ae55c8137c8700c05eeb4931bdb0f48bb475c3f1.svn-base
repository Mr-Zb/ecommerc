package com.fun.framework.configure;

import java.io.IOException;
import java.util.Properties;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fun.job.QuartzJobFactory;

@Configuration
public class QuartzConfigration {
	@Bean
	public QuartzJobFactory jobFactory() {
		return new QuartzJobFactory();
	}

	@Bean
	public Scheduler scheduler() throws IOException, SchedulerException {
		Properties prop = new Properties();
		prop.put("quartz.scheduler.instanceName", "ServerScheduler");
		prop.put("org.quartz.scheduler.instanceId", "AUTO");
		prop.put("org.quartz.scheduler.skipUpdateCheck", "true");
		prop.put("org.quartz.scheduler.instanceId", "NON_CLUSTERED");
		// prop.put("org.quartz.scheduler.jobFactory.class", "org.quartz.simpl.SimpleJobFactory");
		prop.put("org.quartz.scheduler.jobFactory.class", "com.fun.job.QuartzJobFactory");
		prop.put("org.quartz.threadPool.class", "org.quartz.simpl.SimpleThreadPool");
		prop.put("org.quartz.threadPool.threadCount", "3");

		SchedulerFactory schedulerFactory = new StdSchedulerFactory(prop);
		Scheduler scheduler = schedulerFactory.getScheduler();
		scheduler.setJobFactory(jobFactory());
		scheduler.start();
		return scheduler;
	}
}