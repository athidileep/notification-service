package com.library.notification_service.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Service
public class NotificationService {

    private final RabbitTemplate rabbitTemplate;

    public NotificationService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    
 // This method listens for messages from the userQueue
    @RabbitListener(queues = "userQueue")
    public void listenToUserQueue(String message) {
        // Process the message (e.g., send a notification about a new user)
        System.out.println("Notification - User Queue: " + message);
        // You can perform other actions like sending an email, logging the event, etc.
    }

    // This method listens for messages from the bookQueue
    @RabbitListener(queues = "bookQueue")
    public void listenToBookQueue(String message) {
        // Process the message (e.g., send a notification about a book being borrowed or returned)
        System.out.println("Notification - Book Queue: " + message);
        // Perform actions here, like sending an email or SMS
    }

    // This method listens for messages from the borrowingQueue
    @RabbitListener(queues = "borrowingQueue")
    public void listenToBorrowingQueue(String message) {
        // Process the message (e.g., send a notification about book borrowing/return)
        System.out.println("Notification - Borrowing Queue: " + message);
        // Perform actions here, like sending an email or SMS
    }

    // Send message to User Queue
    public void sendToUserQueue(String userName) {
        String message = "A new user has been added: " + userName;
        rabbitTemplate.convertAndSend("userQueue", message);
    }

    // Send message to Book Queue when a book is borrowed or returned
    public void sendToBookQueue(String bookName, String action) {
        String message = action + " the book: " + bookName;
        rabbitTemplate.convertAndSend("bookQueue", message);
    }

    // Send message to Borrowing Queue when a book is borrowed or returned
    public void sendToBorrowingQueue(String bookName, String action, String userName) {
        String message = userName + " has " + action + " the book: " + bookName;
        rabbitTemplate.convertAndSend("borrowingQueue", message);
    }
}
