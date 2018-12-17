package com.bootmybatis.controller;

import com.bootmybatis.dao.ZmsyCenterMapper;
import com.bootmybatis.model.ZmsyCenter;
import com.bootmybatis.model.ZmsyComplaint;
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

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String hello() {
        return "Hello World";
    }

    @RequestMapping(value = "/list", produces = "application/json;charset=utf-8", method = RequestMethod.GET)
    @ResponseBody
    public List<ZmsyCenter> list() {
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
        ZmsyComplaint zmsyComplaint = new ZmsyComplaint();
        zmsyComplaint.setComplaintdate(new Date(System.currentTimeMillis()));
        zmsyComplaint.setContent("测试boot事务");
        zmsyComplaint.setTitle("测试事务支持");
        zmsyComplaint.setComplainttype(1);
        zmsyComplaint.setName("666--" + System.currentTimeMillis());
        int res = demoService.addInfo(zmsyComplaint);
        if (res > 0) {
            return "success";
        }
        return "error";
    }
}
