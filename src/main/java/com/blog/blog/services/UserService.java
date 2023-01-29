package com.blog.blog.services;

import com.blog.blog.entities.User;
import com.blog.blog.payloads.UserDto;

import java.util.List;

public interface UserService {
    UserDto registerUser(UserDto userDto);
    UserDto loginUser(String email,String password);
    UserDto getUserById(Integer id);
    List<UserDto> getAllUsers();
    UserDto updateUser(UserDto user,Integer id);
    void deleteUserById(Integer id);
}
