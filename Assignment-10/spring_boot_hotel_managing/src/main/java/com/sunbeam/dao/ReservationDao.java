package com.sunbeam.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sunbeam.entities.Reservation;


public interface ReservationDao extends JpaRepository <Reservation, Long> {
	 @Query("SELECT r FROM Reservation r WHERE r.room.id = :roomId AND (" +
	           "(r.checkIn <= :checkout AND r.checkout >= :checkIn))")
	    List<Reservation> findConflictingReservations(@Param("roomId") Long roomId,
	                                                  @Param("checkIn") LocalDate checkIn,
	                                                  @Param("checkout") LocalDate checkOut);

}
