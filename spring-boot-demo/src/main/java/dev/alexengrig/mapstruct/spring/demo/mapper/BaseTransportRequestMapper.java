package dev.alexengrig.mapstruct.spring.demo.mapper;

import dev.alexengrig.mapstruct.spring.config.SpringMapStructConfig;
import dev.alexengrig.mapstruct.spring.demo.domain.BaseTransport;
import dev.alexengrig.mapstruct.spring.demo.domain.CommonTransport;
import dev.alexengrig.mapstruct.spring.demo.domain.PersonalTransport;
import dev.alexengrig.mapstruct.spring.demo.dto.BaseTransportRequest;
import dev.alexengrig.mapstruct.spring.demo.dto.CommonTransportRequest;
import dev.alexengrig.mapstruct.spring.demo.dto.PersonalTransportRequest;
import dev.alexengrig.mapstruct.spring.mapper.RequestMapper;
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
