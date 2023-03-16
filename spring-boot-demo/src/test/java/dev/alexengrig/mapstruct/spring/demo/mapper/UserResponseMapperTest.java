package dev.alexengrig.mapstruct.spring.demo.mapper;

import dev.alexengrig.mapstruct.spring.demo.domain.User;
import dev.alexengrig.mapstruct.spring.demo.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class UserResponseMapperTest {

    @Test
    void should_map_domain_to_dto(@Autowired UserResponseMapper mapper) {
        User domain = User.builder()
                .id(1L)
                .username("one")
                .build();
        UserDto dto = mapper.mapDomainToResponse(domain);
        assertEquals(1L, dto.getId());
        assertEquals("one", dto.getUsername());
    }

}