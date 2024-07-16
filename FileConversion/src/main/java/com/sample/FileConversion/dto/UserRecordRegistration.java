package com.sample.FileConversion.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRecordRegistration{
    @NotBlank(message = "Name Cannot be Blank")
    String name;
    @NotBlank(message = "Email Cannot be Blank")
    @Email
    String email;
    @Pattern(regexp = "^[789]\\d{9}$", message = "Phone number must be 10 digits and start with 7, 8, or 9")
    @NotBlank(message = "PhoneNumber Cannot be Blank")
    String phoneNumber;
    @NotBlank(message = "Password Cannot be Blank")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    String password;
}
