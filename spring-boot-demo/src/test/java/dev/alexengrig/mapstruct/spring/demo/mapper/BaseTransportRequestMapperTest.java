package dev.alexengrig.mapstruct.spring.demo.mapper;

import dev.alexengrig.mapstruct.spring.demo.domain.BaseTransport;
import dev.alexengrig.mapstruct.spring.demo.domain.CommonTransport;
import dev.alexengrig.mapstruct.spring.demo.domain.PersonalTransport;
import dev.alexengrig.mapstruct.spring.demo.dto.CommonTransportRequest;
import dev.alexengrig.mapstruct.spring.demo.dto.PersonalTransportRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

@SpringBootTest
class BaseTransportRequestMapperTest {

    @Test
    void should_map_common(@Autowired BaseTransportRequestMapper mapper) {
        CommonTransportRequest request = CommonTransportRequestMapperTest.createRequest();
        BaseTransport domain = mapper.mapRequestToDomain(request);
        assertInstanceOf(CommonTransport.class, domain);
        CommonTransport commonDomain = (CommonTransport) domain;
        CommonTransportRequestMapperTest.assertDomain(request, commonDomain);
    }

    @Test
    void should_map_personal(@Autowired BaseTransportRequestMapper mapper) {
        PersonalTransportRequest request = PersonalTransportRequestMapperTest.createRequest();
        BaseTransport domain = mapper.mapRequestToDomain(request);
        assertInstanceOf(PersonalTransport.class, domain);
        PersonalTransport personalDomain = (PersonalTransport) domain;
        PersonalTransportRequestMapperTest.assertDomain(request, personalDomain);
    }

}