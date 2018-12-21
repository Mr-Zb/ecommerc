package com.fun.api.repository;

import org.apache.ibatis.annotations.Mapper;

import com.fun.api.domain.AdminPayInfoQueryDto;
import com.fun.api.domain.PayInfo;
import com.github.pagehelper.Page;

@Mapper
public interface AdminPayInfoMapper {

	Page<PayInfo> listPayInfos(AdminPayInfoQueryDto queryDto);

}
