package com.fun.le.service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fun.framework.support.BusinessException;
import com.fun.le.entities.SysAuthMenu;
import com.fun.le.repository.SysAuthMenuMapper;

@Service
public class SysAuthMenuService {

	@Autowired
	private SysAuthMenuMapper sysAuthMenuMapper;

	public Integer insert(Integer userId, SysAuthMenu sysAuthMenu) throws BusinessException {
		sysAuthMenu.setCreateTime(new Date());
		sysAuthMenu.setCreateUser(userId);
		sysAuthMenu.setUpdateTime(new Date());
		sysAuthMenu.setUpdateUser(userId);
		sysAuthMenu.setDataVersion(Integer.valueOf(1));
		return this.sysAuthMenuMapper.insert(sysAuthMenu);
	}

	public List<SysAuthMenu> selectByIds(List<String> ids) throws BusinessException{
		return this.sysAuthMenuMapper.selectByIds(ids);
	}

	public Integer insert(Integer userId, List<SysAuthMenu> sysAuthMenus) throws BusinessException {
		for (SysAuthMenu sysAuthMenu : sysAuthMenus) {
			sysAuthMenu.setCreateTime(new Date());
			sysAuthMenu.setCreateUser(userId);
			sysAuthMenu.setUpdateTime(new Date());
			sysAuthMenu.setUpdateUser(userId);
			sysAuthMenu.setDataVersion(Integer.valueOf(1));
		}
		return this.sysAuthMenuMapper.insertBatch(sysAuthMenus);
	}

	public Integer update(Integer userId, SysAuthMenu sysAuthMenu, SysAuthMenu where) throws BusinessException {
		sysAuthMenu.setUpdateTime(new Date());
		sysAuthMenu.setUpdateUser(userId);
		return this.sysAuthMenuMapper.update(sysAuthMenu, where);
	}

	public Integer updateById(Integer userId, SysAuthMenu sysAuthMenu, Integer sysAuthMenuId) throws BusinessException {
		sysAuthMenu.setUpdateTime(new Date());
		sysAuthMenu.setUpdateUser(userId);
		return this.sysAuthMenuMapper.updateById(sysAuthMenu, sysAuthMenuId);
	}

	public Integer updateActive(Integer userId, SysAuthMenu sysAuthMenu, SysAuthMenu where) throws BusinessException {
		sysAuthMenu.setUpdateTime(new Date());
		sysAuthMenu.setUpdateUser(userId);
		return this.sysAuthMenuMapper.updateActive(sysAuthMenu, where);
	}

	public Integer updateActiveById(Integer userId, SysAuthMenu sysAuthMenu, Integer sysAuthMenuId)
			throws BusinessException {
		sysAuthMenu.setUpdateTime(new Date());
		sysAuthMenu.setUpdateUser(userId);
		return this.sysAuthMenuMapper.updateActiveById(sysAuthMenu, sysAuthMenuId);
	}

	public List<SysAuthMenu> select(Integer userId, SysAuthMenu sysAuthMenu) throws BusinessException {
		return this.sysAuthMenuMapper.select(sysAuthMenu);
	}

	public SysAuthMenu selectById(Integer userId, Integer sysAuthMenuId) throws BusinessException {
		return this.sysAuthMenuMapper.selectById(sysAuthMenuId);
	}

	public Integer delete(Integer userId, SysAuthMenu where) throws BusinessException {
		return this.sysAuthMenuMapper.delete(where);
	}

	public Integer deleteById(Integer userId, Integer sysAuthMenuId) throws BusinessException {
		return this.sysAuthMenuMapper.deleteById(sysAuthMenuId);
	}
}
