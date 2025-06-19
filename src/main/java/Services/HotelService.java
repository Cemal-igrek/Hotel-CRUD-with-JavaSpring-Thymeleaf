package Services;

import entity.Hotel;

import java.util.List;

public interface HotelService {
    List<Hotel> getAllHotels();
    Hotel getHotelById(Long id);
    void saveHotel(Hotel hotel);
    void updateHotel(Hotel hotel);
    void deleteHotel(Long id);
}
