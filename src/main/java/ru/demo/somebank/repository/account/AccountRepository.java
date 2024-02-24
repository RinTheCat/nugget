package ru.demo.somebank.repository.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.demo.somebank.domain.account.Account;

import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID> {

    @Transactional
    Account save(Account account);
}
