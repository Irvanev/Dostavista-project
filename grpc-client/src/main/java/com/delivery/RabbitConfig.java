package com.delivery;


import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    public static final String ORDER_QUEUE = "queueGrpc";

    @Bean
    public Queue orderQueue() {
        return new Queue(ORDER_QUEUE);
    }
}
