package com.sunbeam.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "reservations")
@Getter
@Setter
@ToString(callSuper = true)
public class Reservation extends BaseEntity {
	@Column(name = "check_in_date")
	private LocalDate checkInDate;
	@Column(name = "check_out_date")
	private LocalDate checkOutDate;
	private double totPrice;
	@ManyToOne // Guest 1<--* Reservation, 1 guest can do many reservations
	@JoinColumn(name = "guest_id", nullable = false)
	private Guest guest;
	@ManyToOne // Room 1<--* Reservation, 1 room can have many reservations
	@JoinColumn(name = "room_id", nullable = false)
	private Room room;
}
