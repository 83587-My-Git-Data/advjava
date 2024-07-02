package com.sunbeam.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.Room;

public interface RoomDao extends JpaRepository<Room, Long> {
	Optional<Room> findByRoomNo(int roomId);
}
