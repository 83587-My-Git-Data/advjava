package com.sunbeam.service;



import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.BookingReqDTO;

public interface ReservationService {
	ApiResponse bookARoom(BookingReqDTO dto, Long guestId);
	ApiResponse cancelReservation(Long reservationId);
}
