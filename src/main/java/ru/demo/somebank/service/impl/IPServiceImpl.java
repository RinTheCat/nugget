package ru.demo.somebank.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.demo.somebank.domain.person.IndividualEntrepreneur;
import ru.demo.somebank.dto.IPDto;
import ru.demo.somebank.exception.DataNotFoundException;
import ru.demo.somebank.mapper.IPMapper;
import ru.demo.somebank.repository.person.IPRepository;
import ru.demo.somebank.service.IPService;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class IPServiceImpl implements IPService {
    private final IPRepository repository;
    private final IPMapper mapper;

    @Override
    public IPDto getIP(UUID id) {
        final Optional<IndividualEntrepreneur> ipOpt = repository.findById(id);
        final IndividualEntrepreneur ip = ipOpt.orElseThrow(DataNotFoundException::new);
        return mapper.toDto(ip);
    }
}
