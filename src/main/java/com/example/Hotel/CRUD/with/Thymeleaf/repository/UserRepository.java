package com.example.Hotel.CRUD.with.Thymeleaf.repository;

import com.example.Hotel.CRUD.with.Thymeleaf.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
