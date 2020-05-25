package com.frankmoley.boot.clr.roomclrapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;

@Component
public class RoomCleaningPrimer implements CommandLineRunner{
	
	@Value("${amqp.queue.name}")
	private String queueName;
	
	private static final Logger logger = LoggerFactory.getLogger(RoomCleaningPrimer.class);
	
	private final RabbitTemplate rabbitTemplate;
	private final ConfigurableApplicationContext context;
	private final ObjectMapper objectMapper;

    private RestTemplate restTemplate;
    
    @Autowired
    public RoomCleaningPrimer(RabbitTemplate rabbitTemplate, 
    		ConfigurableApplicationContext context, ObjectMapper objectMapper){
        super();
        this.restTemplate = new RestTemplate();
        this.rabbitTemplate = rabbitTemplate;
        this.context = context;
        this.objectMapper = objectMapper; 
    }
    @Override
    public void run(String... strings) throws Exception {
        String url = "http://localhost:8080/api/rooms";
        Room[] roomArray = this.restTemplate.getForObject(url, Room[].class);
        List<Room> rooms = Arrays.asList(roomArray);
//        rooms.forEach(System.out::println);
        rooms.forEach(room -> {
        	logger.info("Sending message");
        	try {
				String jsonString = objectMapper.writeValueAsString(room);
				rabbitTemplate.convertAndSend(queueName,jsonString);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				logger.error("Parsing exception",e);
			}
        });
        
        context.close();
    }
}
