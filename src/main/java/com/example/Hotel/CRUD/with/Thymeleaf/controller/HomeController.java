package com.example.Hotel.CRUD.with.Thymeleaf.controller;

import com.example.Hotel.CRUD.with.Thymeleaf.dto.UserDTO;
import com.example.Hotel.CRUD.with.Thymeleaf.entity.User;
import com.example.Hotel.CRUD.with.Thymeleaf.services.HotelService;
import com.example.Hotel.CRUD.with.Thymeleaf.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class HomeController {
    private HotelService hotelService;
    private UserService userService;
    @Autowired
    public HomeController(HotelService hotelService, UserService userService) {
        this.hotelService = hotelService;
        this.userService = userService;
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "user_list";
    }
    @GetMapping("/users/edit/{id}")
    public String editUserForm(@PathVariable Long id, Model model) {
        User user = userService.findById(id);
        if(user == null) {
            return "redirect:/users"; // kullanıcı bulunamazsa listeye dön
        }
        model.addAttribute("user", user);
        return "user_edit"; // kullanıcı düzenleme formu için view
    }

    @PostMapping("/users/edit/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute("user") UserDTO userDto) {
        userService.updateUser(id, userDto);
        return "redirect:/users";
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
        return "redirect:/users";
    }
}
