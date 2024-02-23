--liquibase formatted sql

--changeset RinTheCat:create_tables
create schema if not exists company;

create table company.corporation
(
    id uuid NOT NULL constraint corporation_primary_key primary key,
    name character varying(255),
    inn character varying(12),
    last_modified_date timestamp with time zone NOT NULL
);

--rollback drop table if exists company.corporation cascade;