package io.github.alexengrigup.mapstruct.spring.demo.service;

import io.github.alexengrigup.mapstruct.spring.demo.domain.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class MapUserService implements UserService {
    private final Map<UUID, User> userById = new HashMap<>();

    @Override
    public User createByName(String name) {
        User user = User.builder()
                .id(UUID.randomUUID())
                .name(name)
                .build();
        userById.put(user.getId(), user);
        return user;
    }

    @Override
    public Optional<User> findById(UUID userId) {
        return Optional.ofNullable(userById.get(userId));
    }
}
