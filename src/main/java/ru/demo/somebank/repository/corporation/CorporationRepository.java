package ru.demo.somebank.repository.corporation;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.demo.somebank.domain.corporation.Corporation;

import java.util.UUID;

public interface CorporationRepository extends JpaRepository<Corporation, UUID> {
}
