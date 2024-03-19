package ru.demo.somebank.domain.account;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import ru.demo.somebank.domain.OwnerType;
import ru.demo.somebank.domain.ServiceType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(schema = "account", name = "account")
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "org.hibernate.id.UUIDGenerator")
    UUID id;

    @Column(name = "contract_number")
    String number;

    @Column(name = "active")
    Boolean isActive;

    @Column(name = "service_type")
    @Enumerated(EnumType.STRING)
    ServiceType serviceType;

    @Column(name = "owner_type")
    @Enumerated(EnumType.STRING)
    OwnerType ownerType;

    // fixme
    // возможно стоило сделать общий класс для всех возможных владельцев (Corporation, IndividualEntrepreneur, Group, Person)
    // но при условии, что у нас сущности в разных БД могут быть, делать так не решилась
    @Column(name = "owner_id")
    UUID owner;

    @Column(name = "last_modified_date")
    ZonedDateTime lastModifiedDate;

    @PrePersist
    private void prePersist() {
        this.lastModifiedDate = ZonedDateTime.now();
    }
}
