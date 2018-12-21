package com.fun.api.service;

import com.fun.api.domain.OrderManage;
import com.fun.api.repository.OrderManageMapper;
import com.fun.client.domain.GoodsInfo;
import com.fun.client.domain.MemUserInfo;
import com.fun.client.service.GoodsInfoService;
import com.fun.client.service.MemUserInfoService;
import com.fun.framework.domain.Pagination;
import com.fun.framework.service.BaseService;
import com.fun.framework.web.dto.QueryDto;
import com.fun.le.service.SysPropSettingService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderManageService extends BaseService {
    private @Autowired
    OrderManageMapper orderManageMapper;
    private @Autowired
    MemUserInfoService memUserInfoService;
    private @Autowired
    GoodsInfoService goodsInfoService;

    //订单发货列表
    public Pagination<OrderManage> selectGoodsOrderList(OrderManage orderManage, QueryDto queryDto) {
        PageHelper.startPage(queryDto.getPage(), queryDto.getRows(), true);
        Page<OrderManage> page = this.orderManageMapper.selectGoodsOrderList(orderManage, queryDto);
        for (int i = 0; i < page.getResult().size(); i++) {
            if (page.getResult().get(i).getGameType() == 1) {
                GoodsInfo goodsInfo = this.goodsInfoService.selectById(page.getResult().get(i).getGoodsId());
                if (page.getResult().get(i).getResult() == page.getResult().get(i).getPromotionType()) {
                    GoodsInfo goodsInfo1 = this.goodsInfoService.selectById(goodsInfo.getGoodSourceId());//原来商品信息
                    MemUserInfo memUserInfo = this.memUserInfoService.selectById(page.getResult().get(i).getCreateUser());//用户
                    MemUserInfo memUserInfo1 = this.memUserInfoService.selectById(memUserInfo.getAgentId().intValue());
                    if (memUserInfo.getAgentId() == 0) {
                        page.getResult().get(i).setPrice((double) Math.round(goodsInfo1.getPrice() * 1.9));
                    } else {
                        double extension = memUserInfo1.getExtension();//上级设置的推广比例
                        page.getResult().get(i).setPrice((double) Math.round(goodsInfo1.getPrice() * extension));
                    }
                }
            }

            if (page.getResult().get(i).getGameType() == 2) {
                GoodsInfo goodsInfo = this.goodsInfoService.selectById(page.getResult().get(i).getGoodsId());
                if (page.getResult().get(i).getResult() == 3) {
                    GoodsInfo goodsInfo1 = this.goodsInfoService.selectById(goodsInfo.getGoodSourceId());//原来商品信息
                    MemUserInfo memUserInfo = this.memUserInfoService.selectById(page.getResult().get(i).getCreateUser());//用户
                    MemUserInfo memUserInfo1 = this.memUserInfoService.selectById(memUserInfo.getAgentId().intValue());
                    if (memUserInfo.getAgentId() == 0) {
                        page.getResult().get(i).setPrice((double) Math.round(goodsInfo1.getPrice() * 1.9));
                    } else {
                        double extension = memUserInfo1.getExtension();//上级设置的推广比例
                        page.getResult().get(i).setPrice((double) Math.round(goodsInfo1.getPrice() * extension));
                    }
                }
            }
        }
        return new Pagination<>(page.getTotal(), page.getResult());
    }

    public Pagination<OrderManage> selectIsIntegralOrderList(OrderManage orderManage, QueryDto queryDto) {
        PageHelper.startPage(queryDto.getPage(), queryDto.getRows(), true);
        Page<OrderManage> page = this.orderManageMapper.selectIsIntegralOrderList(orderManage, queryDto);
        return new Pagination<>(page.getTotal(), page.getResult());
    }

    public Pagination<OrderManage> promotionManageDjdlList(OrderManage orderManage, QueryDto queryDto) {
        PageHelper.startPage(queryDto.getPage(), queryDto.getRows(), true);
        Page<OrderManage> page = this.orderManageMapper.promotionManageDjdlList(orderManage, queryDto);
        GoodsInfo goodsInfo1;
        for (int i = 0; i < page.getResult().size(); i++) {
            if (page.getResult().get(i).getResult() == page.getResult().get(i).getPromotionType()) {
                GoodsInfo goodsInfo = this.goodsInfoService.selectById(page.getResult().get(i).getGoodsId());
                goodsInfo1 = this.goodsInfoService.selectById(goodsInfo.getGoodSourceId());//原来商品信息
                MemUserInfo memUserInfo = this.memUserInfoService.selectById(page.getResult().get(i).getCreateUser());//用户
                MemUserInfo memUserInfo1 = this.memUserInfoService.selectById(memUserInfo.getAgentId().intValue());//用户上级
                if (memUserInfo.getAgentId() == 0) {
                    page.getResult().get(i).setPrice((double) Math.round(goodsInfo1.getPrice() * 1.9));
                }
                if (memUserInfo.getAgentId() != 0) {
                    double extension = memUserInfo1.getExtension();//上级设置的推广比例
                    page.getResult().get(i).setPrice((double) Math.round(goodsInfo1.getPrice() * extension));
                }
            } else {
                page.getResult().get(i).setPrice(0.0);
            }
        }
        return new Pagination<>(page.getTotal(), page.getResult());
    }

    public Pagination<OrderManage> promotionManageQhbList(OrderManage orderManage, QueryDto queryDto) {
        PageHelper.startPage(queryDto.getPage(), queryDto.getRows(), true);
        Page<OrderManage> page = this.orderManageMapper.promotionManageQhbList(orderManage, queryDto);
        for (int i = 0; i < page.getResult().size(); i++) {
            if (page.getResult().get(i).getResult() == 3) {
                GoodsInfo goodsInfo = this.goodsInfoService.selectById(page.getResult().get(i).getGoodsId());
                GoodsInfo goodsInfo1 = this.goodsInfoService.selectById(goodsInfo.getGoodSourceId());//原来商品信息
                MemUserInfo memUserInfo = this.memUserInfoService.selectById(page.getResult().get(i).getCreateUser());//用户
                MemUserInfo memUserInfo1 = this.memUserInfoService.selectById(memUserInfo.getAgentId().intValue());
                if (memUserInfo.getAgentId() == 0) {
                    page.getResult().get(i).setPrice((double) Math.round(goodsInfo1.getPrice() * 1.9));
                } else {
                    double extension = memUserInfo1.getExtension();//上级设置的推广比例
                    page.getResult().get(i).setPrice((double) Math.round(goodsInfo1.getPrice() * extension));
                }
            } else {
                page.getResult().get(i).setPrice(0.0);
            }
        }
        return new Pagination<>(page.getTotal(), page.getResult());
    }

    //请求发货订单列表
    public Pagination<OrderManage> requestOrderList(OrderManage orderManage, QueryDto queryDto) {
        PageHelper.startPage(queryDto.getPage(), queryDto.getRows(), true);
        Page<OrderManage> page = this.orderManageMapper.requestOrderList(orderManage, queryDto);
        for (int i = 0; i < page.getResult().size(); i++) {
            if (page.getResult().get(i).getGameType() == 1) {
                GoodsInfo goodsInfo = this.goodsInfoService.selectById(page.getResult().get(i).getGoodsId());
                if (page.getResult().get(i).getResult() == page.getResult().get(i).getPromotionType()) {
                    GoodsInfo goodsInfo1 = this.goodsInfoService.selectById(goodsInfo.getGoodSourceId());//原来商品信息
                    MemUserInfo memUserInfo = this.memUserInfoService.selectById(page.getResult().get(i).getCreateUser());//用户
                    MemUserInfo memUserInfo1 = this.memUserInfoService.selectById(memUserInfo.getAgentId().intValue());
                    if (memUserInfo.getAgentId() == 0) {
                        page.getResult().get(i).setPrice((double) Math.round(goodsInfo1.getPrice() * 1.9));
                    } else {
                        double extension = memUserInfo1.getExtension();//上级设置的推广比例
                        page.getResult().get(i).setPrice((double) Math.round(goodsInfo1.getPrice() * extension));
                    }
                }
            }

            if (page.getResult().get(i).getGameType() == 2) {
                GoodsInfo goodsInfo = this.goodsInfoService.selectById(page.getResult().get(i).getGoodsId());
                if (page.getResult().get(i).getResult() == 3) {
                    GoodsInfo goodsInfo1 = this.goodsInfoService.selectById(goodsInfo.getGoodSourceId());//原来商品信息
                    MemUserInfo memUserInfo = this.memUserInfoService.selectById(page.getResult().get(i).getCreateUser());//用户
                    MemUserInfo memUserInfo1 = this.memUserInfoService.selectById(memUserInfo.getAgentId().intValue());
                    if (memUserInfo.getAgentId() == 0) {
                        page.getResult().get(i).setPrice((double) Math.round(goodsInfo1.getPrice() * 1.9));
                    } else {
                        double extension = memUserInfo1.getExtension();//上级设置的推广比例
                        page.getResult().get(i).setPrice((double) Math.round(goodsInfo1.getPrice() * extension));
                    }
                }
            }
        }

        return new Pagination<>(page.getTotal(), page.getResult());
    }

}

