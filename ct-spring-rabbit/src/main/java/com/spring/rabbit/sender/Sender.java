package com.spring.rabbit.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.time.LocalDate;

/**
 * Created by Herdsric-M-003 on 2018/6/27.
 */
@Component
public class Sender {
    @Autowired
    private AmqpTemplate amqpTemplate;
    public void send(){
        String context = "hello" + LocalDate.now();
        System.out.println("Sender:"+context);
        amqpTemplate.convertAndSend("hello",context);
    }
}
