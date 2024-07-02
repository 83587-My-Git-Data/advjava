package com.sunbeam.service;

import java.time.LocalDate;
import java.util.List;

import com.sunbeam.entities.Room;

public interface RoomService {
	List<Room> getavailableRoomsOnSpecificDate(LocalDate checkInDate);
}
