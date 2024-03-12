package ru.demo.somebank.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.demo.somebank.domain.person.Group;
import ru.demo.somebank.dto.GroupDto;
import ru.demo.somebank.exception.DataNotFoundException;
import ru.demo.somebank.mapper.GroupMapper;
import ru.demo.somebank.repository.person.GroupRepository;
import ru.demo.somebank.service.GroupService;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {
    private final GroupRepository repository;
    private final GroupMapper mapper;

    @Override
    public GroupDto getGroup(UUID id) {
        final Optional<Group> groupOpt = repository.findById(id);
        final Group group = groupOpt.orElseThrow(DataNotFoundException::new);
        return mapper.toDto(group);
    }
}
