package com.sunbeam.service;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.dao.ReservationDao;
import com.sunbeam.dao.RoomDao;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.RoomReqDTO;
import com.sunbeam.entities.Reservation;
import com.sunbeam.entities.Room;

@Service
@Transactional
public class RoomServiceImpl implements RoomService{

	@Autowired
	private RoomDao roomDao;
	
	@Autowired
	private ReservationDao reserveDao;
	
	@Override
	public List<Room> getAllRooms() {
		// TODO Auto-generated method stub
		return roomDao.findAll();
	}

	@Override
	public List<Room> getAvailableRooms(String checkInDate) {
		// TODO Auto-generated method stub
		LocalDate date=LocalDate.parse(checkInDate);
		List<Reservation> reserveList= reserveDao.getReservedRoomDetails(date);
		List<Room> rooms=roomDao.findAll();
		reserveList.forEach(s->System.out.println(s));
		
		for (Room  room : rooms) {
			System.out.println(room);
		}
		
		for (Reservation r : reserveList) {
		
			for (Room room : rooms)
			{
				if(r.getRoom().getId()==room.getId())
				{
				System.out.println(r.getRoom().getId()==room.getId());
				rooms.remove(room);
				System.out.println(rooms+"inside foreach");
			
				}
				break;
			}
	
		}
		for(Room room:rooms)
		{
			System.out.println(room);
		}
		
		System.out.println(rooms.isEmpty());
		System.out.println(rooms+"outside foreach");
		return rooms;
	}

}
