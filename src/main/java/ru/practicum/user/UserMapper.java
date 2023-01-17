package ru.practicum.user;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class UserMapper {
    public static UserResponseDto toResponseDto(User user) {
        try {
            return UserResponseDto.builder()
                    .id(user.getId())
                    .name(user.getName())
                    .email(user.getEmail())
                    .registrationDate(new SimpleDateFormat("yyyy.MM.dd,hh:mm:ss").parse(user.getRegistrationDate()).toString())
                    .build();
        } catch (ParseException e) {
            return null;
        }
    }

    public static User toEntity(UserRequestDto userRequestDto) {
        return User.builder()
                .name(userRequestDto.getName())
                .email(userRequestDto.getEmail())
                .build();
    }
}
