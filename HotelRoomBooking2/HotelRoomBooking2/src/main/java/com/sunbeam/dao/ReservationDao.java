package com.sunbeam.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.sunbeam.entities.Reservation;
import com.sunbeam.entities.Room;




public interface ReservationDao extends JpaRepository<Reservation, Long>{

//	 @Query("SELECT r FROM Room r WHERE r.id IN (" +
//	           "SELECT res.room.id FROM Reservation res WHERE :checkIn < res.checkout AND :checkOut > res.checkin)")
//	    List<Room> findReservedRooms( LocalDate checkIn,  LocalDate checkOut);
//	return  avaliableRooms;
	
	@Query("select r from Reservation r where:inDate between r.checkin and r.checkout")
	List<Reservation> getReservedRoomDetails(LocalDate inDate);
}
