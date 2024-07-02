package com.sunbeam.controller;

import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.entities.Room;
import com.sunbeam.service.RoomService;

@RestController
@RequestMapping("/rooms")
public class RoomController {
	@Autowired
	private RoomService roomService;

	public RoomController() {
		System.out.println("In Room Controller " + getClass());
	}

	@GetMapping("/available/{checkInDate}")
	public List<Room> availableRoomsOnSpecificDate(@PathVariable String checkInDate) {
		return roomService.getavailableRoomsOnSpecificDate(LocalDate.parse(checkInDate));
	}
}
