package dev.alexengrig.mapstruct.spring.demo.mapper;

import dev.alexengrig.mapstruct.spring.config.SpringMapStructConfig;
import dev.alexengrig.mapstruct.spring.demo.converter.UserIdConverter;
import dev.alexengrig.mapstruct.spring.demo.domain.PersonalTransport;
import dev.alexengrig.mapstruct.spring.demo.dto.PersonalTransportRequest;
import dev.alexengrig.mapstruct.spring.mapper.RequestMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = SpringMapStructConfig.class, uses = UserIdConverter.class)
public interface PersonalTransportRequestMapper
        extends RequestMapper<PersonalTransportRequest, PersonalTransport> {

    @Mapping(target = "owner", source = "ownerId")
    @Override
    PersonalTransport mapRequestToDomain(PersonalTransportRequest personalTransportRequest);

}
