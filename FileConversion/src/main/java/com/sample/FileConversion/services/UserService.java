package com.sample.FileConversion.services;

import com.sample.FileConversion.dto.UserRecordLogin;
import com.sample.FileConversion.dto.UserRecordRegistration;
import com.sample.FileConversion.exception.UserNotFoundException;
import com.sample.FileConversion.model.User;
import com.sample.FileConversion.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    public ResponseEntity<?> createUser(UserRecordRegistration newUser) {
        Optional<User> existingUser = repository.findByEmail(newUser.getEmail());
        if (existingUser.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User Already Registered");
        } else {
            User user = new User();
            user.setName(newUser.getName());
            user.setEmail(newUser.getEmail());
            user.setPhoneNumber(newUser.getPhoneNumber());
            user.setPassword(encoder.encode(newUser.getPassword()));
            repository.save(user);
            return ResponseEntity.status(HttpStatus.CREATED).body("User Created Successfully");
        }
    }

    public List<User> getAllUser() {
        return repository.findAll();
    }

    public User updateUser(Integer id, UserRecordRegistration updateUser) {
        Optional<User> getUser = repository.findById(id);
        if (getUser.isEmpty()) {
            throw new UserNotFoundException("User Not Registered");
        } else {
            User changeUser = getUser.get();
            if (updateUser.getEmail() != null) {
                changeUser.setEmail(updateUser.getEmail());
            }
            if (updateUser.getPassword() != null) {
                changeUser.setPassword(updateUser.getPassword());
            }
            return repository.save(changeUser);
        }
    }

    public ResponseEntity<?> deleteUser(Integer id) {
        Optional<User> user = repository.findById(id);
        if(user.isPresent()){
            repository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("User Deleted SuccesFully");
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Not Found");
        }
    }

    public ResponseEntity<?> getSingleUser(Integer id) {
        Optional<User> user = repository.findById(id);
        if (user.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(user.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Not Found");
        }
    }

    public ResponseEntity<?> login(UserRecordLogin loginUser) {
        Optional<User> user = repository.findByEmail(loginUser.getEmail());
        if(user.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User is Not Registered");
        }
        else{
            User userDetail = user.get();
            if(encoder.matches(loginUser.getPassword(), userDetail.getPassword())){
            return ResponseEntity.status(HttpStatus.FOUND).body(user.get());
            }
            else{
                return ResponseEntity.status(400).body("Password Did Not Matched");
            }
        }
    }
}
