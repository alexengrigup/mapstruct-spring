package io.github.alexengrigup.mapstruct.spring.demo.mapper;

import io.github.alexengrigup.mapstruct.spring.config.SpringMapStructConfig;
import io.github.alexengrigup.mapstruct.spring.demo.domain.User;
import io.github.alexengrigup.mapstruct.spring.demo.dto.UserDto;
import io.github.alexengrigup.mapstruct.spring.mapper.ResponseMapper;
import org.mapstruct.Mapper;

@Mapper(config = SpringMapStructConfig.class)
public interface UserResponseMapper extends ResponseMapper<User, UserDto> {

    @Override
    UserDto mapDomainToResponse(User user);

}
