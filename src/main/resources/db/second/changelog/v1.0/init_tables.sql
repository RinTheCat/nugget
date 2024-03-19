--liquibase formatted sql

--changeset RinTheCat:create_tables
create schema if not exists person;

create table person.person
(
    id uuid NOT NULL constraint person_primary_key primary key,
    first_name character varying(100),
    last_name character varying(100),
    patronymic character varying(100),
    last_modified_date timestamp with time zone NOT NULL
);

create table person.ip
(
    id uuid NOT NULL constraint ip_primary_key primary key,
    person_id uuid NOT NULL,
    inn character varying(12),
    last_modified_date timestamp with time zone NOT NULL,
    constraint person_foreign_key foreign key (person_id) references person.person(id)
);

create table person.group
(
    id uuid NOT NULL constraint group_primary_key primary key,
    group_type character varying(100),
    last_modified_date timestamp with time zone NOT NULL
);

create table person.groups_and_people
(
    group_id uuid NOT NULL,
    person_id uuid NOT NULL,
    last_modified_date timestamp with time zone NOT NULL,
    constraint group_foreign_key foreign key (group_id) references person."group"(id),
    constraint person_foreign_key foreign key (person_id) references person.person(id),
    primary key (group_id, person_id)
);

--rollback drop table if exists person.person cascade;
--rollback drop table if exists person.ip cascade;
--rollback drop table if exists person.group cascade;
--rollback drop table if exists person.groups_and_people cascade;