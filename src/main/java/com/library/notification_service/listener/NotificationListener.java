package com.library.notification_service.listener;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.stereotype.Service;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;

@Service
public class NotificationListener {


    @RabbitListener(queues = "userQueue")
    public void listenToUserQueue(String message) {
        // Process the message (e.g., send a notification about a new user)
        System.out.println("Notification - User Queue: " + message);
//     // Logic to send email when a new user is added
//        String subject = "New User Created: " + message;
//        String body = "A new user has been created: " + message;
//
//        // Email can be sent to the admin or the user themselves
//        String recipient = "athiradileep3@gmail.com"; // Admin email
//        emailService.sendEmail(recipient, subject, body);
    }

    // This method listens for messages from the bookQueue
    @RabbitListener(queues = "bookQueue")
    public void listenToBookQueue(String message) {
        // Process the message (e.g., send a notification about a book being borrowed or returned)
        System.out.println("Notification - Book Queue: " + message);
        // You can send an email or perform any other action here
     // Logic to send email when a book is borrowed or returned
//        String subject = "Book Borrowed: " + message;
//        String body = "A book has been borrowed: " + message;
//
//        String recipient = "athiradileep3@gmail.com"; // Admin email
//        emailService.sendEmail(recipient, subject, body);
    }

    // This method listens for messages from the borrowingQueue
    @RabbitListener(queues = "borrowingQueue")
    public void listenToBorrowingQueue(String message) {
        // Process the message (e.g., send a notification about book borrowing/return)
        System.out.println("Notification - Borrowing Queue: " + message);
     // Logic to send email when a book is returned
//        String subject = "Book Returned: " + message;
//        String body = "A book has been returned: " + message;
//
//        String recipient = "admin-email@example.com"; // Admin email
//        emailService.sendEmail(recipient, subject, body);
    }
}
