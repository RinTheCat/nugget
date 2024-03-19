package ru.demo.somebank.service;

import ru.demo.somebank.dto.PersonDto;

import java.util.UUID;

public interface PersonService {

    PersonDto getPerson(UUID id);
}
