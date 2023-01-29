package dev.alexengrig.mapstruct.spring.mapper;

import dev.alexengrig.mapstruct.spring.config.SpringMapStructConfig;
import dev.alexengrig.mapstruct.spring.domain.MyDomain;
import dev.alexengrig.mapstruct.spring.dto.MyDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = SpringMapStructConfig.class)
interface MySimpleMapper extends SimpleMapper<MyDto, MyDomain> {

    @Mapping(target = "size", expression = "java(myDto.getValue() != null ? myDto.getValue().length() : -1)")
    @Mapping(target = "archived", constant = "false")
    @Override
    MyDomain map(MyDto myDto);

}
