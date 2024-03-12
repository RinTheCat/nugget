package ru.demo.somebank.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.demo.api.CreateAccountRequest;
import ru.demo.somebank.dto.AccountDto;
import ru.demo.somebank.service.AccountService;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/api/account/{id}")
    @ResponseBody
    public AccountDto getAccount(@PathVariable UUID id) {
        return accountService.getAccount(id);
    }

    @PostMapping("/api/account")
    public ResponseEntity<AccountDto> createNewAccount(@Valid @RequestBody CreateAccountRequest request) {
        return new ResponseEntity<>(accountService.createAccount(request), HttpStatus.CREATED);
    }
}
