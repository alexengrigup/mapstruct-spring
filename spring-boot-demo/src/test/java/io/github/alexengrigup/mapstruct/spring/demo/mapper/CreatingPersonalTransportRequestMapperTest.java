package io.github.alexengrigup.mapstruct.spring.demo.mapper;

import io.github.alexengrigup.mapstruct.spring.demo.domain.CreatingPersonalTransport;
import io.github.alexengrigup.mapstruct.spring.demo.payload.CreatingPersonalTransportRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CreatingPersonalTransportRequestMapperTest {
    @Test
    void should_map(@Autowired CreatingPersonalTransportRequestMapper mapper) {
        CreatingPersonalTransportRequest request = CreatingPersonalTransportRequest.builder()
                .name("Test-personal")
                .ownerId(UUID.randomUUID())
                .build();
        CreatingPersonalTransport domain = mapper.mapRequestToDomain(request);
        assertEquals(request.getName(), domain.getName(), "Name");
        assertEquals(request.getOwnerId(), domain.getOwnerId(), "Code");
    }
}