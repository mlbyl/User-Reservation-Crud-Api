package com.mahammad.userreservationcrudapi.dto.response;

import com.mahammad.userreservationcrudapi.model.enums.ReservationStatus;
import com.mahammad.userreservationcrudapi.model.enums.ReservationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationResponse {
    private UUID id;
    private ReservationType reservationType;
    private ReservationStatus reservationStatus;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private UserInReservationResponse user;

}
