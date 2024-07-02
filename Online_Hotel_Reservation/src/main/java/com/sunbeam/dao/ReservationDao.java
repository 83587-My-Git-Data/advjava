package com.sunbeam.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.format.annotation.DateTimeFormat;

import com.sunbeam.entities.Reservation;
import com.sunbeam.entities.Room;


public interface ReservationDao extends JpaRepository<Reservation, Long> {
	@Query("select r from Reservation r")
	List<Reservation> findavailablerooms(LocalDate checkInDate);
}
