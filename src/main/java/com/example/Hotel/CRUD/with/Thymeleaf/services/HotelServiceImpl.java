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
        // findById, bir Optional döner. Bulamazsa diye bir exception fırlatmak iyidir.
        return hotelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hotel not found for id :: " + id));
    }

    @Override
    public Hotel saveHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public void updateHotel(Hotel hotel) {
        hotelRepository.save(hotel); // save metodu hem ekleme hem güncelleme yapar
    }

    @Override
    public void deleteHotel(Long id) {
        hotelRepository.deleteById(id);
    }


}
