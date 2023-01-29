package dev.alexengrig.mapstruct.spring.demo.mapper;

import dev.alexengrig.mapstruct.spring.demo.domain.PersonalTransport;
import dev.alexengrig.mapstruct.spring.demo.domain.User;
import dev.alexengrig.mapstruct.spring.demo.dto.PersonalTransportRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class PersonalTransportRequestMapperTest {

    static PersonalTransportRequest createRequest() {
        return PersonalTransportRequest.builder()
                .id(1L)
                .name("Test-name")
                .type("PERSONAL")
                .ownerId(1L)
                .build();
    }

    static void assertDomain(PersonalTransportRequest request, PersonalTransport domain) {
        assertEquals(request.getId(), domain.getId(), "Id");
        assertEquals(request.getName(), domain.getName(), "Name");
        assertNotNull(domain.getTransportType(), "Type");
        assertEquals(request.getType(), domain.getTransportType().name(), "Type");
        User owner = domain.getOwner();
        assertNotNull(owner, "Owner");
        assertEquals(request.getOwnerId(), owner.getId(), "OwnerId");
        assertNull(owner.getUsername(), "OwnerUsername");
    }

    @Test
    void should_map(@Autowired PersonalTransportRequestMapper mapper) {
        PersonalTransportRequest request = createRequest();
        PersonalTransport domain = mapper.mapRequestToDomain(request);
        assertDomain(request, domain);
    }

}