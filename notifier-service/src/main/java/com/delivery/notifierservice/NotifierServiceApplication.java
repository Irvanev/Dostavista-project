package com.delivery.notifierservice;

import com.delivery.notifierservice.service.NotificationService;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class NotifierServiceApplication {

	static final String queueName = "queueNotification";
	private final NotificationService notificationService;

	public NotifierServiceApplication(NotificationService notificationService) {
		this.notificationService = notificationService;
	}

	@Bean
	public Queue myQueue() {
		return new Queue(queueName, false);
	}

	@RabbitListener(queues = queueName)
	public void listener(String message) {
		System.out.println("Message read from firstQueue : " + message);
		notificationService.sendNotification(message);
	}

	public static void main(String[] args) {
		SpringApplication.run(NotifierServiceApplication.class, args);
	}

}
