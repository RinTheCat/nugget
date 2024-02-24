package ru.demo.somebank.repository.person;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.demo.somebank.domain.person.Group;

import java.util.UUID;

public interface GroupRepository extends JpaRepository<Group, UUID> {
}
