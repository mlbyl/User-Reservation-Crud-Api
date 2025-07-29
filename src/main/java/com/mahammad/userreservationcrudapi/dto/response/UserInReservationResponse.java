package com.mahammad.userreservationcrudapi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInReservationResponse {
    private UUID id;
    private String name;
    private String surname;
    private int age;
    private String email;
}
