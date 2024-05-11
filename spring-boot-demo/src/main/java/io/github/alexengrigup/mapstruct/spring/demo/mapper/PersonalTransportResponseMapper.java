package io.github.alexengrigup.mapstruct.spring.demo.mapper;

import io.github.alexengrigup.mapstruct.spring.config.SpringMapStructConfig;
import io.github.alexengrigup.mapstruct.spring.demo.domain.PersonalTransport;
import io.github.alexengrigup.mapstruct.spring.demo.payload.PersonalTransportResponse;
import io.github.alexengrigup.mapstruct.spring.mapper.ResponseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = SpringMapStructConfig.class)
public interface PersonalTransportResponseMapper extends ResponseMapper<PersonalTransport, PersonalTransportResponse> {
    @Override
    @Mapping(target = "ownerId", source = "owner.id")
    PersonalTransportResponse mapDomainToResponse(PersonalTransport personalTransport);
}
