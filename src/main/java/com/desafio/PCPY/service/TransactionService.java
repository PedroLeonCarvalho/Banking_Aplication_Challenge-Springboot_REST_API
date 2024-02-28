package com.desafio.PCPY.service;

import com.desafio.PCPY.domain.transaction.Transaction;
import com.desafio.PCPY.domain.transaction.TransactionRepository;
import com.desafio.PCPY.domain.users.User;
import com.desafio.PCPY.dtos.TransactionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

@Service
public class TransactionService {

    @Autowired
    private UserService userService;

    @Autowired
    private TransactionRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private NotificationService notificationService;


    public Transaction createTransaction(TransactionDTO transaction) throws Exception {
        var sender = userService.findUserById(transaction.senderId());
        var receiver = userService.findUserById(transaction.receiverId());
        userService.validateTransaction(sender, transaction.value());

        boolean isAuthorized = authorizeTransaction(sender, transaction.value());

        if(!isAuthorized) {
            throw new Exception("Transação não atutorizada");
        }

        Transaction newTransaction = new Transaction();
        newTransaction.setAmount(transaction.value());
        newTransaction.setSender(sender);
        newTransaction.setReceiver(receiver);
        newTransaction.setTimestamp(LocalDateTime.now());

        sender.setBalance(sender.getBalance().subtract(transaction.value()));
        receiver.setBalance((receiver.getBalance().add(transaction.value())));

        this.repository.save(newTransaction);
        this.userService.saveUser(sender);
        this.userService.saveUser(receiver);

        this.notificationService.sendNotification(sender, "Tranferencia realizado com sucesso!");
        this.notificationService.sendNotification(receiver, "Tranferencia recebida com sucesso!");

return newTransaction;
    }
            public boolean authorizeTransaction(User sender, BigDecimal value){
ResponseEntity<Map> authorizationResponse = restTemplate.getForEntity ("https://run.mocky.io/v3/5794d450-d2e2-4412-8131-73d0293ac1cc", Map.class);
if(authorizationResponse.getStatusCode() == HttpStatus.OK) {
    String message =(String) authorizationResponse.getBody().get("message");
return "Autorizado".equalsIgnoreCase(message);
} else  return false;

            }



}
