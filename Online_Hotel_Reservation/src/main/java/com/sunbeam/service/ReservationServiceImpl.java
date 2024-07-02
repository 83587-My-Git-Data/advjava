package com.sunbeam.service;



import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.custom_exceptions.ResourceNotFoundException;
import com.sunbeam.dao.GuestDao;
import com.sunbeam.dao.ReservationDao;
import com.sunbeam.dao.RoomDao;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.BookingReqDTO;
import com.sunbeam.entities.Guest;
import com.sunbeam.entities.Reservation;
import com.sunbeam.entities.Room;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {
	@Autowired
	private ReservationDao reservationDao;

	@Autowired
	private GuestDao guestDao;

	@Autowired
	private RoomDao roomDao;

	@Autowired
	private ModelMapper mapper;

	@Override
	public ApiResponse bookARoom(BookingReqDTO dto, Long guestId) {
		Guest guest = guestDao.findById(guestId).orElseThrow(() -> new ResourceNotFoundException("Invalid User!"));
		Room room = roomDao.findByRoomNo(dto.getRoomId()).orElseThrow(() -> new ResourceNotFoundException("Invalid Room Id!"));
		Reservation resv = mapper.map(dto, Reservation.class);
		resv.setGuest(guest);
		resv.setRoom(room);
		resv.setTotPrice((dto.getCheckOutDate().compareTo(dto.getCheckInDate())) * room.getType().value());
		reservationDao.save(resv);
		return new ApiResponse("Booking successfull!!");
	}

	@Override
	public ApiResponse cancelReservation(Long reservationId) {
		Reservation reservation = reservationDao.findById(reservationId).orElseThrow(() -> new ResourceNotFoundException("Invalid Reservation"));
		reservationDao.delete(reservation);
		return new ApiResponse("Reservation cancelled");
	}
}
