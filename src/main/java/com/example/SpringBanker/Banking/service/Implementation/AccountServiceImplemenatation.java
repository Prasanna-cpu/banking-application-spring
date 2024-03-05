package com.example.SpringBanker.Banking.service.Implementation;

import com.example.SpringBanker.Banking.Mapper.AccountMapper;
import com.example.SpringBanker.Banking.dto.Accountdto;
import com.example.SpringBanker.Banking.entity.Account;
import com.example.SpringBanker.Banking.repository.AccountRepository;
import com.example.SpringBanker.Banking.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccountServiceImplemenatation implements AccountService {


    private final AccountRepository accountRepository;


    @Autowired
    public AccountServiceImplemenatation(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Accountdto createAccount(Accountdto accountdto) {
        Account account= AccountMapper.mapToAccount(accountdto);
        Account savedAccount=accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public Accountdto getAccountById(Long id) {
        Account account=accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account does not exist"));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public Accountdto getAccounts() {
        return null;
    }

    @Override
    public Accountdto updateAccountById(Long id) {
        return null;
    }

    @Override
    public Accountdto deleteAccountBtId(Long id) {
        return null;
    }


    ;


}
