package dev.alexengrig.mapstruct.spring.demo.configuration;

import dev.alexengrig.mapstruct.spring.demo.converter.FakeUserIdConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConverterConfig {
    @Bean
    public FakeUserIdConverter fakeUserIdConverter() {
        return new FakeUserIdConverter("Fake-user");
    }
}
