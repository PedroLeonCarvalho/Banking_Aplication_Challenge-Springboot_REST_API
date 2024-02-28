package com.desafio.PCPY.controller;

import com.desafio.PCPY.domain.transaction.Transaction;
import com.desafio.PCPY.dtos.TransactionDTO;
import com.desafio.PCPY.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Transaction> createTransaction (@RequestBody TransactionDTO data) throws Exception {
        Transaction newTransaction = transactionService.createTransaction(data);
    return new ResponseEntity<>(newTransaction, HttpStatus.OK);
    }


}
