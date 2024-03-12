package ru.demo.somebank.service;

import ru.demo.somebank.dto.IPDto;

import java.util.UUID;

public interface IPService {

    IPDto getIP(UUID id);
}
