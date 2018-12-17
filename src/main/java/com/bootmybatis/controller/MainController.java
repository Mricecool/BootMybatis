package com.bootmybatis.controller;

import com.bootmybatis.dao.ZmsyCenterMapper;
import com.bootmybatis.model.ZmsyCenter;
import com.bootmybatis.model.ZmsyComplaint;
import com.bootmybatis.model.ZmsyComplaintWithBLOBs;
import com.bootmybatis.services.CacheService;
import com.bootmybatis.services.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by mr on 2018/12/17.
 */
@Controller
public class MainController {

    @Autowired
    private ZmsyCenterMapper zmsyCenterMapper;

    @Autowired
    private DemoService demoService;

    @Autowired
    private CacheService cacheService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String hello() {
        return "Hello World";
    }

    @RequestMapping(value = "/list", produces = "application/json;charset=utf-8", method = RequestMethod.GET)
    @ResponseBody
    public List<ZmsyCenter> list() {
        zmsyCenterMapper.findAll();
        System.out.println("执行了一次查询，mybatis的一级缓存失效了");
        return zmsyCenterMapper.findAll();
    }

    @RequestMapping(value = "/listByPid", produces = "application/xml;charset=utf-8", method = RequestMethod.GET)
    @ResponseBody
    public List<ZmsyCenter> listByPid(int parentId) {
        return zmsyCenterMapper.selectByParentId(parentId);
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    @ResponseBody
    public String add() throws IOException {
        ZmsyComplaintWithBLOBs zmsyComplaint = new ZmsyComplaintWithBLOBs();
        zmsyComplaint.setComplaintdate(new Date(System.currentTimeMillis()));
        zmsyComplaint.setComplaintcontent("测试boot事务");
        zmsyComplaint.setComplainttitle("测试事务支持");
        zmsyComplaint.setComplaintType(1);
        zmsyComplaint.setUsername("666--" + System.currentTimeMillis());
        int res = demoService.addInfo(zmsyComplaint);
        if (res > 0) {
            return "success";
        }
        return "error";
    }

    @RequestMapping(value = "/listCache", produces = "application/json;charset=utf-8", method = RequestMethod.GET)
    @ResponseBody
    public List<ZmsyComplaintWithBLOBs> listCache() {
        return cacheService.getCacheList();
    }

    @RequestMapping(value = "/addCache", method = RequestMethod.GET)
    @ResponseBody
    public String addCache() {
        ZmsyComplaintWithBLOBs zmsyComplaint = new ZmsyComplaintWithBLOBs();
        zmsyComplaint.setComplaintdate(new Date(System.currentTimeMillis()));
        zmsyComplaint.setComplaintcontent("测试Cache"+ System.currentTimeMillis());
        zmsyComplaint.setComplainttitle("测试Cache支持"+ System.currentTimeMillis());
        zmsyComplaint.setComplaintType(1);
        zmsyComplaint.setUsername("666--" + System.currentTimeMillis());
        int res = cacheService.saveBean(zmsyComplaint);
        if (res > 0) {
            return "success";
        }
        return "error";
    }
}
