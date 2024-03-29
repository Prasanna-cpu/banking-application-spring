package com.example.SpringBanker.Banking.Controller;


import com.example.SpringBanker.Banking.dto.Accountdto;

import com.example.SpringBanker.Banking.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private final AccountService accountService;


    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    @PostMapping
    public ResponseEntity<Accountdto> addAccount(@RequestBody Accountdto accountdto){
        return new ResponseEntity<>(accountService.createAccount(accountdto), HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Accountdto> getAccountById(@PathVariable Long id){
        Accountdto accountDto=accountService.getAccountById(id);
        return ResponseEntity.ok(accountDto);
    }



    @PutMapping("/{id}/deposit")
    public ResponseEntity<Accountdto> depsoit(@PathVariable Long id, @RequestBody Map<String,Double> request){
        Double amount=request.get("amount");
        Accountdto accountDto=accountService.deposit(id,amount);
        return ResponseEntity.ok(accountDto);
    }

    @PutMapping("/{id}/withdraw")
    public ResponseEntity<Accountdto> withdraw(@PathVariable Long id, @RequestBody Map<String,Double> request){
        Double amount=request.get("amount");
        Accountdto accountDto=accountService.deposit(id,amount);
        return ResponseEntity.ok(accountDto);
    }

    @GetMapping
    public ResponseEntity<List<Accountdto>> getAllAccounts(){
        List<Accountdto> accounts=accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAccount(Long id){
        try{
            accountService.deleteAccount(id);
        }

        catch(Exception e){
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }

        return ResponseEntity.ok("Record deleted");

    }
}
