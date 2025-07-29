package com.mahammad.userreservationcrudapi.service.abstracts;

import com.mahammad.userreservationcrudapi.dto.request.UserCreateRequest;
import com.mahammad.userreservationcrudapi.dto.request.UserUpdateRequest;
import com.mahammad.userreservationcrudapi.dto.response.UserResponse;

import java.io.LineNumberInputStream;
import java.util.List;
import java.util.UUID;

public interface UserService {
    List<UserResponse> findAll();

    UserResponse findById(UUID id);

    UserResponse save(UserCreateRequest request);

    UserResponse update(UUID id,UserUpdateRequest request);

    void delete(UUID id);
}
