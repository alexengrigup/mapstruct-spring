package io.github.alexengrigup.mapstruct.spring.demo.converter;

import org.springframework.core.convert.converter.Converter;

public interface UserDictionaryValueConverter extends Converter<Long, String> {
    @Override
    String convert(Long idForDictionary);
}
