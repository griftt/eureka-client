package com.griftt.orderserver.mq;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    //@RabbitListener(queuesToDeclare= {@Queue("productInfo")},)
    /*@RabbitListener(bindings =@QueueBinding(
            value=@Queue("mymsg"),
            exchange =@Exchange("myexchange"),
            key = "msg"
    ))*/
    @RabbitListener(bindings =@QueueBinding(
            exchange = @Exchange("orderex"),
            key = "#",
            value =@Queue("productInfo")
    ))
    public void msg( Object obj){
        System.err.println(obj);
    }



}