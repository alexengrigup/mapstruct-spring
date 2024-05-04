package io.github.alexengrigup.mapstruct.spring.demo.service;

import io.github.alexengrigup.mapstruct.spring.demo.domain.User;

import java.util.Optional;
import java.util.UUID;

public interface UserService {
    User createByName(String name);

    Optional<User> findById(UUID userId);
}
