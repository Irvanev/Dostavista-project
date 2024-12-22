package com.delivery.payservice;

import com.delivery.payservice.models.OrderPaymentMessage;
import com.delivery.payservice.models.Payment;
import com.delivery.payservice.repositories.PaymentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class PayServiceApplication {

    static final String queueName = "firstQueue";
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final PaymentRepository paymentRepository;

    public PayServiceApplication(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Bean
    Queue myQueue() {
        return new Queue(queueName, false);
    }

    @RabbitListener(queues = queueName)
    @Transactional
    public void listener(String message) {
        try {
            OrderPaymentMessage paymentMessage = objectMapper.readValue(message, OrderPaymentMessage.class);

            if (paymentMessage.getRequisite() == null || paymentMessage.getRequisite().isEmpty()) {
                System.out.println("Ошибка: Реквизиты отсутствуют для курьера ID " + paymentMessage.getCourierId());
                savePaymentReport(paymentMessage, "FAILED");
                return;
            }

            processPayment(paymentMessage);
            savePaymentReport(paymentMessage, "SUCCESS");

        } catch (Exception e) {
            System.err.println("Ошибка при обработке сообщения: " + e.getMessage());
        }
    }

    private void processPayment(OrderPaymentMessage paymentMessage) {
        System.out.println("Выплата курьеру ID: " + paymentMessage.getCourierId() +
                " на сумму: " + paymentMessage.getPrice() +
                " по реквизитам: " + paymentMessage.getRequisite());
    }

    private void savePaymentReport(OrderPaymentMessage paymentMessage, String status) {
        Payment paymentReport = new Payment(paymentMessage.getCourierId(),
                paymentMessage.getPrice(),
                paymentMessage.getRequisite(),
                status);
        paymentRepository.save(paymentReport);
        System.out.println("Запись о выплате сохранена в MongoDB: " + paymentReport);
    }

    public static void main(String[] args) {
        SpringApplication.run(PayServiceApplication.class, args);
    }

}
