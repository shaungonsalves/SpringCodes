package com.frankmoley.boot.landon;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoomCleanerProcessor {
	private final ObjectMapper objectMapper;
	private static final Logger logger = LoggerFactory.getLogger(RoomCleanerProcessor.class);
	
	@Autowired
	public RoomCleanerProcessor(ObjectMapper objectMapper) {
		super();
		this.objectMapper = objectMapper;
	}
	
	public void receiveMessage(String roomJson) {
		logger.info("Message received");
		try {
			Room room = this.objectMapper.readValue(roomJson, Room.class);
			logger.info("Room ready for cleaning "+room.getNumber());
		} catch (IOException e) {
			// TODO: handle exception
			logger.error("Exception caught",e);
		}
	}
}
