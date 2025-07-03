package com.example.Hotel.CRUD.with.Thymeleaf.services;
import com.example.Hotel.CRUD.with.Thymeleaf.dto.UserDTO;
import com.example.Hotel.CRUD.with.Thymeleaf.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDTO userDto);
    User findByEmail(String email);
    List<User> findAll();
    User findById(Long id);

    void updateUser(Long id, UserDTO userDto);

    void deleteById(Long id);
}
