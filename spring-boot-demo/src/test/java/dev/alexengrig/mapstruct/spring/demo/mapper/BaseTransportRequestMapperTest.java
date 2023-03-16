package dev.alexengrig.mapstruct.spring.demo.mapper;

import dev.alexengrig.mapstruct.spring.demo.domain.BaseTransport;
import dev.alexengrig.mapstruct.spring.demo.domain.CommonTransport;
import dev.alexengrig.mapstruct.spring.demo.domain.PersonalTransport;
import dev.alexengrig.mapstruct.spring.demo.domain.User;
import dev.alexengrig.mapstruct.spring.demo.dto.CommonTransportRequest;
import dev.alexengrig.mapstruct.spring.demo.dto.PersonalTransportRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class BaseTransportRequestMapperTest {

    @Test
    void should_map_common(@Autowired BaseTransportRequestMapper mapper) {
        CommonTransportRequest request = CommonTransportRequest.builder()
                .id(10L)
                .name("Test-name")
                .type("COMMON")
                .code("121E")
                .build();
        BaseTransport domain = mapper.mapRequestToDomain(request);
        assertInstanceOf(CommonTransport.class, domain);
        CommonTransport commonDomain = (CommonTransport) domain;
        assertEquals(request.getId(), commonDomain.getId(), "Id");
        assertEquals(request.getName(), commonDomain.getName(), "Name");
        assertEquals(request.getCode(), commonDomain.getCode(), "Code");
    }

    @Test
    void should_map_personal(@Autowired BaseTransportRequestMapper mapper) {
        PersonalTransportRequest request = PersonalTransportRequest.builder()
                .id(100L)
                .name("Test-name")
                .type("PERSONAL")
                .ownerId(1L)
                .build();
        BaseTransport domain = mapper.mapRequestToDomain(request);
        assertInstanceOf(PersonalTransport.class, domain);
        PersonalTransport personalDomain = (PersonalTransport) domain;
        assertEquals(request.getId(), personalDomain.getId(), "Id");
        assertEquals(request.getName(), personalDomain.getName(), "Name");
        assertNotNull(personalDomain.getTransportType(), "Type");
        assertEquals(request.getType(), personalDomain.getTransportType().name(), "Type");
        User owner = personalDomain.getOwner();
        assertNotNull(owner, "Owner");
        assertEquals(request.getOwnerId(), owner.getId(), "OwnerId");
        assertEquals("Fake-user", owner.getUsername(), "OwnerName");
    }

}