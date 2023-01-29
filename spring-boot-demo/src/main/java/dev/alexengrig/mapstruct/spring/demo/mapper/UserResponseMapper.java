package dev.alexengrig.mapstruct.spring.demo.mapper;

import dev.alexengrig.mapstruct.spring.config.SpringMapStructConfig;
import dev.alexengrig.mapstruct.spring.demo.domain.User;
import dev.alexengrig.mapstruct.spring.demo.dto.UserDto;
import dev.alexengrig.mapstruct.spring.mapper.ResponseMapper;
import org.mapstruct.Mapper;

@Mapper(config = SpringMapStructConfig.class)
public interface UserResponseMapper extends ResponseMapper<User, UserDto> {

    @Override
    UserDto mapDomainToResponse(User user);

}
