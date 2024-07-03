package com.sunbeam.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sunbeam.entities.Room;

public interface RoomDao extends JpaRepository<Room, Long> {
	
//	select * from rooms where availability = true AND id NOT IN (select room_id from reservation where check_in ='2024-07-28');
	
//	@Query("select r from Room r where r not in (select res.room.id from Reservation res where res.checkIn =:checkIn)")
	@Query("SELECT r FROM Room r WHERE r.id NOT IN " +
	           "(SELECT res.room.id FROM Reservation res WHERE :checkIn BETWEEN res.checkIn AND res.checkout)")
	    List<Room> findAvailableRooms(@Param("checkIn") LocalDate checkIn);
	
	

}
