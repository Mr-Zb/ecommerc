package com.fun.client.repository;

import com.fun.client.domain.BannerInfo;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface BannerInfoMapper {
    /**
     * 新增轮播图信息
     * @param bannerInfo
     * @return
     */
    Integer insert(@Param("bannerInfo")BannerInfo bannerInfo);

    /**
     * 分页查找所有轮播图信息
     * @param bannerInfo
     * @return
     */
    Page<BannerInfo> select(@Param("bannerInfo")BannerInfo bannerInfo);

    /**
     * 查询开启状态的所有轮播图信息
     * @param bannerInfo
     * @return
     */
    List<BannerInfo> selectByState(@Param("bannerInfo")BannerInfo bannerInfo);

    /**
     * 通过ID查询轮播图
     * @param bannerInfoId
     * @return
     */
    BannerInfo  selectById(@Param("bannerInfoId")Integer bannerInfoId);

    /**
     * 更新轮播图信息
     * @param bannerInfo
     * @return
     */
    Integer update(@Param("bannerInfo")BannerInfo bannerInfo);

    /**
     * 根据ID删除轮播图信息
     * @param bannerInfoId
     * @return
     */
    Integer deleteById(@Param("bannerInfoId")Integer bannerInfoId);
}
