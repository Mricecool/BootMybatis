package com.bootmybatis.services.impl;

import com.bootmybatis.dao.MongoDao;
import com.bootmybatis.dao.ZmsyComplaintMapper;
import com.bootmybatis.model.Person;
import com.bootmybatis.model.ZmsyComplaint;
import com.bootmybatis.model.ZmsyComplaintWithBLOBs;
import com.bootmybatis.services.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

/**
 * Created by mr on 2018/12/17.
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private ZmsyComplaintMapper zmsyComplaintMapper;

    @Autowired
    private MongoDao mongoDao;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int addInfo(ZmsyComplaintWithBLOBs zmsyComplaint) throws IOException{
        int res = zmsyComplaintMapper.insert(zmsyComplaint);
        throw new IOException();
        //return res;
    }

    @Transactional
    @Override
    public int addInfoNormal(ZmsyComplaintWithBLOBs zmsyComplaint) {
        return zmsyComplaintMapper.insert(zmsyComplaint);
    }

    @Override
    public List<Person> getMongoList() {
        return mongoDao.findAll();
    }

    @Override
    public Person addMongo(Person person) {
        return mongoDao.insert(person);
    }

    @Override
    public Person getPerson(String pName) {
        return mongoDao.findByPName(pName);
    }
}
