package com.fun.admin.service;

import java.util.Date;
import java.util.Random;

import com.fun.framework.service.BaseService;
import org.springframework.stereotype.Service;
import com.fun.framework.support.BusinessException;
import com.fun.framework.utils.DateFormatUtils;
import com.fun.framework.utils.StringUtils;

@Service
public class SequenceService extends BaseService {
	public String generate(String type) throws BusinessException {
		synchronized (this) {
			return type + DateFormatUtils.format(new Date(), "yyMMddHHmmssSSS")
					+ StringUtils.leftPad(String.valueOf(new Random().nextInt(10000)), 4, "0");
		}
	}
}
