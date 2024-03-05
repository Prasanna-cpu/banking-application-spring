package com.example.SpringBanker.Banking.Controller;


import com.example.SpringBanker.Banking.dto.Accountdto;
import com.example.SpringBanker.Banking.entity.Account;
import com.example.SpringBanker.Banking.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private AccountService accountService;


    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    @PostMapping
    public ResponseEntity<Accountdto> addAccount(@RequestBody Accountdto accountdto){
        return new ResponseEntity<>(accountService.createAccount(accountdto), HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<Accountdto> getAccountById(@RequestBody Long id){
        Accountdto accountDto=accountService.getAccountById(id);
        return ResponseEntity.ok(accountDto);
    }


}
