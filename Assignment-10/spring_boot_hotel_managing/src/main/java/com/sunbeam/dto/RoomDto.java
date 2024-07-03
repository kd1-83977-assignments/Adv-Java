package com.sunbeam.dto;

import com.sunbeam.entities.BedType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString(callSuper=true)
public class RoomDto extends BaseDto {

	private String roomNumber;
		
	private BedType bedType;
	
	private double price;
	
	private boolean availability;

	
	
}
