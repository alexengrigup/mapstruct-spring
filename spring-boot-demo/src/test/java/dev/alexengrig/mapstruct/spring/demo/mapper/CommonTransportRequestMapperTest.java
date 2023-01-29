package dev.alexengrig.mapstruct.spring.demo.mapper;

import dev.alexengrig.mapstruct.spring.demo.domain.CommonTransport;
import dev.alexengrig.mapstruct.spring.demo.dto.CommonTransportRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CommonTransportRequestMapperTest {

    static CommonTransportRequest createRequest() {
        return CommonTransportRequest.builder()
                .id(1L)
                .name("Test-name")
                .type("COMMON")
                .code("121E")
                .build();
    }

    static void assertDomain(CommonTransportRequest request, CommonTransport domain) {
        assertEquals(request.getId(), domain.getId(), "Id");
        assertEquals(request.getName(), domain.getName(), "Name");
        assertEquals(request.getCode(), domain.getCode(), "Code");
    }

    @Test
    void should_map(@Autowired CommonTransportRequestMapper mapper) {
        CommonTransportRequest request = createRequest();
        CommonTransport domain = mapper.mapRequestToDomain(request);
        assertDomain(request, domain);
    }
}