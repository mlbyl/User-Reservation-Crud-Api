package com.mahammad.userreservationcrudapi.mapper;

import com.mahammad.userreservationcrudapi.dto.request.ReservationCreateRequest;
import com.mahammad.userreservationcrudapi.dto.request.ReservationUpdateRequest;
import com.mahammad.userreservationcrudapi.dto.response.ReservationResponse;
import com.mahammad.userreservationcrudapi.model.Reservation;
import com.mahammad.userreservationcrudapi.model.User;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ReservationMapper {

    public static ReservationResponse toResponse(Reservation reservation) {
        return new ReservationResponse(
                reservation.getId(),
                reservation.getReservationType(),
                reservation.getReservationStatus(),
                reservation.getStartTime(),
                reservation.getEndTime(),
                UserMapper.toUserInReservationResponse(reservation.getUser())
        );
    }

    public static List<ReservationResponse> toResponse(List<Reservation> reservations) {
        if (reservations == null) {
            return Collections.emptyList();
        }
        return reservations.stream()
                .map(reservation -> {
                    return ReservationMapper.toResponse(reservation);
                }).collect(Collectors.toList());

    }

    public static Reservation toEntity(ReservationCreateRequest request, User user) {

        return Reservation.builder()
                .startTime(request.getStartTime())
                .endTime(request.getEndTime())
                .reservationStatus(request.getReservationStatus())
                .reservationType(request.getReservationType())
                .user(user)
                .build();
    }

    public static Reservation updateEntity(Reservation reservation, ReservationUpdateRequest request) {
        reservation.setStartTime(request.getStartTime());
        reservation.setEndTime(request.getEndTime());
        reservation.setReservationType(request.getReservationType());
        reservation.setReservationStatus(request.getReservationStatus());


        return reservation;
    }
}
