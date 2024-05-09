package io.github.alexengrigup.mapstruct.spring.demo.mapper;

import io.github.alexengrigup.mapstruct.spring.demo.domain.CreatingCommonTransport;
import io.github.alexengrigup.mapstruct.spring.demo.domain.CreatingPersonalTransport;
import io.github.alexengrigup.mapstruct.spring.demo.domain.CreatingTransport;
import io.github.alexengrigup.mapstruct.spring.demo.payload.CreatingCommonTransportRequest;
import io.github.alexengrigup.mapstruct.spring.demo.payload.CreatingPersonalTransportRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

@SpringBootTest
class CreatingTransportRequestMapperTest {
    @Test
    void should_map_common(@Autowired CreatingTransportRequestMapper mapper) {
        CreatingCommonTransportRequest request = CreatingCommonTransportRequest.builder()
                .name("Test-common")
                .code("123")
                .build();
        CreatingTransport domain = mapper.mapRequestToDomain(request);
        assertInstanceOf(CreatingCommonTransport.class, domain);
        CreatingCommonTransport commonDomain = (CreatingCommonTransport) domain;
        assertEquals(request.getName(), commonDomain.getName(), "Name");
        assertEquals(request.getCode(), commonDomain.getCode(), "Code");
    }

    @Test
    void should_map_personal(@Autowired CreatingTransportRequestMapper mapper) {
        CreatingPersonalTransportRequest request = CreatingPersonalTransportRequest.builder()
                .name("Test-personal")
                .ownerId(UUID.randomUUID())
                .build();
        CreatingTransport domain = mapper.mapRequestToDomain(request);
        assertInstanceOf(CreatingPersonalTransport.class, domain);
        CreatingPersonalTransport personalDomain = (CreatingPersonalTransport) domain;
        assertEquals(request.getName(), personalDomain.getName(), "Name");
        assertEquals(request.getOwnerId(), personalDomain.getOwnerId(), "Code");
    }
}
