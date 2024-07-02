package com.sunbeam.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dto.BookingReqDTO;
import com.sunbeam.service.ReservationService;


@RestController
@RequestMapping("/reservation")
public class ReservationController {
	@Autowired
	private ReservationService reservationService;

	@PostMapping("/{guestId}")
	public ResponseEntity<?> bookARoom(@RequestBody BookingReqDTO dto, @PathVariable Long guestId ) {
		return ResponseEntity.ok(reservationService.bookARoom(dto, guestId)); 
	}
	
	@DeleteMapping("/{reservationId}")
	public ResponseEntity<?> cancelAReservation(@PathVariable Long reservationId) {
		return ResponseEntity.ok(reservationService.cancelReservation(reservationId));
	}
}
