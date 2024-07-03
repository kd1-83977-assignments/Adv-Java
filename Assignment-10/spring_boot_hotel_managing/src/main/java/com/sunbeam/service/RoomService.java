package com.sunbeam.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.query.Param;

import com.sunbeam.entities.Room;


public interface RoomService {
	
	
	public List<Room> findAvailRooms(@Param("checkIn") LocalDate checkIn);

}
