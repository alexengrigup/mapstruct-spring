package io.github.alexengrigup.mapstruct.spring.demo.mapper;

import io.github.alexengrigup.mapstruct.spring.config.SpringMapStructConfig;
import io.github.alexengrigup.mapstruct.spring.demo.domain.CreatingCommonTransport;
import io.github.alexengrigup.mapstruct.spring.demo.domain.CreatingPersonalTransport;
import io.github.alexengrigup.mapstruct.spring.demo.domain.CreatingTransport;
import io.github.alexengrigup.mapstruct.spring.demo.payload.CreatingCommonTransportRequest;
import io.github.alexengrigup.mapstruct.spring.demo.payload.CreatingPersonalTransportRequest;
import io.github.alexengrigup.mapstruct.spring.demo.payload.CreatingTransportRequest;
import io.github.alexengrigup.mapstruct.spring.mapper.RequestMapper;
import org.mapstruct.Mapper;
import org.mapstruct.SubclassMapping;

@Mapper(config = SpringMapStructConfig.class, uses = {
        CreatingCommonTransportRequestMapper.class,
        CreatingPersonalTransportRequestMapper.class
})
public interface CreatingTransportRequestMapper extends RequestMapper<CreatingTransportRequest, CreatingTransport> {
    @Override
    @SubclassMapping(target = CreatingCommonTransport.class, source = CreatingCommonTransportRequest.class)
    @SubclassMapping(target = CreatingPersonalTransport.class, source = CreatingPersonalTransportRequest.class)
    CreatingTransport mapRequestToDomain(CreatingTransportRequest creatingTransportRequest);
}
