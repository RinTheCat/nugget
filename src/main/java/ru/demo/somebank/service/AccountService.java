package ru.demo.somebank.service;

import ru.demo.api.CreateAccountRequest;
import ru.demo.somebank.dto.AccountDto;

import java.util.UUID;

public interface AccountService {

    AccountDto createAccount(CreateAccountRequest request);

    AccountDto getAccount(UUID id);
}
