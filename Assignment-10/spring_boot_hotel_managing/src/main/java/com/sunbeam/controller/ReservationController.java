package com.sunbeam.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dto.ReservationDto;
import com.sunbeam.service.ReservationServiceImpl;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
	
	@Autowired
	private ReservationServiceImpl revService;
	
	

	@PostMapping
	public ResponseEntity<?> bookRoom(@RequestBody @Valid ReservationDto revDto ){
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(revService.bookHotelRoom(revDto));
		
	}
}
