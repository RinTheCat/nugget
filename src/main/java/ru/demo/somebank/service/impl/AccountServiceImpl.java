package ru.demo.somebank.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.demo.api.CreateAccountRequest;
import ru.demo.somebank.domain.account.Account;
import ru.demo.somebank.domain.OwnerType;
import ru.demo.somebank.domain.ServiceType;
import ru.demo.somebank.dto.AccountDto;
import ru.demo.somebank.exception.DataNotFoundException;
import ru.demo.somebank.mapper.AccountMapper;
import ru.demo.somebank.repository.account.AccountRepository;
import ru.demo.somebank.service.AccountService;
import ru.demo.somebank.service.CorporationService;
import ru.demo.somebank.service.GroupService;
import ru.demo.somebank.service.IPService;
import ru.demo.somebank.service.PersonService;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountMapper mapper;
    private final IPService ipService;
    private final GroupService groupService;
    private final PersonService personService;
    private final AccountRepository accountRepository;
    private final CorporationService corporationService;

    @Override
    public AccountDto createAccount(CreateAccountRequest request) {
        checkExistence(request.getOwnerId(), request.getTypeOfOwner().value());

        Account account = Account.builder()
                .number(request.getNumber())
                .isActive(false)
                .serviceType(ServiceType.valueOf(request.getTypeOfService().value()))
                .ownerType(OwnerType.valueOf(request.getTypeOfOwner().value()))
                .owner(request.getOwnerId())
                .build();
        account = accountRepository.save(account);

        return mapper.toDto(account);
    }

    @Override
    public AccountDto getAccount(UUID id) {
        final Optional<Account> accountOpt = accountRepository.findById(id);
        final Account account = accountOpt.orElseThrow(DataNotFoundException::new);
        return mapper.toDto(account);
    }

    private void checkExistence(UUID id, String ownerType) {
        final OwnerType type = OwnerType.valueOf(ownerType);
        switch (type) {
            case IP:
                ipService.getIP(id);
                break;
            case GROUP:
                groupService.getGroup(id);
                break;
            case PERSON:
                personService.getPerson(id);
                break;
            case CORPORATION:
                corporationService.getCorporation(id);
                break;
            default:
                throw new DataNotFoundException();
        }
    }
}
