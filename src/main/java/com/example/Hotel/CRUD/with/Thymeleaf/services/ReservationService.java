package com.example.Hotel.CRUD.with.Thymeleaf.services;

import com.example.Hotel.CRUD.with.Thymeleaf.entity.Reservation;
import com.example.Hotel.CRUD.with.Thymeleaf.entity.User;
import java.util.List;

public interface ReservationService {
    void saveReservation(Reservation reservation);
    List<Reservation> findByUser(User user);
    List<Reservation> findAll(); // Admin paneli için tüm rezervasyonları listelemek
}
