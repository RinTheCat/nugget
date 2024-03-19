package ru.demo.somebank.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.demo.somebank.domain.person.Person;
import ru.demo.somebank.dto.PersonDto;
import ru.demo.somebank.exception.DataNotFoundException;
import ru.demo.somebank.mapper.PersonMapper;
import ru.demo.somebank.repository.person.PersonRepository;
import ru.demo.somebank.service.PersonService;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final PersonRepository repository;
    private final PersonMapper mapper;

    @Override
    public PersonDto getPerson(UUID id) {
        final Optional<Person> personOpt = repository.findById(id);
        final Person person = personOpt.orElseThrow(DataNotFoundException::new);
        return mapper.toDto(person);
    }
}
