package com.frankmoley.boot.clr.roomclrapp;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RoomClrAppApplication {
	
	@Value("${amqp.queue.name}")
	private String queueName;
	
	@Value("${amqp.exchange.name}")
	private String exchangeName;
	
	@Value("${amqp.routingKey.name}")
	private String routingKeyName;
	
	@Bean
	public Queue queue() {
		return new Queue(queueName,false);
	}
	
	@Bean
	public TopicExchange topicExchange() {
		return new TopicExchange(exchangeName);
	}
	
	@Bean
	public Binding binding(Queue q, TopicExchange te) {
		return BindingBuilder.bind(q).to(te).with(routingKeyName);
	}

	public static void main(String[] args) {
		SpringApplication.run(RoomClrAppApplication.class, args);
	}
}
