package com.example.Hotel.CRUD.with.Thymeleaf.services;

import com.example.Hotel.CRUD.with.Thymeleaf.entity.Reservation;
import com.example.Hotel.CRUD.with.Thymeleaf.entity.User;
import com.example.Hotel.CRUD.with.Thymeleaf.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public void saveReservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> findByUser(User user) {
        return reservationRepository.findByUser(user);
    }

    @Override
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }
}
