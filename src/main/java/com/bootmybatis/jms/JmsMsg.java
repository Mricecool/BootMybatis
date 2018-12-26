package com.bootmybatis.jms;

import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Created by mr on 2018/12/26.
 */
public class JmsMsg implements MessageCreator {

    String msg;

    public JmsMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public Message createMessage(Session session) throws JMSException {
        return session.createTextMessage(msg);
    }
}
