package io.github.alexengrigup.mapstruct.spring.demo.converter;

import io.github.alexengrigup.mapstruct.spring.demo.domain.User;
import org.springframework.core.convert.converter.Converter;

public interface UserIdConverter extends Converter<Long, User> {

    @Override
    User convert(Long source);

}
