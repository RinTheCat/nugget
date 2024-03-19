package ru.demo.somebank.repository.person;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.demo.somebank.domain.person.IndividualEntrepreneur;

import java.util.UUID;

public interface IPRepository extends JpaRepository<IndividualEntrepreneur, UUID> {
}
