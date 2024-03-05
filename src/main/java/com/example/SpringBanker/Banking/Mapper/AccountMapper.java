package com.example.SpringBanker.Banking.Mapper;

import com.example.SpringBanker.Banking.dto.Accountdto;
import com.example.SpringBanker.Banking.entity.Account;

public class AccountMapper {
    public static Account mapToAccount(Accountdto accountdto){
        return new Account(
                accountdto.getId(),
                accountdto.getAccountHolderName(),
                accountdto.getBalance()
        );

    }

    public static Accountdto mapToAccountDto(Account account){
        return new Accountdto(
                account.getId(),
                account.getAccountHolderName(),
                account.getBalance()
        );
    }
}
