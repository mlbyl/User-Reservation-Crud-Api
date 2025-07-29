package com.mahammad.userreservationcrudapi.repository;

import com.mahammad.userreservationcrudapi.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReservationRepository extends JpaRepository<Reservation, UUID> {
}
