package ru.demo.somebank.mapper;

import org.mapstruct.Mapper;
import ru.demo.somebank.domain.corporation.Corporation;
import ru.demo.somebank.dto.CorporationDto;

@Mapper(componentModel = "spring")
public interface CorporationMapper {

    CorporationDto toDto(Corporation entity);

}
