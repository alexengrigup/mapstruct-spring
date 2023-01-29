package dev.alexengrig.mapstruct.spring.demo.mapper;

import dev.alexengrig.mapstruct.spring.config.SpringMapStructConfig;
import dev.alexengrig.mapstruct.spring.demo.domain.PersonalTransport;
import dev.alexengrig.mapstruct.spring.demo.dto.PersonalTransportRequest;
import dev.alexengrig.mapstruct.spring.mapper.RequestMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = SpringMapStructConfig.class)
public interface PersonalTransportRequestMapper
        extends RequestMapper<PersonalTransportRequest, PersonalTransport> {

    @Mapping(target = "owner", ignore = true)
    @Mapping(target = "owner.id", source = "ownerId")
    @Override
    PersonalTransport mapRequestToDomain(PersonalTransportRequest personalTransportRequest);

}
