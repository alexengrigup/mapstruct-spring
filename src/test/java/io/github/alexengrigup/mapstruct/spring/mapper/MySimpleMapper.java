package io.github.alexengrigup.mapstruct.spring.mapper;

import io.github.alexengrigup.mapstruct.spring.config.SpringMapStructConfig;
import io.github.alexengrigup.mapstruct.spring.domain.MyDomain;
import io.github.alexengrigup.mapstruct.spring.dto.MyDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = SpringMapStructConfig.class)
interface MySimpleMapper extends SimpleMapper<MyDto, MyDomain> {

    @Mapping(target = "size", expression = "java(myDto.getValue() != null ? myDto.getValue().length() : -1)")
    @Mapping(target = "archived", constant = "false")
    @Override
    MyDomain map(MyDto myDto);

}
