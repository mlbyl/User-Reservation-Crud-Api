package com.mahammad.userreservationcrudapi.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateRequest {
    @NotBlank(message = "User name is required")
    private String name;
    @NotBlank(message = "User surname is required")
    private String surname;

    @Email
    @NotBlank(message = "User email is required")
    private String email;

    @NotNull(message = "User age is required")
    private int age;

    @Size(min = 8, max = 64, message = "User password must be between 8 and 64 characters long")
    private String password;
}
