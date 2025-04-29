package com.parking.parkingslotservice.repository;

import com.parking.parkingslotservice.model.ParkingSlot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingSlotRepository extends JpaRepository<ParkingSlot, Long> {
}
