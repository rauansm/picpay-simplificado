package com.picpay.core.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificacaoAMQPConfig {
    @Bean
    public Queue filaNotificaTransferencia(){
        return QueueBuilder
                .durable("notifica.email")
                .deadLetterExchange("transferencia.dlx")
                .build();
    }
    @Bean
    public RabbitAdmin criaRabbitAdmin (ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }
    @Bean
    public TopicExchange topicExchange(){
        return ExchangeBuilder
                .topicExchange("transferencia.ex")
                .build();
    }
    @Bean
    public TopicExchange deadLetterExchange(){
        return ExchangeBuilder
                .topicExchange("transferencia.dlx")
                .build();
    }
    @Bean
    public Queue filaDqlNotificaTransferencia(){
        return new Queue("notifica.email-dlq",true);
    }
    @Bean
    public Binding bindNotificaTransferencia() {
        return BindingBuilder.bind(filaNotificaTransferencia())
                .to(topicExchange())
                .with("notifica.email");
    }
    @Bean
    public Binding bindDlxNotificaTransferencia() {
        return BindingBuilder.bind(filaDqlNotificaTransferencia())
                .to(deadLetterExchange())
                .with("notifica.email");
    }
    @Bean
    public ApplicationListener<ApplicationReadyEvent> inicializaAdmin (RabbitAdmin rabbitAdmin){
        return event -> rabbitAdmin.initialize();
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter(ObjectMapper objectMapper) {
        return new Jackson2JsonMessageConverter(objectMapper);
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory, Jackson2JsonMessageConverter messageConverter) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter);
        return rabbitTemplate;
    }

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.findAndRegisterModules();
        objectMapper.disable(com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        return objectMapper;
    }


}

