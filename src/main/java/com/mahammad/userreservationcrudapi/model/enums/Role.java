package com.mahammad.userreservationcrudapi.model.enums;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "User role options")
public enum Role {
    ROLE_USER,
    ROLE_ADMIN
}
