package io.github.alexengrigup.mapstruct.spring.demo.mapper;

import io.github.alexengrigup.mapstruct.spring.demo.domain.CreatingCommonTransport;
import io.github.alexengrigup.mapstruct.spring.demo.payload.CreatingCommonTransportRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CreatingCommonTransportRequestMapperTest {
    @Test
    void should_map(@Autowired CreatingCommonTransportRequestMapper mapper) {
        CreatingCommonTransportRequest request = CreatingCommonTransportRequest.builder()
                .name("Test-common")
                .code("123")
                .build();
        CreatingCommonTransport domain = mapper.mapRequestToDomain(request);
        assertEquals(request.getName(), domain.getName(), "Name");
        assertEquals(request.getCode(), domain.getCode(), "Code");
    }
}