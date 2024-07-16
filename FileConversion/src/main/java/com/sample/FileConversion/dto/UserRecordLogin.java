package com.sample.FileConversion.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRecordLogin{
    @NotBlank(message = "Email Can not Be Blank")
    @Email
    String email;
    @NotBlank(message = "Password Can not Be Blank")
    String password;
}
