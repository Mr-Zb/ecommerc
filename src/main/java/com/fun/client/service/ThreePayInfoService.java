package com.fun.client.service;

import com.fun.client.domain.ThreePayInfo;
import com.fun.client.repository.ThreePayInfoMapper;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fun.framework.support.BusinessException;

import java.util.List;

@Service
public class ThreePayInfoService {
	
	@Autowired
	private ThreePayInfoMapper threePayInfoMapper;

	public Integer updateById(ThreePayInfo threePayInfo) throws BusinessException {
		return threePayInfoMapper.updateById(threePayInfo);
	}


	public Integer insert(ThreePayInfo threePayInfo) throws BusinessException {
		return threePayInfoMapper.insert(threePayInfo);
	}


	public Page<ThreePayInfo> select(ThreePayInfo threePayInfo) throws BusinessException {
		return threePayInfoMapper.select(threePayInfo);
	}
	public List<ThreePayInfo> selectA(ThreePayInfo threePayInfo){
		return threePayInfoMapper.selectA(threePayInfo);
	}


	public Integer deleteById(Integer threePayInfoId) throws BusinessException {
		return threePayInfoMapper.deleteById(threePayInfoId);
	}


	public List<ThreePayInfo> selectByState(ThreePayInfo threePayInfo) {
		return threePayInfoMapper.selectByState(threePayInfo);
	}


	public ThreePayInfo selectById(Integer pkId) {
		return threePayInfoMapper.selectById(pkId);
	}


	public List<ThreePayInfo> selectByPlatformId(Integer platformId) throws BusinessException {
		return threePayInfoMapper.selectByPlatformId(platformId);
	}


	public List<ThreePayInfo> selectByName(ThreePayInfo threePayInfo) throws BusinessException {
		return threePayInfoMapper.selectByName(threePayInfo);
	}

}
