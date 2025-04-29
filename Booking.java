package com.parking.bookingservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private Long vehicleId;

    private Long slotId;

    private LocalDateTime bookingTime;

    private LocalDateTime inTime;

    private LocalDateTime outTime;

    private String status; // BOOKED, IN_PROGRESS, COMPLETED
}
