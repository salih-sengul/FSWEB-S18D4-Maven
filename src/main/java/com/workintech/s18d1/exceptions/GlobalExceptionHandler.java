package com.workintech.s18d1.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<BurgerErrorResponse> exceptionhandler(BurgerException burgerException){
        BurgerErrorResponse burgerErrorResponse = new BurgerErrorResponse(
                burgerException.getMessage()
        );
        log.error("Error occured: "+burgerException);
        return new ResponseEntity<>(burgerErrorResponse,burgerException.getHttpStatus());
    }


    @ExceptionHandler
    public ResponseEntity<BurgerErrorResponse> exceptionhandler(Exception exception){
        BurgerErrorResponse burgerErrorResponse = new BurgerErrorResponse(
                exception.getMessage()
        );
        log.error("Error occured: "+exception);
        return new ResponseEntity<>(burgerErrorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
