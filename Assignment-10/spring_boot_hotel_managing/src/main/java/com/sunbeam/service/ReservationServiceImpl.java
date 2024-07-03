package com.sunbeam.service;

import java.time.temporal.ChronoUnit;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.custom_exceptions.ResourceNotFoundException;
import com.sunbeam.dao.GuestDao;
import com.sunbeam.dao.ReservationDao;
import com.sunbeam.dao.RoomDao;
import com.sunbeam.dto.ReservationDto;
import com.sunbeam.entities.Guest;
import com.sunbeam.entities.Reservation;
import com.sunbeam.entities.Room;

@Service
@Transactional
public class ReservationServiceImpl  implements ReservationService{
	@Autowired
	ReservationDao reservationDao;
	
	@Autowired
	RoomDao roomDao;
	
	@Autowired
	GuestDao guestDao;
	
	@Autowired
	ModelMapper mapper;
	
	@Override
	public ReservationDto bookHotelRoom(ReservationDto reservationRequestDto){
		
		Room room = roomDao.findById(reservationRequestDto.getRoomId())
                .orElseThrow(() -> new ResourceNotFoundException("Invalid room id !!!!"));

        Guest guest = guestDao.findById(reservationRequestDto.getGuestId())
                .orElseThrow(() -> new ResourceNotFoundException("Invalid guest name !!!!"));

        // Check for date conflicts
        List<Reservation> conflictingReservations = reservationDao.findConflictingReservations(
                reservationRequestDto.getRoomId(),
                reservationRequestDto.getCheckIn(),
                reservationRequestDto.getCheckout()
        );

        if (!conflictingReservations.isEmpty()) {
            throw new ResourceNotFoundException("Room not available for the selected dates");
        }

        long daysBetween = ChronoUnit.DAYS.between(reservationRequestDto.getCheckIn(), reservationRequestDto.getCheckout());
        double totalPrice = daysBetween * room.getPrice();

        Reservation reservation = new Reservation();
        reservation.setGuest(guest);
        reservation.setRoom(room);
        reservation.setCheckIn(reservationRequestDto.getCheckIn());
        reservation.setCheckout(reservationRequestDto.getCheckout());
        reservation.setTotalPrice(totalPrice);

        Reservation savedReservation = reservationDao.save(reservation);

        return mapper.map(savedReservation, ReservationDto.class);
    }
	

}
