package com.desafio.PCPY.infra;

import com.desafio.PCPY.dtos.ExceptionDto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler (DataIntegrityViolationException.class)
    public ResponseEntity treatDuplicatedEntry (DataIntegrityViolationException exception){
        ExceptionDto exceptionDto = new ExceptionDto("Usuário já cadastrado", "400");
        return ResponseEntity.badRequest().body(exceptionDto);

    }

    @ExceptionHandler (EntityNotFoundException.class)
    public ResponseEntity treat404 (EntityNotFoundException exception){
        return ResponseEntity.notFound().build();

    }
    @ExceptionHandler (Exception.class)
    public ResponseEntity treatGeneralException (Exception exception){
        ExceptionDto exceptionDto = new ExceptionDto(exception.getMessage(), "500");
        return ResponseEntity.internalServerError().body(exceptionDto);
    }


    }
