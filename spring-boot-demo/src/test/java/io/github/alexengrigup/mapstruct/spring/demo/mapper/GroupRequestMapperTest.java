package io.github.alexengrigup.mapstruct.spring.demo.mapper;

import io.github.alexengrigup.mapstruct.spring.demo.converter.UserIdConverter;
import io.github.alexengrigup.mapstruct.spring.demo.domain.Group;
import io.github.alexengrigup.mapstruct.spring.demo.domain.User;
import io.github.alexengrigup.mapstruct.spring.demo.dto.GroupDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = {
        GroupRequestMapperTest.Config.class,
        MapStructGroupRequestMapper.class
})
class GroupRequestMapperTest {

    @Test
    void should_map_dto_to_domain(@Autowired GroupRequestMapper mapper) {
        GroupDto request = GroupDto.builder()
                .id(1L)
                .users(List.of(10L, 100L))
                .build();
        Group domain = mapper.mapRequestToDomain(request);
        assertEquals(1L, domain.getId());
        List<User> users = domain.getUsers();
        assertEquals(2, users.size());
        User firstUser = users.get(0);
        assertEquals(10L, firstUser.getId());
        assertEquals("User-10", firstUser.getUsername());
        User secondUser = users.get(1);
        assertEquals(100L, secondUser.getId());
        assertEquals("User-100", secondUser.getUsername());
    }

    @Configuration
    static class Config {
        @Bean
        UserIdConverter userIdConverter() {
            return userId -> User.builder()
                    .id(userId)
                    .username("User-" + userId)
                    .build();
        }
    }
}