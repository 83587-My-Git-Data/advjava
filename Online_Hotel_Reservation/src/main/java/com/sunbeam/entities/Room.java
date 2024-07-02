package com.sunbeam.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "rooms")
@Getter
@Setter
@ToString
public class Room extends BaseEntity {
	@Column(name = "room_no")
	private int roomNo;
	@Enumerated(EnumType.STRING)
	private Type type;
	private double price;
}
