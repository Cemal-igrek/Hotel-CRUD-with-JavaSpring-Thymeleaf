package Services;

import entity.Hotel;
import repository.HotelRepository;

import java.util.List;

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
