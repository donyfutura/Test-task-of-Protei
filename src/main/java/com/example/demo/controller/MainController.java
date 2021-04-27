package com.example.demo.controller;

import com.example.demo.api.request.StatusRequest;
import com.example.demo.api.request.UserRequest;
import com.example.demo.api.response.StatusResponse;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@Validated
public class MainController {

    private final UserService userService;

    @Autowired
    public MainController(UserService userService) {
        this.userService = userService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/users")
    public ResponseEntity<?> addUser(@Valid @RequestBody UserRequest userRequest){
        return userService.addUser(userRequest);
    }

    @GetMapping(value = "/users/{id}")
    public ResponseEntity<?> findUser(@PathVariable long id){
        return userService.findUser(id);
    }

    @PutMapping(value = "/users/{id}")
    public ResponseEntity<?> setStatus(@PathVariable long id, @RequestBody StatusRequest statusRequest){
        return userService.setStatusById(id, statusRequest);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }



}
