package io.github.alexengrigup.mapstruct.spring.demo.mapper;

import io.github.alexengrigup.mapstruct.spring.config.SpringMapStructConfig;
import io.github.alexengrigup.mapstruct.spring.demo.domain.CommonTransport;
import io.github.alexengrigup.mapstruct.spring.demo.domain.PersonalTransport;
import io.github.alexengrigup.mapstruct.spring.demo.domain.Transport;
import io.github.alexengrigup.mapstruct.spring.demo.payload.CommonTransportResponse;
import io.github.alexengrigup.mapstruct.spring.demo.payload.PersonalTransportResponse;
import io.github.alexengrigup.mapstruct.spring.demo.payload.TransportResponse;
import io.github.alexengrigup.mapstruct.spring.mapper.ResponseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.SubclassMapping;

@Mapper(config = SpringMapStructConfig.class, uses = {
        CommonTransportResponseMapper.class,
        PersonalTransportResponseMapper.class
})
public interface TransportResponseMapper extends ResponseMapper<Transport, TransportResponse> {
    @Override
    @SubclassMapping(target = CommonTransportResponse.class, source = CommonTransport.class)
    @SubclassMapping(target = PersonalTransportResponse.class, source = PersonalTransport.class)
    TransportResponse mapDomainToResponse(Transport transport);
}
