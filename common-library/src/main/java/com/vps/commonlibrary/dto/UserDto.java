// common-library main class placeholder
package com.parking.system.common.dto;

import lombok.Data;

//Example Files inside common-library:
//DTOs: UserDTO, ParkingSlotDTO, BookingDTO, PaymentDTO
//
//Enums: UserRole, PaymentStatus
//
//Constants: AppConstants
//
//Exception Classes: CustomException
// need to be created

@Data
public class UserDTO {
    private String username;
    private String password;
    private String role;
}
