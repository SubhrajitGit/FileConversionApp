package com.sample.FileConversion.controllers;

import com.sample.FileConversion.dto.UserRecordLogin;
import com.sample.FileConversion.dto.UserRecordRegistration;
import com.sample.FileConversion.model.User;
import com.sample.FileConversion.services.UserService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin("*")
public class userController {
    @Autowired
    private UserService service;

    @Autowired
    private ModelMapper mapper;

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserRecordRegistration newUser){
        return service.createUser(newUser);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<User>> allUser(){
        List<User> allUser = service.getAllUser();
        return ResponseEntity.status(HttpStatus.OK).body(allUser);
    }
    @GetMapping("/getSingle/{id}")
    public ResponseEntity<?> allUser(@PathVariable Integer id){
        return service.getSingleUser(id);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Integer id,@RequestBody UserRecordRegistration updateUser){
        User userDetails = mapper.map(updateUser,User.class);
        User updateUserDetails = service.updateUser(id,updateUser);
        return ResponseEntity.status(HttpStatus.OK).body("User Update SucessFull");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id){
        return service.deleteUser(id);
    }

    //Extra End Point

    //login
    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody UserRecordLogin loginUser){
        return service.login(loginUser);
    }
}
