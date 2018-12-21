package com.fun.client.repository;

import com.fun.client.domain.MenuInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface MenuInfoMapper {
    /**
     * 插入新菜单
     * @param menuInfo
     * @return
     */
    Integer insert(@Param("menuInfo") MenuInfo menuInfo);

    /**
     * 查询所有的菜单
     * @param menuInfo
     * @return
     */
    List<MenuInfo> select(@Param("menuInfo") MenuInfo menuInfo);

    /**
     * 通过ID查询菜单
     * @param menuInfoId
     * @return
     */
    MenuInfo selectById(@Param("menuInfoId") Integer menuInfoId);

    /**
     * 修改菜单
     * @param menuInfo
     * @return
     */
    Integer update(@Param("menuInfo") MenuInfo menuInfo);

    /**
     * 根据ID删除菜单
     * @param menuInfoId
     * @return
     */
    Integer deleteById(@Param("menuInfoId") Integer menuInfoId);
}
