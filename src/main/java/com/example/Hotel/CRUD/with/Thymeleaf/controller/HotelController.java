package com.example.Hotel.CRUD.with.Thymeleaf.controller;

import com.example.Hotel.CRUD.with.Thymeleaf.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.example.Hotel.CRUD.with.Thymeleaf.entity.Hotel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/hotels")
public class HotelController {
    private HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }
    @GetMapping
    public String listHotels(Model model) {
        model.addAttribute("hotels", hotelService.getAllHotels());
        return "hotel_list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("hotel", new Hotel());
        return "hotel_form";
    }


    @PostMapping("/add")
    public String saveHotel(@ModelAttribute("hotel") Hotel hotel) {
        hotelService.saveHotel(hotel);
        return "redirect:/hotels";
    }
}

