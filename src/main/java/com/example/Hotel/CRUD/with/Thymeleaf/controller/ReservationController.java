package com.example.Hotel.CRUD.with.Thymeleaf.controller;

import com.example.Hotel.CRUD.with.Thymeleaf.entity.Hotel;
import com.example.Hotel.CRUD.with.Thymeleaf.entity.Reservation;
import com.example.Hotel.CRUD.with.Thymeleaf.entity.User;
import com.example.Hotel.CRUD.with.Thymeleaf.services.HotelService;
import com.example.Hotel.CRUD.with.Thymeleaf.services.ReservationService;
import com.example.Hotel.CRUD.with.Thymeleaf.services.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;
    private final HotelService hotelService;
    private final UserService userService;

    // Dependency Injection için Constructor
    public ReservationController(ReservationService reservationService, HotelService hotelService, UserService userService) {
        this.reservationService = reservationService;
        this.hotelService = hotelService;
        this.userService = userService;
    }

    // Rezervasyon oluşturma formunu gösterir
    @GetMapping("/new/{hotelId}")
    public String showReservationForm(@PathVariable Long hotelId, Model model) {
        Hotel hotel = hotelService.getHotelById(hotelId);
        Reservation reservation = new Reservation();
        reservation.setHotel(hotel); // Rezervasyonun hangi otele ait olduğunu baştan belirle

        model.addAttribute("hotel", hotel);
        model.addAttribute("reservation", reservation);

        return "reservation_form"; // Bu isimde bir html dosyası oluşturacağız
    }

    // Formdan gelen rezervasyon bilgisini kaydeder
    @PostMapping("/save")
    public String saveReservation(@ModelAttribute("reservation") Reservation reservation) {
        // Güvenlik bağlamından o an giriş yapmış kullanıcının email'ini al
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByEmail(email);

        // Rezervasyonu yapan kullanıcıyı ve oteli ayarla
        reservation.setUser(user);

        reservationService.saveReservation(reservation);

        // Başarılı kayıttan sonra kullanıcıyı kendi rezervasyonları sayfasına yönlendir
        return "redirect:/reservations/my-reservations?success";
    }

    // Kullanıcının kendi rezervasyonlarını gösterir
    @GetMapping("/my-reservations")
    public String showMyReservations(Model model) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByEmail(email);

        model.addAttribute("reservations", reservationService.findByUser(user));
        return "my_reservations"; // Bu isimde bir html dosyası oluşturacağız
    }
}
