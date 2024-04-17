package io.github.alexengrigup.mapstruct.spring.mapper;

import io.github.alexengrigup.mapstruct.spring.domain.MyDomain;
import io.github.alexengrigup.mapstruct.spring.dto.MyDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest(classes = MapStructMySimpleMapper.class)
class MySimpleMapperTest {

    @Test
    void should_map_dto_to_domain(@Autowired MySimpleMapper mapper) {
        MyDto dto = MyDto.builder()
                .id(1L)
                .value("one")
                .build();
        MyDomain domain = mapper.map(dto);
        assertEquals(1L, domain.getId());
        assertEquals("one", domain.getValue());
        assertEquals(3, domain.getSize());
        assertFalse(domain.isArchived());
    }

}