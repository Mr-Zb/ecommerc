package com.fun.le.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.fun.le.entities.SysAuthMenu;

@Mapper
public interface SysAuthMenuMapper
{
  Integer insert(@Param("sysAuthMenu") SysAuthMenu paramSysAuthMenu);

  Integer insertBatch(@Param("sysAuthMenus") List<SysAuthMenu> paramList);

  Integer update(@Param("sysAuthMenu") SysAuthMenu paramSysAuthMenu1, @Param("where") SysAuthMenu paramSysAuthMenu2);

  Integer updateById(@Param("sysAuthMenu") SysAuthMenu paramSysAuthMenu, @Param("sysAuthMenuId") Integer paramInteger);

  Integer updateActive(@Param("sysAuthMenu") SysAuthMenu paramSysAuthMenu1, @Param("where") SysAuthMenu paramSysAuthMenu2);

  Integer updateActiveById(@Param("sysAuthMenu") SysAuthMenu paramSysAuthMenu, @Param("sysAuthMenuId") Integer paramInteger);

  List<SysAuthMenu> select(@Param("sysAuthMenu") SysAuthMenu paramSysAuthMenu);

  List<SysAuthMenu> selectByIds(@Param("ids") List<String> ids);

  SysAuthMenu selectById(@Param("sysAuthMenuId") Integer paramInteger);

  Integer delete(@Param("where") SysAuthMenu paramSysAuthMenu);

  Integer deleteById(@Param("sysAuthMenuId") Integer paramInteger);
}

