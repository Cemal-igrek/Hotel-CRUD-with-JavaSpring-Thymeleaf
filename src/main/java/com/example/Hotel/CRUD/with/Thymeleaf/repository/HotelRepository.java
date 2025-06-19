package com.example.Hotel.CRUD.with.Thymeleaf.repository;

import com.example.Hotel.CRUD.with.Thymeleaf.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

}
