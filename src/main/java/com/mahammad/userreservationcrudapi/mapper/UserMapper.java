package com.mahammad.userreservationcrudapi.mapper;

import com.mahammad.userreservationcrudapi.dto.request.UserCreateRequest;
import com.mahammad.userreservationcrudapi.dto.request.UserUpdateRequest;
import com.mahammad.userreservationcrudapi.dto.response.UserInReservationResponse;
import com.mahammad.userreservationcrudapi.dto.response.UserResponse;
import com.mahammad.userreservationcrudapi.model.User;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {
    public static UserResponse toResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getSurname(),
                user.getAge(),
                user.getEmail(),
                user.getRole(),
                ReservationMapper.toResponse(user.getReservations())

        );
    }

    public static List<UserResponse> toResponse(List<User> users) {
        if (users == null) {
            return Collections.emptyList();
        }
        return users.stream().map(user -> {
            return UserMapper.toResponse(user);
        }).collect(Collectors.toList());
    }

    public static UserInReservationResponse toUserInReservationResponse(User user) {
        return new UserInReservationResponse(
                user.getId(),
                user.getName(),
                user.getSurname(),
                user.getAge(),
                user.getEmail(),
                user.getRole()
        );
    }

    public static User toEntity(UserCreateRequest request) {
        return User.builder()
                .age(request.getAge())
                .email(request.getEmail())
                .name(request.getName())
                .surname(request.getSurname())
                .password(request.getPassword())
                .role(request.getRole())
                .build();
    }

    public static User updateEntity(UserUpdateRequest request, User user) {
        user.setAge(request.getAge());
        user.setName(request.getName());
        user.setSurname(request.getSurname());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(request.getRole());

        return user;
    }
}
