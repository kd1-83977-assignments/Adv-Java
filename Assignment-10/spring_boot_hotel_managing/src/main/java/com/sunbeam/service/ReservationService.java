package com.sunbeam.service;

import org.springframework.http.ResponseEntity;

import com.sunbeam.dto.ReservationDto;

public interface ReservationService {
	public ReservationDto bookHotelRoom(ReservationDto revDto);

}
