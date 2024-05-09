package io.github.alexengrigup.mapstruct.spring.demo.controller;

import io.github.alexengrigup.mapstruct.spring.demo.domain.User;
import io.github.alexengrigup.mapstruct.spring.demo.mapper.UserResponseMapper;
import io.github.alexengrigup.mapstruct.spring.demo.payload.UserResponse;
import io.github.alexengrigup.mapstruct.spring.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    private final UserResponseMapper userResponseMapper;

    @PostMapping("/{name}")
    public ResponseEntity<UserResponse> createUserByName(@PathVariable String name) {
        User user = userService.createByName(name);
        UserResponse response = userResponseMapper.mapDomainToResponse(user);
        return ResponseEntity.ok(response);
    }
}
