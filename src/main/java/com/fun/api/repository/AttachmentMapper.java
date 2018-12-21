package com.fun.api.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.fun.api.domain.SysAttachment;

@Mapper
public interface AttachmentMapper {
	/**
	 * 查询最后一个ID
	 * 
	 * @return
	 */
	@Select("SELECT IFNULL(MAX(pk_Id), 0) + 1 AS pk_id FROM t_sys_attachment")
	Long getLastId();

	@Select("SELECT * FROM t_sys_attachment WHERE pk_id = #{id}")
	SysAttachment getById(@Param("id") Long id);

}
