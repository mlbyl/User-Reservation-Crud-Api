package com.mahammad.userreservationcrudapi.service.concretes;

import com.mahammad.userreservationcrudapi.dto.request.UserCreateRequest;
import com.mahammad.userreservationcrudapi.dto.request.UserUpdateRequest;
import com.mahammad.userreservationcrudapi.dto.response.UserResponse;
import com.mahammad.userreservationcrudapi.exception.BusinessException;
import com.mahammad.userreservationcrudapi.exception.NotFoundException;
import com.mahammad.userreservationcrudapi.mapper.UserMapper;
import com.mahammad.userreservationcrudapi.model.User;
import com.mahammad.userreservationcrudapi.repository.UserRepository;
import com.mahammad.userreservationcrudapi.service.abstracts.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public List<UserResponse> findAll() {
        List<User> users = userRepository.findAll();
        return UserMapper.toResponse(users);
    }

    @Override
    public UserResponse findById(UUID id) {
        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found"));
        return UserMapper.toResponse(user);

    }

    @Override
    public UserResponse save(UserCreateRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new BusinessException("User Email already exists");
        }
        User user = UserMapper.toEntity(request);
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        User savedUser = userRepository.save(user);
        return UserMapper.toResponse(savedUser);
    }

    @Override
    public UserResponse update(UUID id, UserUpdateRequest request) {
        User existUser = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found"));
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new BusinessException("User email already taken");
        }
        User user = UserMapper.updateEntity(request, existUser);
        User updatedUser = userRepository.save(user);
        return UserMapper.toResponse(updatedUser);

    }

    @Override
    public void delete(UUID id) {
        User existsUser = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found"));
        userRepository.delete(existsUser);
    }
}
