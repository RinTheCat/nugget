package ru.demo.somebank.domain.person;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import ru.demo.somebank.domain.GroupType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.UUID;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(schema = "person", name = "group")
public class Group {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "org.hibernate.id.UUIDGenerator")
    UUID id;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    GroupType type;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "groups_and_people",
        joinColumns = {
            @JoinColumn(name = "group_id", referencedColumnName = "id",
                nullable = false, updatable = false)},
        inverseJoinColumns = {
            @JoinColumn(name = "person_id", referencedColumnName = "id",
                nullable = false, updatable = false)})
    List<Person> members;
}
