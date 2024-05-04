package io.github.alexengrigup.mapstruct.spring.demo.mapper;

import io.github.alexengrigup.mapstruct.spring.demo.domain.CommonTransport;
import io.github.alexengrigup.mapstruct.spring.demo.domain.PersonalTransport;
import io.github.alexengrigup.mapstruct.spring.demo.domain.User;
import io.github.alexengrigup.mapstruct.spring.demo.payload.CommonTransportResponse;
import io.github.alexengrigup.mapstruct.spring.demo.payload.PersonalTransportResponse;
import io.github.alexengrigup.mapstruct.spring.demo.payload.TransportResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

@SpringBootTest
class TransportResponseMapperTest {
    @Test
    void should_map_common(@Autowired TransportResponseMapper mapper) {
        CommonTransport domain = CommonTransport.builder()
                .id(UUID.randomUUID())
                .name("Test-common")
                .code("123")
                .build();
        TransportResponse response = mapper.mapDomainToResponse(domain);
        assertInstanceOf(CommonTransportResponse.class, response);
        CommonTransportResponse commonResponse = (CommonTransportResponse) response;
        assertEquals(domain.getId(), commonResponse.getId(), "Id");
        assertEquals(domain.getName(), commonResponse.getName(), "Name");
        assertEquals(domain.getCode(), commonResponse.getCode(), "Code");
    }

    @Test
    void should_map_personal(@Autowired TransportResponseMapper mapper) {
        PersonalTransport domain = PersonalTransport.builder()
                .id(UUID.randomUUID())
                .name("Test-personal")
                .owner(User.builder()
                        .id(UUID.randomUUID())
                        .name("Test-owner")
                        .build())
                .build();
        TransportResponse response = mapper.mapDomainToResponse(domain);
        assertInstanceOf(PersonalTransportResponse.class, response);
        PersonalTransportResponse personalResponse = (PersonalTransportResponse) response;
        assertEquals(domain.getId(), personalResponse.getId(), "Id");
        assertEquals(domain.getName(), personalResponse.getName(), "Name");
        assertEquals(domain.getOwner().getId(), personalResponse.getOwnerId(), "OwnerId");
    }
}
