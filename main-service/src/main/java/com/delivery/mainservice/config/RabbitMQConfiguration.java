package com.delivery.mainservice.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {

    static final String queueName = "firstQueue";
    static final String queueGrpc = "queueGrpc";
    static final String queueNotification = "queueNotification";

    static final String exchangeName = "testExchange";

    @Bean
    public Queue myQueue() {
        return new Queue(queueName, false);
    }

    @Bean
    public Queue grpcQueue() {
        return new Queue(queueGrpc, false);
    }

    @Bean
    public Queue notificationQueue() {
        return new Queue(queueNotification, false);
    }

    @Bean
    public Exchange exchange() {
        return new TopicExchange(exchangeName, false, false);
    }

    @Bean
    public Binding firstQueueBinding(Queue myQueue, Exchange exchange) {
        return BindingBuilder.bind(myQueue).to(exchange).with("my.key").noargs();
    }

    @Bean
    public Binding secondQueueBinding(Queue grpcQueue, Exchange exchange) {
        return BindingBuilder.bind(grpcQueue).to(exchange).with("grpc.key").noargs();
    }

    @Bean
    public Binding notificationQueueBinding(Queue notificationQueue, Exchange exchange) {
        return BindingBuilder.bind(notificationQueue).to(exchange).with("notification.key").noargs();
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }
}
