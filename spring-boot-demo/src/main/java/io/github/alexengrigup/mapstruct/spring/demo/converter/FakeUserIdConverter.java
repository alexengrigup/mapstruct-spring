package io.github.alexengrigup.mapstruct.spring.demo.converter;

import io.github.alexengrigup.mapstruct.spring.demo.domain.User;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FakeUserIdConverter implements UserIdConverter {
    private final String fakeUsername;

    @Override
    public User convert(Long source) {
//        return UserService.findById(source.getId());
        return User.builder()
                .id(source)
                .username(fakeUsername)
                .build();
    }
}
