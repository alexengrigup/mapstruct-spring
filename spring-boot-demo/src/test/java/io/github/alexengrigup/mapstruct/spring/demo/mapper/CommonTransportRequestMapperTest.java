package io.github.alexengrigup.mapstruct.spring.demo.mapper;

import io.github.alexengrigup.mapstruct.spring.demo.domain.CommonTransport;
import io.github.alexengrigup.mapstruct.spring.demo.dto.CommonTransportRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CommonTransportRequestMapperTest {
    @Test
    void should_map(@Autowired CommonTransportRequestMapper mapper) {
        CommonTransportRequest request = CommonTransportRequest.builder()
                .id(10L)
                .name("Test-name")
                .type("COMMON")
                .code("121E")
                .build();
        CommonTransport domain = mapper.mapRequestToDomain(request);
        assertEquals(request.getId(), domain.getId(), "Id");
        assertEquals(request.getName(), domain.getName(), "Name");
        assertEquals(request.getCode(), domain.getCode(), "Code");
    }
}