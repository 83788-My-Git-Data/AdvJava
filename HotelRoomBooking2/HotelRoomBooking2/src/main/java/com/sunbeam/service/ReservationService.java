package com.sunbeam.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.query.Param;

import com.sunbeam.dto.GetAvaliableroom;
import com.sunbeam.dto.ReservationReq;
import com.sunbeam.dto.ReservationResp;
import com.sunbeam.entities.Room;



public interface ReservationService {
	ReservationResp saveReservation(ReservationReq requestDTO);
	List<Room> getAvaliableRoom(GetAvaliableroom getDTO);
//    List<Room> findReservedRooms(@Param("checkIn") LocalDate checkIn, @Param("checkOut") LocalDate checkOut);

}
