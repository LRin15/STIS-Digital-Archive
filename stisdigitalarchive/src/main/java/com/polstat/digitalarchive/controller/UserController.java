package com.polstat.digitalarchive.controller;

import com.polstat.digitalarchive.dto.UserDto;
import com.polstat.digitalarchive.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PutMapping("/{userId}/profile")
    public ResponseEntity<UserDto> updateProfile(@PathVariable Long userId, @RequestBody @Valid UserDto userDto) {
        UserDto updatedUser = userService.updateUserProfile(userId, userDto);
        return ResponseEntity.ok(updatedUser);
    }

    @PutMapping("/{userId}/change-password")
    public ResponseEntity<?> changePassword(@PathVariable Long userId, @RequestParam String oldPassword, @RequestParam String newPassword) {
        boolean success = userService.changePassword(userId, oldPassword, newPassword);
        if (success) {
            return ResponseEntity.ok("Password changed successfully");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Old password is incorrect");
        }
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteAccount(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok("Account deleted successfully");
    }
}

