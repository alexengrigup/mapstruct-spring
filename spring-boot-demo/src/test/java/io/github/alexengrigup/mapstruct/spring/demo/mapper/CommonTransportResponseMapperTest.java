package io.github.alexengrigup.mapstruct.spring.demo.mapper;

import io.github.alexengrigup.mapstruct.spring.demo.domain.CommonTransport;
import io.github.alexengrigup.mapstruct.spring.demo.payload.CommonTransportResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CommonTransportResponseMapperTest {
    @Test
    void should_map(@Autowired CommonTransportResponseMapper mapper) {
        CommonTransport domain = CommonTransport.builder()
                .id(UUID.randomUUID())
                .name("Test-common")
                .code("123")
                .build();
        CommonTransportResponse response = mapper.mapDomainToResponse(domain);
        assertEquals(domain.getId(), response.getId(), "Id");
        assertEquals(domain.getName(), response.getName(), "Name");
        assertEquals(domain.getCode(), response.getCode(), "Code");
    }
}