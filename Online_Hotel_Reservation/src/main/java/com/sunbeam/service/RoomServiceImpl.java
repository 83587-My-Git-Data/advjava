package com.sunbeam.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.dao.ReservationDao;
import com.sunbeam.dao.RoomDao;
import com.sunbeam.entities.Reservation;
import com.sunbeam.entities.Room;

@Service
@Transactional
public class RoomServiceImpl implements RoomService {
	@Autowired 
	private RoomDao roomDao; 
	
	@Autowired
	private ReservationDao reservationDao;
	
	@Override
	public List<Room> getavailableRoomsOnSpecificDate(LocalDate checkInDate) {
		List<Reservation> reservationsOnDate = reservationDao.findavailablerooms(checkInDate);
		List<Room> allRooms = roomDao.findAll();
		System.out.println(reservationsOnDate);
		System.out.println(allRooms);
		for (Reservation reservation : reservationsOnDate) {
			if(allRooms.contains(reservation.getRoom())) {
				allRooms.remove(reservation.getRoom());
			}
		}
		return allRooms;
	}
}
