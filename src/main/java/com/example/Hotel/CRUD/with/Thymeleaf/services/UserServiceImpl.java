package com.example.Hotel.CRUD.with.Thymeleaf.services;

import com.example.Hotel.CRUD.with.Thymeleaf.dto.UserDTO;
import com.example.Hotel.CRUD.with.Thymeleaf.entity.Role;
import com.example.Hotel.CRUD.with.Thymeleaf.entity.User;
import com.example.Hotel.CRUD.with.Thymeleaf.repository.RoleRepository;
import com.example.Hotel.CRUD.with.Thymeleaf.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(UserDTO userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        Role role = roleRepository.findByName("ROLE_USER");
        if(role == null){
            role = checkRoleExist();
        }
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }
    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void updateUser(Long id, UserDTO userDto) {
        User user = findById(id);
        if (user != null) {
            user.setName(userDto.getName());
            user.setEmail(userDto.getEmail());
            if(userDto.getPassword() != null && !userDto.getPassword().isEmpty()) {
                user.setPassword(passwordEncoder.encode(userDto.getPassword()));
            }
            // Roller isteğe bağlı düzenlenebilir, burada sadece ROLE_USER varsayalım
            Role role = roleRepository.findByName("ROLE_USER");
            if(role == null){
                role = checkRoleExist();
            }
            user.setRoles(Arrays.asList(role));
            userRepository.save(user);
        }
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    private Role checkRoleExist() {
        Role role = new Role();
        role.setName("ROLE_USER");
        return roleRepository.save(role);
    }
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
