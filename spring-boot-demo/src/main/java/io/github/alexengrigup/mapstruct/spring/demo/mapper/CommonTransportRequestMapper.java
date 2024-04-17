package io.github.alexengrigup.mapstruct.spring.demo.mapper;

import io.github.alexengrigup.mapstruct.spring.config.SpringMapStructConfig;
import io.github.alexengrigup.mapstruct.spring.demo.domain.CommonTransport;
import io.github.alexengrigup.mapstruct.spring.demo.dto.CommonTransportRequest;
import io.github.alexengrigup.mapstruct.spring.mapper.RequestMapper;
import org.mapstruct.Mapper;

@Mapper(config = SpringMapStructConfig.class)
public interface CommonTransportRequestMapper
        extends RequestMapper<CommonTransportRequest, CommonTransport> {

    @Override
    CommonTransport mapRequestToDomain(CommonTransportRequest request);

}
