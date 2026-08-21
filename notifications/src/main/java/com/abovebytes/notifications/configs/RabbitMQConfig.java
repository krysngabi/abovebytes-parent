package com.abovebytes.notifications.configs;

import com.abovebytes.notifications.constants.RabbitConstants;
import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.JacksonJsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Declares the RabbitMQ topology used to publish emergency call broadcast events
 * from the Central service onto the shared {@code emergency.exchange}.
 * <p>
 * Central owns publishing only — the queue/binding are declared here too (idempotently)
 * so the exchange always exists even if Notification service hasn't started yet,
 * but Notification service remains the actual consumer/owner of message processing.
 */
@Configuration
public class RabbitMQConfig {

    /**
     * Topic exchange all emergency-related events are published onto.
     * Durable so it survives broker restarts.
     */
    @Bean
    public TopicExchange emergencyExchange() {
        return ExchangeBuilder.topicExchange(RabbitConstants.EMERGENCY_EXCHANGE)
                .durable(true)
                .build();
    }

    /**
     * Dead-letter exchange — messages that exhaust retries/are rejected land here
     * instead of vanishing, so failures stay observable and reprocessable.
     */
    @Bean
    public DirectExchange emergencyDeadLetterExchange() {
        return ExchangeBuilder.directExchange(RabbitConstants.EMERGENCY_CALL_DLX)
                .durable(true)
                .build();
    }

    @Bean
    public Queue emergencyCallDeadLetterQueue() {
        return QueueBuilder.durable(RabbitConstants.EMERGENCY_CALL_DLQ).build();
    }

    @Bean
    public Binding emergencyCallDeadLetterBinding() {
        return BindingBuilder.bind(emergencyCallDeadLetterQueue())
                .to(emergencyDeadLetterExchange())
                .with(RabbitConstants.EMERGENCY_CALL_ROUTING_KEY);
    }

    /**
     * The primary queue holding pending emergency call broadcasts.
     * Durable + dead-lettered: a message that repeatedly fails processing
     * is routed to {@link #emergencyCallDeadLetterQueue()} instead of being lost.
     */
    @Bean
    public Queue emergencyCallQueue() {
        return QueueBuilder.durable(RabbitConstants.EMERGENCY_CALL_QUEUE)
                .withArgument("x-dead-letter-exchange", RabbitConstants.EMERGENCY_CALL_DLX)
                .withArgument("x-dead-letter-routing-key", RabbitConstants.EMERGENCY_CALL_ROUTING_KEY)
                .build();
    }

    @Bean
    public Binding emergencyCallBinding() {
        return BindingBuilder.bind(emergencyCallQueue())
                .to(emergencyExchange())
                .with(RabbitConstants.EMERGENCY_CALL_ROUTING_KEY);
    }

    @Bean
    public Queue emergencyCallAssignedQueue() {
        return QueueBuilder
                .durable(RabbitConstants.EMERGENCY_CALL_ASSIGNED_QUEUE)
                .build();
    }

    @Bean
    public Binding emergencyCallAssignedBinding() {
        return BindingBuilder
                .bind(emergencyCallAssignedQueue())
                .to(emergencyExchange())
                .with(RabbitConstants.EMERGENCY_CALL_ASSIGNED_ROUTING_KEY);
    }

    /**
     * Serializes/deserializes message bodies as JSON instead of Java's default
     * Serializable format, so payloads are readable across services and languages.
     */
    @Bean
    public MessageConverter jsonMessageConverter() {
        return new JacksonJsonMessageConverter();
    }
}