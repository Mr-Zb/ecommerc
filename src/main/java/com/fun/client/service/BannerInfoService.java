package com.fun.client.service;

import com.fun.client.domain.BannerInfo;
import com.fun.client.repository.BannerInfoMapper;
import com.fun.framework.domain.Pagination;
import com.fun.framework.service.BaseService;
import com.fun.framework.web.dto.QueryDto;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerInfoService extends BaseService {
    private @Autowired BannerInfoMapper bannerInfoMapper;
    /**
     * 新增轮播图信息
     * @param bannerInfo
     * @return
     */
    public Integer insert(BannerInfo bannerInfo){
        return bannerInfoMapper.insert(bannerInfo);
    }

    /**
     * 分页查找所有轮播图信息
     * @param bannerInfo
     * @return
     */
    public Pagination<BannerInfo> select(QueryDto queryDto , BannerInfo bannerInfo){
        PageHelper.startPage(queryDto.getPage().intValue(), queryDto.getRows().intValue(), true);
        Page<BannerInfo> page = bannerInfoMapper.select(bannerInfo);
        return new Pagination<BannerInfo>(page.getTotal(), page.getResult());
    }
    /**
     * 查询开启状态的所有轮播图信息
     * @param bannerInfo
     * @return
     */
    public List<BannerInfo> selectByState(BannerInfo bannerInfo){
        return bannerInfoMapper.selectByState(bannerInfo);
    }

    /**
     * 通过ID查询轮播图
     * @param bannerInfoId
     * @return
     */
    public BannerInfo  selectById(Integer bannerInfoId){
        return bannerInfoMapper.selectById(bannerInfoId);
    }

    /**
     * 更新轮播图信息
     * @param bannerInfo
     * @return
     */
    public Integer update(BannerInfo bannerInfo){
        return bannerInfoMapper.update(bannerInfo);
    }

    /**
     * 根据ID删除轮播图信息
     * @param bannerInfoId
     * @return
     */
    public Integer deleteById(Integer bannerInfoId){
        return bannerInfoMapper.deleteById(bannerInfoId);
    }
}
