package com.example.Hotel.CRUD.with.Thymeleaf.repository;

import com.example.Hotel.CRUD.with.Thymeleaf.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
