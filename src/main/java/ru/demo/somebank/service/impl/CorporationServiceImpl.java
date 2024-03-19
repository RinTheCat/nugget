package ru.demo.somebank.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.demo.somebank.domain.corporation.Corporation;
import ru.demo.somebank.dto.CorporationDto;
import ru.demo.somebank.exception.DataNotFoundException;
import ru.demo.somebank.mapper.CorporationMapper;
import ru.demo.somebank.repository.corporation.CorporationRepository;
import ru.demo.somebank.service.CorporationService;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CorporationServiceImpl implements CorporationService {
    private final CorporationRepository repository;
    private final CorporationMapper mapper;

    @Override
    public CorporationDto getCorporation(UUID id) {
        final Optional<Corporation> corporationOpt = repository.findById(id);
        final Corporation corporation = corporationOpt.orElseThrow(DataNotFoundException::new);
        return mapper.toDto(corporation);
    }
}
