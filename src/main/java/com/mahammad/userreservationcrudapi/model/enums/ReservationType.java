package com.mahammad.userreservationcrudapi.model.enums;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Reservation type options")
public enum ReservationType {
    HOURLY,
    DAILY,
    WEEKLY,
    MONTHLY
}
