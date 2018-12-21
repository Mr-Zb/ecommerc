package com.fun.admin.service;

import java.util.List;

import javax.annotation.PostConstruct;

import com.fun.framework.service.BaseService;
import com.fun.le.entities.SysPropSetting;
import com.fun.le.service.SysPropSettingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fun.framework.support.BusinessException;
import com.fun.framework.utils.CollectionUtils;
import com.fun.framework.utils.StringUtils;

@Slf4j
@Lazy(false)
@Service
public class PropService extends BaseService {

	@Autowired
	private SysPropSettingService propSettingService;

//	@PostConstruct
	@Transactional(propagation = Propagation.SUPPORTS, rollbackFor = { Exception.class }, readOnly = true)
	public void loadProps() throws BusinessException {
		this.log.info("正在加载属性配置文件...");
		List<SysPropSetting> list = this.propSettingService.select(Integer.valueOf(0), new SysPropSetting());
		if (CollectionUtils.isNotEmpty(list)) {
			for (SysPropSetting setting : list) {
				if ((StringUtils.isNotBlank(setting.getPropKey()))
						&& (StringUtils.isNotBlank(setting.getPropValue()))) {
					putCache(BaseService.cacheNames.cache_prop_by_key.name(), setting.getPropKey(),
							setting.getPropValue());
				}
			}
		}
		log.info("正在加载属性配置文件...Done");
	}

	@Transactional(propagation = Propagation.SUPPORTS, rollbackFor = { Exception.class }, readOnly = true)
	public String getPropByKey(String key) throws BusinessException {
		return (String) getCache(BaseService.cacheNames.cache_prop_by_key.name(), key, String.class);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class }, readOnly = false)
	public void savePropByKey(String key, String val) throws BusinessException {
		SysPropSetting sysPropSetting = new SysPropSetting();
		sysPropSetting.setPropValue(val);

		SysPropSetting where = new SysPropSetting();
		where.setPropKey(key);
		Integer count = this.propSettingService.updateActive(Integer.valueOf(0), sysPropSetting, where);
		if ((count != null) && (count.intValue() > 0))
			putCache(BaseService.cacheNames.cache_prop_by_key.name(), key, val);
	}

	@Transactional(propagation = Propagation.SUPPORTS, rollbackFor = { Exception.class }, readOnly = true)
	public List<SysPropSetting> listProps() throws BusinessException {
		return this.propSettingService.select(Integer.valueOf(0), new SysPropSetting());
	}
}
