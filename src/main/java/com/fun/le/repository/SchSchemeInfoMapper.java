package com.fun.le.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.fun.le.entities.SchSchemeInfo;
@Mapper
public interface SchSchemeInfoMapper
{
  Integer insert(@Param("schSchemeInfo") SchSchemeInfo paramSchSchemeInfo);

  Integer insertBatch(@Param("schSchemeInfos") List<SchSchemeInfo> paramList);

  Integer update(@Param("schSchemeInfo") SchSchemeInfo paramSchSchemeInfo1, @Param("where") SchSchemeInfo paramSchSchemeInfo2);

  Integer updateById(@Param("schSchemeInfo") SchSchemeInfo paramSchSchemeInfo, @Param("schSchemeInfoId") Integer paramInteger);

  Integer updateActive(@Param("schSchemeInfo") SchSchemeInfo paramSchSchemeInfo1, @Param("where") SchSchemeInfo paramSchSchemeInfo2);

  Integer updateActiveById(@Param("schSchemeInfo") SchSchemeInfo paramSchSchemeInfo, @Param("schSchemeInfoId") Integer paramInteger);

  List<SchSchemeInfo> select(@Param("schSchemeInfo") SchSchemeInfo paramSchSchemeInfo);

  SchSchemeInfo selectById(@Param("schSchemeInfoId") Integer paramInteger);

  Integer delete(@Param("where") SchSchemeInfo paramSchSchemeInfo);

  Integer deleteById(@Param("schSchemeInfoId") Integer paramInteger);
}
