package com.example.Hotel.CRUD.with.Thymeleaf.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UserDTO {
    private Long id;
    @NotEmpty(message = "İsim boş olamaz.")
    private String name;
    @NotEmpty(message = "E-posta boş olamaz.")
    @Email
    private String email;
    @NotEmpty(message = "Şifre boş olamaz.")
    private String password;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; } // Hatanın çözümü için gerekli metot
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
