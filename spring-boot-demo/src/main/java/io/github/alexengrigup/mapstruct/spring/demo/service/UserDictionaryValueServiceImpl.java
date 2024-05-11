package io.github.alexengrigup.mapstruct.spring.demo.service;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserDictionaryValueServiceImpl implements UserDictionaryValueService {
    private final Map<Long, String> dictionary = Map.of(
            1L, "First",
            2L, "Second",
            3L, "Third"
    );

    @Override
    public String getById(Long id) {
        return dictionary.getOrDefault(id, "None");
    }
}
