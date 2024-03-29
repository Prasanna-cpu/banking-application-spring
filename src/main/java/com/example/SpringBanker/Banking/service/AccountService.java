package com.example.SpringBanker.Banking.service;
import java.util.List;
import com.example.SpringBanker.Banking.dto.Accountdto;

public interface AccountService {
      Accountdto createAccount(Accountdto accountdto);

      Accountdto getAccountById(Long id);

      Accountdto deposit(Long id,Double Amount);

      Accountdto withdraw(Long id,Double Amount);

      List<Accountdto> getAllAccounts();

      void deleteAccount(Long id);

}
