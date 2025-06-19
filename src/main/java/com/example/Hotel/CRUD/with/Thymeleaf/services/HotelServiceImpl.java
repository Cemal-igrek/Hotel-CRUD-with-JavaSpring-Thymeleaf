package com.example.Hotel.CRUD.with.Thymeleaf.services;

import com.example.Hotel.CRUD.with.Thymeleaf.entity.Hotel;
import com.example.Hotel.CRUD.with.Thymeleaf.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    private HotelRepository hotelRepository;

    public HotelServiceImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public List<Hotel> getAllHotels() {
   return this.hotelRepository.findAll();

    }

    @Override
    public Hotel getHotelById(Long id) {
        return null;
    }

    @Override
    public void saveHotel(Hotel hotel) {
    this.hotelRepository.save(hotel);
    }

    @Override
    public void updateHotel(Hotel hotel) {

    }

    @Override
    public void deleteHotel(Long id) {

    }
}
