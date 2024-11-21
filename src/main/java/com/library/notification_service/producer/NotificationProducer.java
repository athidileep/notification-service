package com.library.notification_service.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationProducer {

    private final RabbitTemplate rabbitTemplate;

    public NotificationProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    // Send message to User Queue
    public void sendToUserQueue(String userName) {
        String message = "A new user has been added: " + userName;
        rabbitTemplate.convertAndSend("libraryExchange","userRoutingKey", message);
    }

    // Send message to Book Queue when a book is borrowed
    public void sendToBookQueue(String bookName, String action) {
        String message = action + " the book: " + bookName;
        rabbitTemplate.convertAndSend("libraryExchange","bookRoutingKey", message);
    }

    // Send message to Borrowing Queue when a book is borrowed or returned
    public void sendToBorrowingQueue(String bookName, String action, String userName) {
        String message = userName + " has " + action + " the book: " + bookName;
        rabbitTemplate.convertAndSend("libraryExchange","borrowingRoutingKey", message);
    }
}
