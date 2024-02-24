package ru.demo.somebank.service;

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
import ru.demo.somebank.repository.corporation.CorporationRepository;
import ru.demo.somebank.repository.person.GroupRepository;
import ru.demo.somebank.repository.person.IPRepository;
import ru.demo.somebank.repository.person.PersonRepository;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountMapper mapper;
    private final IPRepository ipRepository;
    private final GroupRepository groupRepository;
    private final PersonRepository personRepository;
    private final AccountRepository accountRepository;
    private final CorporationRepository corporationRepository;

    @Override
    public AccountDto createAccount(CreateAccountRequest request) {
        final boolean exists = checkIfExists(request.getOwnerId(), request.getTypeOfOwner().value());

        if (!exists) throw new DataNotFoundException();

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

    private boolean checkIfExists(UUID id, String ownerType) {
        final OwnerType type = OwnerType.valueOf(ownerType);
        switch (type) {
            case IP:
                return ipRepository.findById(id).isPresent();
            case GROUP:
                return groupRepository.findById(id).isPresent();
            case PERSON:
                return personRepository.findById(id).isPresent();
            case CORPORATION:
                return corporationRepository.findById(id).isPresent();
            default:
                return false;
        }
    }
}
