package com.bootmybatis.amqp;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by mr on 2018/12/26.
 */
@Component
public class RabbitReceiver {

    @RabbitListener(queues = "my-queue")
    public void receiverMsg(String msg){
        System.out.println("接收到Rabbit消息：" + msg);
    }

}
