package io.github.alexengrigup.mapstruct.spring.demo;

import io.github.alexengrigup.mapstruct.spring.demo.domain.BaseTransport;
import io.github.alexengrigup.mapstruct.spring.demo.domain.User;
import io.github.alexengrigup.mapstruct.spring.demo.dto.PersonalTransportRequest;
import io.github.alexengrigup.mapstruct.spring.demo.dto.UserDto;
import io.github.alexengrigup.mapstruct.spring.demo.mapper.BaseTransportRequestMapper;
import io.github.alexengrigup.mapstruct.spring.demo.mapper.UserResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class DemoApplication implements CommandLineRunner {

    private final UserResponseMapper userResponseMapper;
    private final BaseTransportRequestMapper transportRequestMapper;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) {
        User user = User.builder()
                .id(1L)
                .username("one")
                .build();
        System.out.println(user);
        UserDto dto = userResponseMapper.mapDomainToResponse(user);
        System.out.println(dto);

        PersonalTransportRequest request = PersonalTransportRequest.builder()
                .id(1L)
                .name("Car")
                .type("PERSONAL")
                .ownerId(1L)
                .build();
        System.out.println(request);
        BaseTransport domain = transportRequestMapper.mapRequestToDomain(request);
        System.out.println(domain);
    }

}
