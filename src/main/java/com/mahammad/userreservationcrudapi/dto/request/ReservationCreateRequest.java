package com.mahammad.userreservationcrudapi.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mahammad.userreservationcrudapi.model.enums.ReservationStatus;
import com.mahammad.userreservationcrudapi.model.enums.ReservationType;
import io.swagger.v3.oas.annotations.media.Schema;
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
    private LocalDateTime startTime;

    @NotNull(message = "end time required")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime endTime;

    @NotBlank(message = "Reservation type cannot be null")
    @Schema(allowableValues = {"HOURLY", "DAILY", "WEEKLY", "MONTHLY"})
    private ReservationType reservationType;

    @NotBlank(message = "Reservation status cannot be null")
    @Schema(allowableValues = {"PENDING", "CONFIRMED", "CANCELLED", "COMPLETED"})
    private ReservationStatus reservationStatus;


}
