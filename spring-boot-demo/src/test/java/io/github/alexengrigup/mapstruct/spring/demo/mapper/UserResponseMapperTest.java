package io.github.alexengrigup.mapstruct.spring.demo.mapper;

import io.github.alexengrigup.mapstruct.spring.demo.domain.User;
import io.github.alexengrigup.mapstruct.spring.demo.payload.UserResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class UserResponseMapperTest {
    @Test
    void should_test(@Autowired UserResponseMapper mapper) {
        User domain = User.builder()
                .id(UUID.randomUUID())
                .name("Test-user")
                .build();
        UserResponse response = mapper.mapDomainToResponse(domain);
        assertEquals(domain.getId(), response.getId(), "Id");
        assertEquals(domain.getName(), response.getName(), "Name");
    }
}