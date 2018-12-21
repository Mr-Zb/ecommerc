package com.fun.client.service;

import com.fun.client.domain.ExtensionInfo;
import com.fun.client.repository.ExtensionInfoMapper;
import com.fun.framework.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ExtensionInfoService extends BaseService {
    @Autowired
    private ExtensionInfoMapper extensionInfoMapper;

    /**
     * 插入数据
     * @param extensionInfo
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class}, readOnly = false)
    public Integer insert(ExtensionInfo extensionInfo) {
        return this.extensionInfoMapper.insert(extensionInfo);
    }

    /**
     * 修改数据
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class}, readOnly = false)
    public Integer update(ExtensionInfo extensionInfo){
        return this.extensionInfoMapper.update(extensionInfo);
    }

    /**
     * 查询数据
     * @param extensionInfo
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class}, readOnly = false)
    public List<ExtensionInfo> select(ExtensionInfo extensionInfo) {
        return this.extensionInfoMapper.select(extensionInfo);
    }

    /**
     * 根据ID查询
     * @param pkId
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class}, readOnly = false)
    public ExtensionInfo selectById(Integer pkId) {
        return this.extensionInfoMapper.selectById(pkId);
    }
}
