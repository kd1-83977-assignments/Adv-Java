package com.sunbeam.service;

import java.time.LocalDate;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.dao.RoomDao;
import com.sunbeam.dto.RoomDto;
import com.sunbeam.entities.Room;

@Service
@Transactional
public class RoomServiceImpl implements RoomService {
	@Autowired
	private RoomDao roomDao;
	
	@Autowired
	ModelMapper mapper;
	

	@Override
	public List<Room> findAvailRooms(LocalDate checkIn) {
		
		List<Room> list = roomDao.findAvailableRooms(checkIn);
		
		return list;
	}

}
