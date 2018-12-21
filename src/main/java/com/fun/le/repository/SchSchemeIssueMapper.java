package com.fun.le.repository;

import java.util.Date;
import java.util.List;

import com.fun.framework.web.dto.QueryDto;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.fun.le.entities.SchSchemeIssue;
@Mapper
public interface SchSchemeIssueMapper
{
  Integer insert(@Param("schSchemeIssue") SchSchemeIssue paramSchSchemeIssue);

  Integer insertBatch(@Param("schSchemeIssues") List<SchSchemeIssue> paramList);

  Integer update(@Param("schSchemeIssue") SchSchemeIssue paramSchSchemeIssue1, @Param("where") SchSchemeIssue paramSchSchemeIssue2);

  Integer updateById(@Param("schSchemeIssue") SchSchemeIssue paramSchSchemeIssue, @Param("schSchemeIssueId") Integer paramInteger);

  Integer updateActive(@Param("schSchemeIssue") SchSchemeIssue paramSchSchemeIssue1, @Param("where") SchSchemeIssue paramSchSchemeIssue2);

  Integer updateActiveById(@Param("schSchemeIssue") SchSchemeIssue paramSchSchemeIssue, @Param("schSchemeIssueId") Integer paramInteger);

  List<SchSchemeIssue> select(@Param("schSchemeIssue") SchSchemeIssue paramSchSchemeIssue);

  SchSchemeIssue selectById(@Param("schSchemeIssueId") Integer paramInteger);

  Integer delete(@Param("where") SchSchemeIssue paramSchSchemeIssue);

  Integer deleteById(@Param("schSchemeIssueId") Integer paramInteger);

  Page<SchSchemeIssue> listIssues(@Param("where")QueryDto where);
}

