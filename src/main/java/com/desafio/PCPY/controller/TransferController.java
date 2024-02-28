//package com.desafio.PCPY.controller;
//
//import com.desafio.PCPY.domain.users.DadosDaTransferencia;
//import com.desafio.PCPY.service.TransferService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/transferencias")
//
//public class TransferController {
//    @Autowired
//    private TransferService transferService;
//
//    @PostMapping
//    public ResponseEntity<String> transferir(@RequestBody DadosDaTransferencia dados) {
//        transferService.transferir(dados.idReceiver(), dados.idSender(), dados.valor());
//        return ResponseEntity.ok("Transferência realizada com sucesso");
//    }
//}