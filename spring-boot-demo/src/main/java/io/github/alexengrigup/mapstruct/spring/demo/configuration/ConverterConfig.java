package io.github.alexengrigup.mapstruct.spring.demo.configuration;

import io.github.alexengrigup.mapstruct.spring.demo.converter.FakeUserIdConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConverterConfig {
    @Bean
    public FakeUserIdConverter fakeUserIdConverter() {
        return new FakeUserIdConverter("Fake-user");
    }
}
