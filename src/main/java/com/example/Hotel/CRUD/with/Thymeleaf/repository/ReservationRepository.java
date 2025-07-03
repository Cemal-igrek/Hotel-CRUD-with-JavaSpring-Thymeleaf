package com.example.Hotel.CRUD.with.Thymeleaf.repository;

import com.example.Hotel.CRUD.with.Thymeleaf.entity.Reservation;
import com.example.Hotel.CRUD.with.Thymeleaf.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    // Belirli bir kullanıcıya ait tüm rezervasyonları bulan metot
    List<Reservation> findByUser(User user);
}
