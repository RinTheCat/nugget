package ru.demo.somebank.domain;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(schema = "company", name = "corporation")
public class Corporation {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "org.hibernate.id.UUIDGenerator")
    UUID id;

    @Column(name = "name")
    String name;

    @Column(name = "inn")
    String inn;

}
