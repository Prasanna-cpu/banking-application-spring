package com.example.SpringBanker.Banking.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Accountdto {
    private Long id;
    private String accountHolderName;

    private double balance;
}
