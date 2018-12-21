package com.fun.framework.configure;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@Configuration
@EnableAsync
public class ThreadPoolConfigure {
	@Bean
	public Executor defaultThreadPool() {
		ThreadPoolTaskScheduler executor = new ThreadPoolTaskScheduler();
		executor.setPoolSize(10);
		executor.setThreadPriority(1);
		executor.setThreadNamePrefix("pool-");
		executor.initialize();
		return executor;
	}
}
