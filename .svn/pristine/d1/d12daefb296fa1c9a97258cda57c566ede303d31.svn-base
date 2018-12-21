package com.fun.le.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.fun.le.entities.SchSchemeDetail;
@Mapper
public interface SchSchemeDetailMapper {
	Integer insert(@Param("schSchemeDetail") SchSchemeDetail paramSchSchemeDetail);

	Integer insertBatch(@Param("schSchemeDetails") List<SchSchemeDetail> paramList);

	Integer update(@Param("schSchemeDetail") SchSchemeDetail paramSchSchemeDetail1,
                   @Param("where") SchSchemeDetail paramSchSchemeDetail2);

	Integer updateById(@Param("schSchemeDetail") SchSchemeDetail paramSchSchemeDetail,
                       @Param("schSchemeDetailId") Integer paramInteger);

	Integer updateActive(@Param("schSchemeDetail") SchSchemeDetail paramSchSchemeDetail1,
                         @Param("where") SchSchemeDetail paramSchSchemeDetail2);

	Integer updateActiveById(@Param("schSchemeDetail") SchSchemeDetail paramSchSchemeDetail,
                             @Param("schSchemeDetailId") Integer paramInteger);

	List<SchSchemeDetail> select(@Param("schSchemeDetail") SchSchemeDetail paramSchSchemeDetail);
	
	SchSchemeDetail selectById(@Param("schSchemeDetailId") Integer paramInteger);
	//
	List<SchSchemeDetail> selectBySchemeId(@Param("schSchemeDetailId") Integer paramInteger, @Param("userId") Integer userId);

	Integer delete(@Param("where") SchSchemeDetail paramSchSchemeDetail);

	Integer deleteById(@Param("schSchemeDetailId") Integer paramInteger);
}
