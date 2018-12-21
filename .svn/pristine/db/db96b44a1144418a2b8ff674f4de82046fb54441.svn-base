package com.fun.le.repository;

import java.util.List;
import java.util.Map;

import com.fun.client.domain.MemTeam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.fun.le.entities.SysPropSetting;

@Mapper
public interface SysPropSettingMapper {
    Integer insert(@Param("sysPropSetting") SysPropSetting paramSysPropSetting);

    Integer insertBatch(@Param("sysPropSettings") List<SysPropSetting> paramList);

    Integer update(@Param("sysPropSetting") SysPropSetting paramSysPropSetting1, @Param("where") SysPropSetting paramSysPropSetting2);

    Integer updateById(@Param("sysPropSetting") SysPropSetting paramSysPropSetting, @Param("sysPropSettingId") Integer paramInteger);

    Integer updateActive(@Param("sysPropSetting") SysPropSetting paramSysPropSetting1, @Param("where") SysPropSetting paramSysPropSetting2);

    Integer updateByUserId(@Param("sysPropSetting") SysPropSetting paramSysPropSetting, @Param("sysPropSettingId") Integer userId);

    Integer updateActiveById(@Param("sysPropSetting") SysPropSetting paramSysPropSetting, @Param("sysPropSettingId") Integer paramInteger);

    List<SysPropSetting> select(@Param("sysPropSetting") SysPropSetting paramSysPropSetting);

    SysPropSetting selectById(@Param("sysPropSettingId") Integer paramInteger);

    List<SysPropSetting> selectByUserId(@Param("sysPropSettingId") Integer paramInteger);

    Integer delete(@Param("where") SysPropSetting paramSysPropSetting);

    Integer deleteById(@Param("sysPropSettingId") Integer paramInteger);

    String sysUserRebate(@Param("userId") Integer userId);

    //查询推广比例
    String sysUserExtension(@Param("userId") Integer userId);

    //查询上级里推广比例
    String selectSuperiorExtension(@Param("userId") Integer userId);

    List<SysPropSetting> selectALiMessageSetting();

    //查询版本号和客服QQ号
    List<SysPropSetting> selectDataVersion();

    String selectMessage(@Param("propKey") String propKey);
}

