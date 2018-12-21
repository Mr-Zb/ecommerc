package com.fun.api.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.fun.api.domain.SysAttachment;

@Mapper
public interface SysAttachmentMapper {
	
	/**
	 * 插入数据
	 * 
	 * @param sysAttachment
	 * @return
	 */
	Integer insert(@Param("sysAttachment") SysAttachment sysAttachment);
	
	/**
	 * 更新数据
	 * 
	 * @param sysAttachment
	 * @param where
	 * @return
	 */
	Integer update(@Param("sysAttachment") SysAttachment sysAttachment, @Param("where") SysAttachment where);

	/**
	 * 根据主键更新
	 * 
	 * @param sysAttachment
	 * @param sysAttachmentId
	 * @return
	 */
	Integer updateById(@Param("sysAttachment") SysAttachment sysAttachment, @Param("sysAttachmentId") Long sysAttachmentId);
	
	/**
	 * 更新有值数据
	 * 
	 * @param sysAttachment
	 * @param where
	 * @return
	 */
	Integer updateActive(@Param("sysAttachment") SysAttachment sysAttachment, @Param("where") SysAttachment where);

	/**
	 * 根据主键更新有值数据
	 * 
	 * @param sysAttachment
	 * @param sysAttachmentId
	 * @return
	 */
	Integer updateActiveById(@Param("sysAttachment") SysAttachment sysAttachment, @Param("sysAttachmentId") Long sysAttachmentId);

	/**
	 * 查询列表
	 * 
	 * @param sysAttachment
	 * @return
	 */
	List<SysAttachment> select(@Param("sysAttachment") SysAttachment sysAttachment);

	/**
	 * 根据主键查询
	 * 
	 * @param sysAttachmentId
	 * @return
	 */
	SysAttachment selectById(@Param("sysAttachmentId") Long sysAttachmentId);

	/**
	 * 按条件删除
	 * 
	 * @param where
	 * @return
	 */
	Integer delete(@Param("where") SysAttachment where);

	/**
	 * 按主键删除
	 * 
	 * @param sysAttachmentId
	 * @return
	 */
	Integer deleteById(@Param("sysAttachmentId") Long sysAttachmentId);
}
