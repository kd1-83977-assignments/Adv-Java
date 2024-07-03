package com.sunbeam.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.entities.Room;
import com.sunbeam.service.RoomService;

@RestController
@RequestMapping("/rooms")
public class RoomController {
	@Autowired
	RoomService roomService;
	
	
	@GetMapping("/available/{checkIn}")
    public ResponseEntity<List<Room>> findAvailRooms(@PathVariable("checkIn") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkIn) {
       
		System.out.println("in controller"+checkIn);
		List<Room> availableRooms = roomService.findAvailRooms(checkIn);
        return ResponseEntity.ok(availableRooms);
	}
	
	
	
}
