package com.frankmoley.boot.landon.roomwebapp;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomServices {
	/*
	 * private static List<Room> rooms = new ArrayList<>();
	 * 
	 * static{ for(int i=0;i<10;i++){ rooms.add(new Room(i, "Room " + i, "R"+i,
	 * "Q")); } }
	 */
	private RoomRepository roomRepository;
	
	

    public RoomServices(RoomRepository roomRepository) {
		super();
		this.roomRepository = roomRepository;
	}



	public List<Room> getAllRooms(){
		List<Room> rooms = new ArrayList<>();
		this.roomRepository.findAll().forEach(rooms::add);
        return rooms;
    }
}
