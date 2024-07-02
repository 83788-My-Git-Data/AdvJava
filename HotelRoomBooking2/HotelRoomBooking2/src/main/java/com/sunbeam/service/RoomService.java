package com.sunbeam.service;

import java.util.List;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.RoomReqDTO;
import com.sunbeam.entities.Room;

public interface RoomService {

	List<Room> getAllRooms();
	List<Room> getAvailableRooms(String checkInDate);

}
