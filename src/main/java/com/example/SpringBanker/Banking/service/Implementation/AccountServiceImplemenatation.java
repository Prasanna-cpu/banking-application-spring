package com.example.SpringBanker.Banking.service.Implementation;

import com.example.SpringBanker.Banking.Mapper.AccountMapper;
import com.example.SpringBanker.Banking.dto.Accountdto;
import com.example.SpringBanker.Banking.entity.Account;
import com.example.SpringBanker.Banking.repository.AccountRepository;
import com.example.SpringBanker.Banking.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


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
    public Accountdto deposit(Long id, Double Amount) {
        Account account=accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account does not exist"));
        double updatedBalance=account.getBalance()+Amount;
        account.setBalance(updatedBalance);
        Account savedAccount=accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);

    }


    @Override
    public Accountdto withdraw(Long id, Double Amount) {
        Account account=accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account does not exist"));

        if (account.getBalance()<Amount){
            throw new RuntimeException("Insufficient amount");
        }
        double upDatedBalance= account.getBalance()-Amount;
        account.setBalance(upDatedBalance);
        Account savedAccount=accountRepository.save(account);
        return  AccountMapper.mapToAccountDto(savedAccount);

    }

    @Override
    public List<Accountdto> getAllAccounts() {
        List<Account> AllAccounts = accountRepository.findAll();
        return AllAccounts.stream().map(AccountMapper::mapToAccountDto).toList();
    }

    @Override
    public void deleteAccount(Long id) {
        Account account=accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account does not exist"));
        accountRepository.deleteById(id);
    }

    ;


}
