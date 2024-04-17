package io.github.alexengrigup.mapstruct.spring.demo.mapper;

import io.github.alexengrigup.mapstruct.spring.config.SpringMapStructConfig;
import io.github.alexengrigup.mapstruct.spring.demo.converter.UserIdConverter;
import io.github.alexengrigup.mapstruct.spring.demo.domain.PersonalTransport;
import io.github.alexengrigup.mapstruct.spring.demo.dto.PersonalTransportRequest;
import io.github.alexengrigup.mapstruct.spring.mapper.RequestMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = SpringMapStructConfig.class, uses = UserIdConverter.class)
public interface PersonalTransportRequestMapper
        extends RequestMapper<PersonalTransportRequest, PersonalTransport> {

    @Mapping(target = "owner", source = "ownerId")
    @Override
    PersonalTransport mapRequestToDomain(PersonalTransportRequest personalTransportRequest);

}
