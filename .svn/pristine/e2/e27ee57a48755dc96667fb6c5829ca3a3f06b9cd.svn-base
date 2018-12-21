package com.fun.mysqldb.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fun.framework.support.BusinessException;
import com.fun.mysqldb.AttributeDto;
import com.fun.mysqldb.SysMessageInfo;
import com.fun.mysqldb.dao.TDeviceLocationDAO;
import com.fun.mysqldb.service.IdeviceLocationService;

@Service
public class TDeviceLocationService implements IdeviceLocationService{
	
	
	private TDeviceLocationDAO ss = new TDeviceLocationDAO();

	@Override
	public List<AttributeDto> getAttributeList() throws BusinessException {
		List<AttributeDto> attributeList = ss.getAttributeList();
		return attributeList;
	}

	@Override
	public List<AttributeDto> getAttributeListByBack() throws BusinessException {
		List<AttributeDto> attributeListByBack = ss.getAttributeListByBack();
		return attributeListByBack;
	}

	@Override
	public List<AttributeDto> getAttributeListByBack1(String str) throws BusinessException {
		List<AttributeDto> attributeListByBack = ss.getAttributeListByBack1(str);
		return attributeListByBack;
	}

	@Override
	public List<SysMessageInfo> getMessae() throws BusinessException {
		return ss.getMessae();
	}
}
