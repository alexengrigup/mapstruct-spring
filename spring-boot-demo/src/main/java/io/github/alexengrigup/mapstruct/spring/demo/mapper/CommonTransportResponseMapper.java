package io.github.alexengrigup.mapstruct.spring.demo.mapper;

import io.github.alexengrigup.mapstruct.spring.config.SpringMapStructConfig;
import io.github.alexengrigup.mapstruct.spring.demo.domain.CommonTransport;
import io.github.alexengrigup.mapstruct.spring.demo.payload.CommonTransportResponse;
import io.github.alexengrigup.mapstruct.spring.mapper.ResponseMapper;
import org.mapstruct.Mapper;

@Mapper(config = SpringMapStructConfig.class)
public interface CommonTransportResponseMapper extends ResponseMapper<CommonTransport, CommonTransportResponse> {
    @Override
    CommonTransportResponse mapDomainToResponse(CommonTransport commonTransport);
}
