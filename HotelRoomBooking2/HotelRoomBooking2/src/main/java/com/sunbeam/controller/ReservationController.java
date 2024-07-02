package com.sunbeam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dto.GetAvaliableroom;
import com.sunbeam.dto.ReservationReq;
import com.sunbeam.entities.Room;
import com.sunbeam.service.ReservationService;
import com.sunbeam.service.RoomService;

@RestController
@RequestMapping("/Reservation")
public class ReservationController {

	@Autowired
	private ReservationService reservationService;
	
	
	@Autowired
	private RoomService roomService;
	
	public ReservationController()
	{
		System.out.println("in ctor " + getClass());
	}
	
//	@GetMapping("/list")
//	 public List<Room> getAvailableRoom(@RequestBody GetAvaliableroom reqDTO) {
//	        System.out.println("in get available room controller " + reqDTO);
//	        return  reservationService.getAvaliableRoom(reqDTO);
//     return new ResponseEntity<>(availableRooms, HttpStatus.OK);
//	    }

	
	@PostMapping
	public ResponseEntity<?> saveReservation(@RequestBody ReservationReq dto)  
	{
		System.out.println("in post avaliable room controller");
		try {
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(reservationService.saveReservation(dto));
			} catch (RuntimeException e) {
				System.out.println(e);
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body(e.getMessage());			
			}
	}
	
	@GetMapping("/availableRooms/{date}")
	public ResponseEntity<?> getAvaliableRooms(@PathVariable String date)
	{
		try {
			return ResponseEntity.ok(roomService.getAvailableRooms(date));
		} catch (RuntimeException e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
}
