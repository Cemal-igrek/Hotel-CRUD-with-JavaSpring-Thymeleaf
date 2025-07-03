package com.example.Hotel.CRUD.with.Thymeleaf.controller;

import com.example.Hotel.CRUD.with.Thymeleaf.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasRole('ROLE_ADMIN')") // Bu controller'a sadece adminler erişebilir
public class AdminController {

    // Gerekli servisleri inject et (UserService, HotelService, ReservationService)

    private UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/dashboard")
    public String adminDashboard() {
        return "admin/dashboard";
    }


    @GetMapping("/hotels")
    public String listHotels(Model model) {
        // model.addAttribute("hotels", hotelService.getAllHotels());
        return "admin/hotel_list";
    }

    @GetMapping("/reservations")
    public String listReservations(Model model) {
        // model.addAttribute("reservations", reservationService.findAll());
        return "admin/reservation_list";
    }
}
