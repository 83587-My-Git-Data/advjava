package com.sunbeam.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BookingReqDTO extends BaseEntityDTO{
	private int roomId;
	private LocalDate checkInDate;
	private LocalDate checkOutDate;
}
