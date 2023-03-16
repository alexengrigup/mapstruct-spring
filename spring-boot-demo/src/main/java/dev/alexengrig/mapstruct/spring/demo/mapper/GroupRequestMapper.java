package dev.alexengrig.mapstruct.spring.demo.mapper;

import dev.alexengrig.mapstruct.spring.config.SpringMapStructConfig;
import dev.alexengrig.mapstruct.spring.demo.converter.UserIdConverter;
import dev.alexengrig.mapstruct.spring.demo.domain.Group;
import dev.alexengrig.mapstruct.spring.demo.dto.GroupDto;
import dev.alexengrig.mapstruct.spring.mapper.RequestMapper;
import org.mapstruct.Mapper;

@Mapper(config = SpringMapStructConfig.class, uses = UserIdConverter.class)
public interface GroupRequestMapper extends RequestMapper<GroupDto, Group> {

    @Override
    Group mapRequestToDomain(GroupDto groupDto);

}
