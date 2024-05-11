package io.github.alexengrigup.mapstruct.spring.demo.mapper;

import io.github.alexengrigup.mapstruct.spring.config.SpringMapStructConfig;
import io.github.alexengrigup.mapstruct.spring.demo.converter.UserDictionaryValueConverter;
import io.github.alexengrigup.mapstruct.spring.demo.domain.User;
import io.github.alexengrigup.mapstruct.spring.demo.payload.UserResponse;
import io.github.alexengrigup.mapstruct.spring.mapper.ResponseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = SpringMapStructConfig.class, uses = UserDictionaryValueConverter.class)
public interface UserResponseMapper extends ResponseMapper<User, UserResponse> {
    @Override
    @Mapping(target = "valueFromDictionary", source = "idForDictionary")
    UserResponse mapDomainToResponse(User user);
}
