package com.bootmybatis.controller;

import com.bootmybatis.jms.JmsMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by mr on 2018/12/26.
 */
@Controller
public class MsgController {

    @Autowired
    JmsTemplate jmsTemplate;

    @RequestMapping(value = "/jms", method = RequestMethod.GET)
    @ResponseBody
    public String setJMSMsg(String msg) {
        jmsTemplate.send("dest", new JmsMsg(msg));
        return "success";
    }

}
