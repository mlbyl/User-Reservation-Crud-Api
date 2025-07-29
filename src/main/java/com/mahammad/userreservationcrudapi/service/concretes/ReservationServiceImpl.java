package com.mahammad.userreservationcrudapi.service.concretes;

import com.mahammad.userreservationcrudapi.dto.request.ReservationCreateRequest;
import com.mahammad.userreservationcrudapi.dto.request.ReservationUpdateRequest;
import com.mahammad.userreservationcrudapi.dto.response.ReservationResponse;
import com.mahammad.userreservationcrudapi.exception.BusinessException;
import com.mahammad.userreservationcrudapi.exception.NotFoundException;
import com.mahammad.userreservationcrudapi.mapper.ReservationMapper;
import com.mahammad.userreservationcrudapi.model.Reservation;
import com.mahammad.userreservationcrudapi.model.User;
import com.mahammad.userreservationcrudapi.repository.ReservationRepository;
import com.mahammad.userreservationcrudapi.repository.UserRepository;
import com.mahammad.userreservationcrudapi.service.abstracts.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;
    private final UserRepository userRepository;

    @Override
    public List<ReservationResponse> findAll() {
        List<Reservation> reservations = reservationRepository.findAll();
        return ReservationMapper.toResponse(reservations);
    }

    @Override
    public ReservationResponse findById(UUID id) {
        Reservation reservation = reservationRepository.findById(id).orElseThrow(() -> new NotFoundException("Reservation not found"));
        return ReservationMapper.toResponse(reservation);

    }

    @Override
    public ReservationResponse save(ReservationCreateRequest request, UUID id) {
        User userExists = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found"));

        if (request.getStartTime().isAfter(request.getEndTime())) {
            throw new BusinessException("Reservation start time must be before end time");
        }

        Reservation reservation = ReservationMapper.toEntity(request, userExists);
        Reservation savedReservation = reservationRepository.save(reservation);
        return ReservationMapper.toResponse(savedReservation);

    }

    @Override
    public ReservationResponse update(UUID id, ReservationUpdateRequest request) {
        Reservation reservationExists = reservationRepository.findById(id).orElseThrow(() -> new NotFoundException("Reservation not found"));

        if(request.getStartTime().isAfter(request.getEndTime())){
            throw new BusinessException("Reservation start time must be before end time");
        }

        Reservation reservation = ReservationMapper.updateEntity(reservationExists, request);
        Reservation updatedReservation = reservationRepository.save(reservation);
        return ReservationMapper.toResponse(updatedReservation);
    }

    @Override
    public void delete(UUID id) {
        Reservation reservationExists = reservationRepository.findById(id).orElseThrow(() -> new NotFoundException("Reservation not found"));
        reservationRepository.delete(reservationExists);
    }
}
