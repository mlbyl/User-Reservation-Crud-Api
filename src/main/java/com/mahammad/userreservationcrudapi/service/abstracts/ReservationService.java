package com.mahammad.userreservationcrudapi.service.abstracts;

import com.mahammad.userreservationcrudapi.dto.request.ReservationCreateRequest;
import com.mahammad.userreservationcrudapi.dto.request.ReservationUpdateRequest;
import com.mahammad.userreservationcrudapi.dto.response.ReservationResponse;
import com.mahammad.userreservationcrudapi.model.Reservation;
import com.mahammad.userreservationcrudapi.model.User;

import java.util.List;
import java.util.UUID;

public interface ReservationService {
    List<ReservationResponse> findAll();

    ReservationResponse findById(UUID id);

    ReservationResponse save(ReservationCreateRequest request, UUID id);

    ReservationResponse update(UUID id, ReservationUpdateRequest request);

    void delete(UUID id);
}
