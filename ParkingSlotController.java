package com.parking.parkingslotservice.controller;

import com.parking.parkingslotservice.model.ParkingSlot;
import com.parking.parkingslotservice.service.ParkingSlotService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/slot")
@RequiredArgsConstructor
public class ParkingSlotController {

    private final ParkingSlotService parkingSlotService;

    @GetMapping
    public List<ParkingSlot> getAllSlots() {
        return parkingSlotService.getAllSlots();
    }

    @PostMapping("/add")
    public ParkingSlot addSlot(@RequestParam String slotNumber) {
        return parkingSlotService.addSlot(slotNumber);
    }

    @PutMapping("/{id}/availability")
    public ParkingSlot updateSlotAvailability(@PathVariable Long id, @RequestParam boolean available) {
        return parkingSlotService.updateAvailability(id, available);
    }
}
