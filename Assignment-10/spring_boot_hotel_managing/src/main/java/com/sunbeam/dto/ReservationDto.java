package com.sunbeam.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.sunbeam.entities.Guest;
import com.sunbeam.entities.Room;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReservationDto extends BaseDto{
	
	private Long guestId;
	
	private LocalDate checkIn;
	
	private LocalDate checkout;
	
	private Long roomId;
	
	@JsonProperty(access=Access.READ_ONLY)
	private double price;


}
