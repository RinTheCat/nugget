package ru.demo.somebank.repository.person;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.demo.somebank.domain.person.Person;

import java.util.UUID;

public interface PersonRepository extends JpaRepository<Person, UUID> {
}
