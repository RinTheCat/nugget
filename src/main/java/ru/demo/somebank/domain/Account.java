package ru.demo.somebank.domain;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(schema = "account", name = "account")
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

}
