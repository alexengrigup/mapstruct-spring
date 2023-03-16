package dev.alexengrig.mapstruct.spring.demo.mapper;

import dev.alexengrig.mapstruct.spring.demo.converter.FakeUserIdConverter;
import dev.alexengrig.mapstruct.spring.demo.domain.PersonalTransport;
import dev.alexengrig.mapstruct.spring.demo.domain.User;
import dev.alexengrig.mapstruct.spring.demo.dto.PersonalTransportRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = {
        PersonalTransportRequestMapperTest.Config.class,
        MapStructPersonalTransportRequestMapper.class
})
class PersonalTransportRequestMapperTest {
    static final String OWNER_NAME = "Test-username";

    @Test
    void should_map(@Autowired PersonalTransportRequestMapper mapper) {
        PersonalTransportRequest request = PersonalTransportRequest.builder()
                .id(100L)
                .name("Test-name")
                .type("PERSONAL")
                .ownerId(200L)
                .build();
        PersonalTransport domain = mapper.mapRequestToDomain(request);
        assertEquals(request.getId(), domain.getId(), "Id");
        assertEquals(request.getName(), domain.getName(), "Name");
        assertNotNull(domain.getTransportType(), "Type");
        assertEquals(request.getType(), domain.getTransportType().name(), "Type");
        User owner = domain.getOwner();
        assertNotNull(owner, "Owner");
        assertEquals(request.getOwnerId(), owner.getId(), "OwnerId");
        assertEquals(OWNER_NAME, owner.getUsername(), "OwnerUsername");
    }

    @Configuration
    static class Config {
        @Bean
        FakeUserIdConverter fakeUserIdConverter() {
            return new FakeUserIdConverter(OWNER_NAME);
        }
    }
}