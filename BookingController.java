package com.parking.bookingservice.controller;

import com.parking.bookingservice.model.Booking;
import com.parking.bookingservice.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/booking")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping("/create")
    public Booking createBooking(@RequestParam Long userId,
                                  @RequestParam Long slotId,
                                  @RequestParam String vehicleNumber,
                                  @RequestParam String vehicleType) {
        return bookingService.createBooking(userId, slotId, vehicleNumber, vehicleType);
    }

    @PostMapping("/{bookingId}/in")
    public Optional<Booking> markIn(@PathVariable Long bookingId) {
        return bookingService.markIn(bookingId);
    }

    @PostMapping("/{bookingId}/out")
    public Optional<Booking> markOut(@PathVariable Long bookingId) {
        return bookingService.markOut(bookingId);
    }
}
