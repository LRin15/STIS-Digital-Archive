package com.polstat.digitalarchive.service;

import com.polstat.digitalarchive.dto.UserDto;
public interface UserService {
    UserDto createUser(UserDto user);
    UserDto getUserByEmail(String email);
    UserDto updateUserProfile(Long userId, UserDto userDto);
    boolean changePassword(Long userId, String oldPassword, String newPassword);
    void deleteUser(Long userId);
}

