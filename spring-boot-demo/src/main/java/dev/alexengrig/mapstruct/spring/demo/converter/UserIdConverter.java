package dev.alexengrig.mapstruct.spring.demo.converter;

import dev.alexengrig.mapstruct.spring.demo.domain.User;
import org.springframework.core.convert.converter.Converter;

public interface UserIdConverter extends Converter<Long, User> {

    @Override
    User convert(Long source);

}
