package com.polstat.digitalarchive.mapper;

import com.polstat.digitalarchive.dto.UserDto;
import com.polstat.digitalarchive.entity.User;
public class UserMapper {
    public static UserDto mapToUserDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .address(user.getAddress())
                .phoneNumber(user.getPhoneNumber())
                .build();
    }

    public static User mapToUser(UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .name(userDto.getName())
                .email(userDto.getEmail())
                .address(userDto.getAddress())
                .phoneNumber(userDto.getPhoneNumber())
                .password(userDto.getPassword())
                .build();
    }
}
