package com.parking.parkingslotservice.service;

import com.parking.parkingslotservice.model.ParkingSlot;
import com.parking.parkingslotservice.repository.ParkingSlotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParkingSlotService {

    private final ParkingSlotRepository parkingSlotRepository;

    public List<ParkingSlot> getAllSlots() {
        return parkingSlotRepository.findAll();
    }

    public ParkingSlot addSlot(String slotNumber) {
        ParkingSlot slot = ParkingSlot.builder()
                .slotNumber(slotNumber)
                .isAvailable(true)
                .build();
        return parkingSlotRepository.save(slot);
    }

    public ParkingSlot updateAvailability(Long id, boolean availability) {
        ParkingSlot slot = parkingSlotRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Slot not found"));
        slot.setAvailable(availability);
        return parkingSlotRepository.save(slot);
    }
}
