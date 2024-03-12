package ru.demo.somebank.mapper;

import org.mapstruct.Mapper;
import ru.demo.somebank.domain.person.Person;
import ru.demo.somebank.dto.PersonDto;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonDto toDto(Person entity);

}
