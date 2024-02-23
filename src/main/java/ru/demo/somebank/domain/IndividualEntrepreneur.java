package ru.demo.somebank.domain;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(schema = "person", name = "ip")
public class IndividualEntrepreneur {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "org.hibernate.id.UUIDGenerator")
    UUID id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "person_id")
    Person person;

    @Column(name = "inn")
    String inn;
}
