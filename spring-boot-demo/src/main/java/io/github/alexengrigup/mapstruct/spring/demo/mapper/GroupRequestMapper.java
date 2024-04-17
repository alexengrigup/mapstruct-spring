package io.github.alexengrigup.mapstruct.spring.demo.mapper;

import io.github.alexengrigup.mapstruct.spring.config.SpringMapStructConfig;
import io.github.alexengrigup.mapstruct.spring.demo.converter.UserIdConverter;
import io.github.alexengrigup.mapstruct.spring.demo.domain.Group;
import io.github.alexengrigup.mapstruct.spring.demo.dto.GroupDto;
import io.github.alexengrigup.mapstruct.spring.mapper.RequestMapper;
import org.mapstruct.Mapper;

@Mapper(config = SpringMapStructConfig.class, uses = UserIdConverter.class)
public interface GroupRequestMapper extends RequestMapper<GroupDto, Group> {

    @Override
    Group mapRequestToDomain(GroupDto groupDto);

}
