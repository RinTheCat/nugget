package ru.demo.somebank.service;

import ru.demo.somebank.dto.CorporationDto;

import java.util.UUID;

public interface CorporationService {

    CorporationDto getCorporation(UUID id);
}
