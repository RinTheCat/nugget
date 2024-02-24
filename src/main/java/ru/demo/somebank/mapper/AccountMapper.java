package ru.demo.somebank.mapper;

import org.mapstruct.Mapper;
import ru.demo.somebank.domain.account.Account;
import ru.demo.somebank.dto.AccountDto;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    AccountDto toDto(Account entity);

}
