package com.library.notification_service.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;

@Configuration
@EnableRabbit
public class RabbitMQConfig {

    // Declare the queue for User Service
    @Bean
    public Queue userQueue() {
        return new Queue("userQueue", true);  // Durable queue
    }

    // Declare the queue for Book Service
    @Bean
    public Queue bookQueue() {
        return new Queue("bookQueue", true);  // Durable queue
    }

    // Declare the queue for Borrowing Service
    @Bean
    public Queue borrowingQueue() {
        return new Queue("borrowingQueue", true);  // Durable queue
    }

    // Declare the exchange for routing
    @Bean
    public DirectExchange libraryExchange() {
        return new DirectExchange("libraryExchange");
    }

    // Binding between User Queue and Exchange with a routing key
    @Bean
    public Binding userBinding(Queue userQueue, DirectExchange libraryExchange) {
        return BindingBuilder.bind(userQueue).to(libraryExchange).with("userRoutingKey");
    }

    // Binding between Book Queue and Exchange with a routing key
    @Bean
    public Binding bookBinding(Queue bookQueue, DirectExchange libraryExchange) {
        return BindingBuilder.bind(bookQueue).to(libraryExchange).with("bookRoutingKey");
    }

    // Binding between Borrowing Queue and Exchange with a routing key
    @Bean
    public Binding borrowingBinding(Queue borrowingQueue, DirectExchange libraryExchange) {
        return BindingBuilder.bind(borrowingQueue).to(libraryExchange).with("borrowingRoutingKey");
    }
}
