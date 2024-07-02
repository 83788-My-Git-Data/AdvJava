package com.sunbeam.service;

import java.time.LocalDate;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sunbeam.custom_exception.ResourceNotFoundException;
import com.sunbeam.dao.GuestDao;
import com.sunbeam.dao.ReservationDao;
import com.sunbeam.dao.RoomDao;
import com.sunbeam.dto.GetAvaliableroom;
import com.sunbeam.dto.ReservationReq;
import com.sunbeam.dto.ReservationResp;
import com.sunbeam.entities.Guest;
import com.sunbeam.entities.Reservation;
import com.sunbeam.entities.Room;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService{

	@Autowired
	private RoomDao roomDao;
	
	@Autowired
	private GuestDao guestDao;
	
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private ReservationDao reservationdao;
	
	@Override
	public ReservationResp saveReservation(ReservationReq requestDTO) {
		// TODO Auto-generated method stub
//		Guest guest= guestDao.findByFirstNameAndLastName(requestDTO.getFirstName(), requestDTO.getLastName())
//				.orElseThrow(()->new ResourceNotFoundException("Invalid guest name!!!"));
		Guest guest= guestDao.findById(requestDTO.getGuestid())
				.orElseThrow(()->new ResourceNotFoundException("Invalid guest name!!!"));
		
		Room room= roomDao.findById(requestDTO.getRoomid())
				.orElseThrow(()->new ResourceNotFoundException("Invalid room id!!!"));
		
		Reservation reservaltion= mapper.map(requestDTO,Reservation.class);
		reservaltion.setGuest(guest);
		reservaltion.setRoom(room);
		reservaltion.setCheckin(requestDTO.getCheck_in());
		reservaltion.setCheckout(requestDTO.getCheck_out());
		
		Reservation periststentReservaltion=reservationdao.save(reservaltion);
		return ReservationResp("New reservation added with ID=" + periststentReservaltion.getRoom());
	}

	@Override
	public List<Room> getAvaliableRoom(GetAvaliableroom getDTO) {
		// TODO Auto-generated method stub
		System.out.println("Inside serviceimpl");
		List<Room> avaliableRooms= roomDao.findAll();
		List<Reservation> reservedRooms= reservationdao.findAll();
		 LocalDate checkIn = getDTO.getCheck_in();
	     LocalDate checkOut = getDTO.getCheck_out();
		
//	        reservedRooms.forEach(reservation -> {
//	            if (!(checkOut.isBefore(reservation.getCheckin()) || checkIn.isAfter(reservation.getCheckout()))) {
//	            	avaliableRooms.removeIf(room -> room.getId().equals(reservation.getRoom().getId()));
//	            }
//	        });
	        
//	        List<ReservationResp> availableRoomResponses = avaliableRooms.stream()
//	                .map(room -> new ReservationResp(room.getId(), room.getPrice())) // Adapt this line to match your ReservationResp constructor
//	                .collect(Collectors.toList());
	        
	        System.out.println(avaliableRooms);
	        return avaliableRooms;
	        
//	        List<ReservationResp> responseList = avaliableRooms.stream()
//	                .map(room -> new ReservationResp(room.getId(), room.getPrice()))
//	                .collect(Collectors.toList());
//	        return avaliableRooms;

	        
//	        List<ReservationResp> responseList = avaliableRooms.stream()
//	                .map(room -> {
//	                    ReservationResp resp = new ReservationResp();
//	                    resp.setId(room.getId());
////	                    resp.set(room.getRoomnumber());
////	                    resp.setRoomType(room.getType());
//	                    resp.setPrice(room.getPrice());
////	                    resp.setAvailability(room.isAvailability());
//	                    return resp;
//	                })
//	                .collect(Collectors.toList());
	        
//	        return responseList;
	       
		
	}

//	private Room[] Query(String string) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	private ReservationResp ReservationResp(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
