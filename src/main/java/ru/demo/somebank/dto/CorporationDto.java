package ru.demo.somebank.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import ru.demo.somebank.domain.OwnerType;
import ru.demo.somebank.domain.ServiceType;

import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class CorporationDto {

    UUID id;

    String name;

    Boolean inn;

}
