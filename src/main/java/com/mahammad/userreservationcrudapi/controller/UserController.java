package com.mahammad.userreservationcrudapi.controller;


import com.mahammad.userreservationcrudapi.dto.request.UserCreateRequest;
import com.mahammad.userreservationcrudapi.dto.request.UserUpdateRequest;
import com.mahammad.userreservationcrudapi.dto.response.UserResponse;
import com.mahammad.userreservationcrudapi.service.abstracts.UserService;
import com.mahammad.userreservationcrudapi.utilities.results.Result;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/findall")
    public ResponseEntity<Result<List<UserResponse>>> findAll() {

        return ResponseEntity.ok(Result.success("Data successfully retrieved", userService.findAll()));
    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity<Result<UserResponse>> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(Result.success("Data successfully retrieved", userService.findById(id)));
    }

    @PostMapping("/create")
    public ResponseEntity<Result<UserResponse>> create(@Valid @RequestBody UserCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(Result.success("User created successfully", userService.save(request)));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Result<UserResponse>> update(@Valid @PathVariable UUID id, @RequestBody UserUpdateRequest request) {
        return ResponseEntity.ok(Result.success("Data updated successfully", userService.update(id, request)));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Result<?>> delete(@PathVariable UUID id) {
        userService.delete(id);
        return ResponseEntity.ok(Result.success("Data deleted successfully"));
    }


}
