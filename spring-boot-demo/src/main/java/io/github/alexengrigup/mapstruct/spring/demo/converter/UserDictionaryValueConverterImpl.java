package io.github.alexengrigup.mapstruct.spring.demo.converter;

import io.github.alexengrigup.mapstruct.spring.demo.service.UserDictionaryValueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDictionaryValueConverterImpl implements UserDictionaryValueConverter {
    private final UserDictionaryValueService userDictionaryValueService;

    @Override
    public String convert(Long idForDictionary) {
        return userDictionaryValueService.getById(idForDictionary);
    }
}
