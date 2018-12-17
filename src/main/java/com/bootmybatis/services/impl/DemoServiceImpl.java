package com.bootmybatis.services.impl;

import com.bootmybatis.dao.ZmsyComplaintMapper;
import com.bootmybatis.model.ZmsyComplaint;
import com.bootmybatis.services.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

/**
 * Created by mr on 2018/12/17.
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private ZmsyComplaintMapper zmsyComplaintMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int addInfo(ZmsyComplaint zmsyComplaint) throws IOException{
        int res = zmsyComplaintMapper.insert(zmsyComplaint);
        throw new IOException();
        //return res;
    }
}
