package io.github.alexengrigup.mapstruct.spring.demo.mapper;

import io.github.alexengrigup.mapstruct.spring.config.SpringMapStructConfig;
import io.github.alexengrigup.mapstruct.spring.demo.domain.CreatingPersonalTransport;
import io.github.alexengrigup.mapstruct.spring.demo.payload.CreatingPersonalTransportRequest;
import io.github.alexengrigup.mapstruct.spring.mapper.RequestMapper;
import org.mapstruct.Mapper;

@Mapper(config = SpringMapStructConfig.class)
public interface CreatingPersonalTransportRequestMapper
        extends RequestMapper<CreatingPersonalTransportRequest, CreatingPersonalTransport> {
    @Override
    CreatingPersonalTransport mapRequestToDomain(CreatingPersonalTransportRequest creatingPersonalTransportRequest);
}
