package ru.demo.somebank.service;

import ru.demo.somebank.dto.GroupDto;

import java.util.UUID;

public interface GroupService {

    GroupDto getGroup(UUID id);
}
