package com.bootmybatis.controller;

import com.bootmybatis.jms.JmsMsg;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Bean
    public Queue myQueue(){
        return new Queue("my-queue");
    }

    @RequestMapping(value = "/jms", method = RequestMethod.GET)
    @ResponseBody
    public String setJMSMsg(String msg) {
        jmsTemplate.send("dest", new JmsMsg(msg));
        return "success";
    }

    @RequestMapping(value = "/rabbit", method = RequestMethod.GET)
    @ResponseBody
    public String setRabbitMsg(String msg) {
        rabbitTemplate.convertAndSend("my-queue", msg);
        return "success";
    }

}
