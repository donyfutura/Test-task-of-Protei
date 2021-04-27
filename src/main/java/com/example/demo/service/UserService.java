package com.example.demo.service;

import com.example.demo.api.request.StatusRequest;
import com.example.demo.api.request.UserRequest;
import com.example.demo.api.response.ErrorResponse;
import com.example.demo.api.response.IdResponse;
import com.example.demo.api.response.StatusResponse;
import com.example.demo.entity.Status;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<?> addUser(UserRequest userRequest){
        if (userRepository.findByEmail(userRequest.getEmail()) != null){
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setMessage("User with email " + userRequest.getEmail() + " exist!");
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
        User user = new User();
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.setPhoneNumber(userRequest.getPhoneNumber());
        user.setStatus(Status.Online);
        user.setLastSeen(Calendar.getInstance().getTime());
        userRepository.save(user);
        IdResponse idResponse = new IdResponse();
        idResponse.setId(user.getId());
        return new ResponseEntity<>(idResponse, HttpStatus.CREATED);
    }

    public ResponseEntity<?> findUser(Long id){
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()){
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setMessage("User with id: " + id + " not exist!");
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user.get(), HttpStatus.OK);
    }

    public ResponseEntity<?> setStatusById(long id, StatusRequest statusRequest) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()){
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setMessage("User with id: " + id + " not exist!");
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }

        if (statusRequest.getStatus() == null){
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setMessage("Status is empty!");
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }

        User currentUser = user.get();
        Status oldStatus = currentUser.getStatus();
        StatusResponse statusResponse = new StatusResponse();
        statusResponse.setOldStatus(oldStatus);
        statusResponse.setNewStatus(statusRequest.getStatus());
        statusResponse.setId(currentUser.getId());
        currentUser.setStatus(statusRequest.getStatus());
        if (statusRequest.getStatus() == Status.Online){
            currentUser.setLastSeen(Calendar.getInstance().getTime());
        }
        userRepository.save(currentUser);
        return new ResponseEntity<>(statusResponse, HttpStatus.OK);
    }
}
