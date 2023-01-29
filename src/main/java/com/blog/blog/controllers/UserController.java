package com.blog.blog.controllers;

import com.blog.blog.payloads.ApiResponse;
import com.blog.blog.payloads.LoginDto;
import com.blog.blog.payloads.UserDto;
import com.blog.blog.services.impl.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/register")
    public ResponseEntity<UserDto> registerUser(@Valid @RequestBody UserDto userDto){
        UserDto savedUser = userService.registerUser(userDto);
        return new ResponseEntity<UserDto>(savedUser, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<UserDto> loginUser(@Valid @RequestBody LoginDto loginDto){
        String email = loginDto.getEmail();
        String password = loginDto.getPassword();
        UserDto user = userService.loginUser(email,password);
        return new ResponseEntity<UserDto>(user, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> users= userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUser(@Valid @PathVariable("userId") Integer userId){
        UserDto userDto = userService.getUserById(userId);
        return ResponseEntity.ok(userDto);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("userId") Integer userId,
                                              @RequestBody UserDto userDto){
        UserDto user = userService.updateUser(userDto,userId);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{userId}")
    public ApiResponse deleteUser(@PathVariable("userId") Integer id){
        userService.deleteUserById(id);
        return new ApiResponse("User is successfully deleted !!", true);
    }
}
