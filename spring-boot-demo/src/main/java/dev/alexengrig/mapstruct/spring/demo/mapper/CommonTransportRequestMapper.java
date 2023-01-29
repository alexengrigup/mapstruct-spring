package dev.alexengrig.mapstruct.spring.demo.mapper;

import dev.alexengrig.mapstruct.spring.config.SpringMapStructConfig;
import dev.alexengrig.mapstruct.spring.demo.domain.CommonTransport;
import dev.alexengrig.mapstruct.spring.demo.dto.CommonTransportRequest;
import dev.alexengrig.mapstruct.spring.mapper.RequestMapper;
import org.mapstruct.Mapper;

@Mapper(config = SpringMapStructConfig.class)
public interface CommonTransportRequestMapper
        extends RequestMapper<CommonTransportRequest, CommonTransport> {

    @Override
    CommonTransport mapRequestToDomain(CommonTransportRequest request);

}
