package com.mahammad.userreservationcrudapi.controller;


import com.mahammad.userreservationcrudapi.dto.request.ReservationCreateRequest;
import com.mahammad.userreservationcrudapi.dto.request.ReservationUpdateRequest;
import com.mahammad.userreservationcrudapi.dto.response.ReservationResponse;
import com.mahammad.userreservationcrudapi.service.abstracts.ReservationService;
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
@RequestMapping("/api/reservation")
@AllArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;

    @GetMapping("/findall")
    public ResponseEntity<Result<List<ReservationResponse>>> findAll() {
        return ResponseEntity.ok(Result.success("Data successfully retrieved", reservationService.findAll()));
    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity<Result<ReservationResponse>> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(Result.success("Data successfully retrieved", reservationService.findById(id)));
    }

    @PostMapping("/create/{userId}")
    public ResponseEntity<Result<ReservationResponse>> create(@Valid @PathVariable UUID userId, @RequestBody ReservationCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(Result.success("Data successfully created", reservationService.save(request, userId)));

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Result<ReservationResponse>> update(@Valid @PathVariable UUID id, @RequestBody ReservationUpdateRequest request) {
        return ResponseEntity.ok(Result.success("Data successfully updated", reservationService.update(id, request)));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Result<?>> delete(@PathVariable UUID id) {
        reservationService.delete(id);
        return ResponseEntity.ok(Result.success("Data deleted successfully"));
    }


}
