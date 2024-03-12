package ru.demo.somebank.mapper;

import org.mapstruct.Mapper;
import ru.demo.somebank.domain.person.Group;
import ru.demo.somebank.domain.person.Person;
import ru.demo.somebank.dto.GroupDto;
import ru.demo.somebank.dto.PersonDto;

@Mapper(componentModel = "spring")
public interface GroupMapper {

    GroupDto toDto(Group entity);

    PersonDto toDto(Person entity);

}
