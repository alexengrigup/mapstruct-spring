package dev.alexengrig.mapstruct.spring.demo;

import dev.alexengrig.mapstruct.spring.demo.domain.BaseTransport;
import dev.alexengrig.mapstruct.spring.demo.domain.User;
import dev.alexengrig.mapstruct.spring.demo.dto.PersonalTransportRequest;
import dev.alexengrig.mapstruct.spring.demo.dto.UserDto;
import dev.alexengrig.mapstruct.spring.demo.mapper.BaseTransportRequestMapper;
import dev.alexengrig.mapstruct.spring.demo.mapper.UserResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    UserResponseMapper userResponseMapper;
    @Autowired
    BaseTransportRequestMapper transportRequestMapper;

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
