package com.fun.framework.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fun.framework.support.BusinessException;
import com.fun.framework.utils.StringUtils;

@SuppressWarnings("unchecked")
@Transactional(propagation = Propagation.SUPPORTS, rollbackFor = { Exception.class }, readOnly = true)
public abstract class BaseService  {
	protected final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	protected ApplicationContext context;

	@Autowired	
	protected CacheManager cacheManager;
	private Map<Integer, String> sync1 = new HashMap<Integer, String>();
	private Map<String, String> sync2 = new HashMap<String, String>();

	public <T> T getBean(Class<T> requiredType) throws BusinessException {
		return this.context.getBean(requiredType);
	}

	public <T> T getBean(String beanName) throws BusinessException {
		return (T) this.context.getBean(beanName);
	}

	public <T> T getBean() throws BusinessException {
		return (T) this.context.getBean(getClass());
	}

	public <T> T getCache(String name, String key, Class<T> requiredType) {
		return this.cacheManager.getCache(name).get(key, requiredType);
	}

	public void putCache(String name, String key, Object val) {
		this.cacheManager.getCache(name).put(key, val);
	}

	protected String getlock(Integer userId) {
		if (!this.sync1.containsKey(userId)) {
			this.sync1.put(userId, StringUtils.systemUuid());
		}
		return (String) this.sync1.get(userId);
	}

	protected String getlock(String userId) {
		if (!this.sync2.containsKey(userId)) {
			this.sync2.put(userId, StringUtils.systemUuid());
		}
		return (String) this.sync2.get(userId);
	}

	protected static enum cacheNames {
		cache_prop_by_key;
	}
}
