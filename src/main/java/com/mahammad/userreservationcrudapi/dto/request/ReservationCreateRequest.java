package com.mahammad.userreservationcrudapi.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mahammad.userreservationcrudapi.model.enums.ReservationStatus;
import com.mahammad.userreservationcrudapi.model.enums.ReservationType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationCreateRequest {
    @NotNull(message = "start time required")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @FutureOrPresent(message = "Reservation start time must be in present or future time")
    private LocalDateTime startTime;

    @NotNull(message = "end time required")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @Future(message = "Reservation end time must be in future time")
    private LocalDateTime endTime;

    @NotNull(message = "Reservation type cannot be null")
    @Schema(allowableValues = {"HOURLY", "DAILY", "WEEKLY", "MONTHLY"})
    private ReservationType reservationType;

    @NotNull(message = "Reservation status cannot be null")
    @Schema(allowableValues = {"PENDING", "CONFIRMED", "CANCELLED", "COMPLETED"})
    private ReservationStatus reservationStatus;


}
