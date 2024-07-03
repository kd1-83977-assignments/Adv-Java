package com.sunbeam.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name="reservation")
@NoArgsConstructor
@Setter
@Getter
@ToString(callSuper=true)
public class Reservation extends BaseEntiy {
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="guest_id", nullable=false)
	private Guest guest;
	
	@Column(name="check_in")
	private LocalDate checkIn;
	
	@Column(name="check_out")
	private LocalDate checkout;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="room_id", nullable=false)
	private Room room;
	
	@Column(name="total_price")
	private double totalPrice;

	public Reservation(LocalDate checkIn, LocalDate checkout) {
		super();
		this.checkIn = checkIn;
		this.checkout = checkout;
		
	}
	
	
	
	
	
	
	
}
