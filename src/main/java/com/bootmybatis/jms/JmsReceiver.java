package com.bootmybatis.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * 接收者，一般发送端和接收端不在一个程序内，此处为测试
 * Created by mr on 2018/12/26.
 */
@Component
public class JmsReceiver {

    @JmsListener(destination = "dest")
    public void recevierMsg(String msg) {
        System.out.println("接收到消息：" + msg);
    }

}
