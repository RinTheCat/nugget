--liquibase formatted sql

--changeset RinTheCat:create_tables
create schema if not exists account;

create table account.account
(
    id uuid NOT NULL constraint account_primary_key primary key,
    contract_number character varying(60),
    active boolean,
    service_type character varying(15),
    owner_type character varying(15),
    owner_id uuid,
    last_modified_date timestamp with time zone NOT NULL
);


--rollback drop table if exists account.account cascade;