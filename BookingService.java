package com.parking.bookingservice.service;

import com.parking.bookingservice.model.Booking;
import com.parking.bookingservice.model.Vehicle;
import com.parking.bookingservice.repository.BookingRepository;
import com.parking.bookingservice.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final VehicleRepository vehicleRepository;

    public Booking createBooking(Long userId, Long slotId, String vehicleNumber, String vehicleType) {
        // Save vehicle first
        Vehicle vehicle = Vehicle.builder()
                .userId(userId)
                .vehicleNumber(vehicleNumber)
                .vehicleType(vehicleType)
                .build();

        Vehicle savedVehicle = vehicleRepository.save(vehicle);

        // Save booking
        Booking booking = Booking.builder()
                .userId(userId)
                .vehicleId(savedVehicle.getId())
                .slotId(slotId)
                .bookingTime(LocalDateTime.now())
                .status("BOOKED")
                .build();

        return bookingRepository.save(booking);
    }

    public Optional<Booking> markIn(Long bookingId) {
        return bookingRepository.findById(bookingId).map(booking -> {
            booking.setInTime(LocalDateTime.now());
            booking.setStatus("IN_PROGRESS");
            return bookingRepository.save(booking);
        });
    }

    public Optional<Booking> markOut(Long bookingId) {
        return bookingRepository.findById(bookingId).map(booking -> {
            booking.setOutTime(LocalDateTime.now());
            booking.setStatus("COMPLETED");
            return bookingRepository.save(booking);
        });
    }
}
