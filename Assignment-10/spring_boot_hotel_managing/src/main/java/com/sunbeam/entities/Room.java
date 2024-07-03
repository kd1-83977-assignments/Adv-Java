package com.sunbeam.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="rooms")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper=true)
public class Room extends BaseEntiy {
	
	@Column(name="room_number", length =20)
	private String roomNumber;
	
	@Enumerated(EnumType.STRING)
	@Column(name="bed_type")
	private BedType bedType;
	
	private double price;
	
	private boolean availability;

	public Room(String roomNumber, BedType bedType, double price, boolean availability) {
		super();
		this.roomNumber = roomNumber;
		this.bedType = bedType;
		this.price = price;
		this.availability = availability;
	}

	
	
}
