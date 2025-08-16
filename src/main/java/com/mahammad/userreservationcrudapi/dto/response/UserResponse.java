package com.mahammad.userreservationcrudapi.dto.response;


import com.mahammad.userreservationcrudapi.model.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private UUID id;
    private String name;
    private String surname;
    private int age;
    private String email;
    private Role role;
    private List<ReservationResponse> reservations;

}
