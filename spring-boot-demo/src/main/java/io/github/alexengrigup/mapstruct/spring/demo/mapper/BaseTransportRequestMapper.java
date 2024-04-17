package io.github.alexengrigup.mapstruct.spring.demo.mapper;

import io.github.alexengrigup.mapstruct.spring.config.SpringMapStructConfig;
import io.github.alexengrigup.mapstruct.spring.demo.domain.BaseTransport;
import io.github.alexengrigup.mapstruct.spring.demo.domain.CommonTransport;
import io.github.alexengrigup.mapstruct.spring.demo.domain.PersonalTransport;
import io.github.alexengrigup.mapstruct.spring.demo.dto.BaseTransportRequest;
import io.github.alexengrigup.mapstruct.spring.demo.dto.CommonTransportRequest;
import io.github.alexengrigup.mapstruct.spring.demo.dto.PersonalTransportRequest;
import io.github.alexengrigup.mapstruct.spring.mapper.RequestMapper;
import org.mapstruct.Mapper;
import org.mapstruct.SubclassMapping;

@Mapper(
        config = SpringMapStructConfig.class,
        uses = {
                CommonTransportRequestMapper.class,
                PersonalTransportRequestMapper.class
        }
)
public interface BaseTransportRequestMapper
        extends RequestMapper<BaseTransportRequest, BaseTransport> {

    @SubclassMapping(target = CommonTransport.class, source = CommonTransportRequest.class)
    @SubclassMapping(target = PersonalTransport.class, source = PersonalTransportRequest.class)
    @Override
    BaseTransport mapRequestToDomain(BaseTransportRequest baseTransportRequest);

}
