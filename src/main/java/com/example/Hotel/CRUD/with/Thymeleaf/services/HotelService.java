package com.example.Hotel.CRUD.with.Thymeleaf.services;

import com.example.Hotel.CRUD.with.Thymeleaf.entity.Hotel;

import java.util.List;

public interface HotelService {
    List<Hotel> getAllHotels();
    Hotel getHotelById(Long id);
    Hotel saveHotel(Hotel hotel);
    void updateHotel(Hotel hotel);
    void deleteHotel(Long id);
}
