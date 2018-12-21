package com.fun.client.repository;

import com.fun.client.domain.ExtensionInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface ExtensionInfoMapper {
    //插入数据
  Integer insert(@Param("extensionInfo") ExtensionInfo extensionInfo);

  Integer update(@Param("extensionInfo") ExtensionInfo extensionInfo);

  List<ExtensionInfo> select(@Param("extensionInfo") ExtensionInfo extensionInfo);

  ExtensionInfo selectById(@Param("extensionInfoId") Integer extensionInfoId);
}
