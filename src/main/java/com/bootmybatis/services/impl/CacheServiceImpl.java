package com.bootmybatis.services.impl;

import com.bootmybatis.dao.ZmsyComplaintMapper;
import com.bootmybatis.model.ZmsyComplaint;
import com.bootmybatis.model.ZmsyComplaintWithBLOBs;
import com.bootmybatis.services.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CacheServiceImpl implements CacheService{

    @Autowired
    private ZmsyComplaintMapper zmsyComplaintMapper;

    /**
     * 缓存列表
     * @return
     */
    @Cacheable(value = "coList",key = "#root.methodName")
    @Override
    public List<ZmsyComplaintWithBLOBs> getCacheList() {
        return zmsyComplaintMapper.findAll();
    }

    /**
     * 添加后清除缓存
     * @param zmsyComplaint
     * @return
     */
    @CacheEvict(value = "coList",allEntries = true)
    @Override
    public int saveBean(ZmsyComplaintWithBLOBs zmsyComplaint) {
        return zmsyComplaintMapper.insertSelective(zmsyComplaint);
    }
}
