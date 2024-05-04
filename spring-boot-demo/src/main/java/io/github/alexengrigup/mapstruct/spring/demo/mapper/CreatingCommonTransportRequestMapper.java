package io.github.alexengrigup.mapstruct.spring.demo.mapper;

import io.github.alexengrigup.mapstruct.spring.config.SpringMapStructConfig;
import io.github.alexengrigup.mapstruct.spring.demo.domain.CreatingCommonTransport;
import io.github.alexengrigup.mapstruct.spring.demo.payload.CreatingCommonTransportRequest;
import io.github.alexengrigup.mapstruct.spring.mapper.RequestMapper;
import org.mapstruct.Mapper;

@Mapper(config = SpringMapStructConfig.class)
public interface CreatingCommonTransportRequestMapper
        extends RequestMapper<CreatingCommonTransportRequest, CreatingCommonTransport> {
    @Override
    CreatingCommonTransport mapRequestToDomain(CreatingCommonTransportRequest creatingCommonTransportRequest);
}
