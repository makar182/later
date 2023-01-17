package ru.practicum.user;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserResponseDto> getAllUsers() {
        return userService.getAllUsers().stream().map(UserMapper::toResponseDto).toList();
    }

    @PostMapping
    public UserResponseDto saveNewUser(@RequestBody UserRequestDto user) {
        return UserMapper.toResponseDto(userService.saveUser(UserMapper.toEntity(user)));
    }
}