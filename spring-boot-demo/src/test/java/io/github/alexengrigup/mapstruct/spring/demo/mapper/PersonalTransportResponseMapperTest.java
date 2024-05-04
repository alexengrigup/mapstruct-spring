package io.github.alexengrigup.mapstruct.spring.demo.mapper;

import io.github.alexengrigup.mapstruct.spring.demo.domain.PersonalTransport;
import io.github.alexengrigup.mapstruct.spring.demo.domain.User;
import io.github.alexengrigup.mapstruct.spring.demo.payload.PersonalTransportResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PersonalTransportResponseMapperTest {
    @Test
    void should_map(@Autowired PersonalTransportResponseMapper mapper) {
        PersonalTransport domain = PersonalTransport.builder()
                .id(UUID.randomUUID())
                .name("Test-personal")
                .owner(User.builder()
                        .id(UUID.randomUUID())
                        .name("Test-owner")
                        .build())
                .build();
        PersonalTransportResponse response = mapper.mapDomainToResponse(domain);
        assertEquals(domain.getId(), response.getId(), "Id");
        assertEquals(domain.getName(), response.getName(), "Name");
        assertEquals(domain.getOwner().getId(), response.getOwnerId(), "OwnerId");
    }
}