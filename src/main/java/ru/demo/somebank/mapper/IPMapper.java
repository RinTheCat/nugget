package ru.demo.somebank.mapper;

import org.mapstruct.Mapper;
import ru.demo.somebank.domain.person.IndividualEntrepreneur;
import ru.demo.somebank.dto.IPDto;

@Mapper(componentModel = "spring")
public interface IPMapper {

    IPDto toDto(IndividualEntrepreneur entity);

}
