package com.saha.amit.productServices.controller;

import com.saha.amit.productServices.DTO.ResponseDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.util.stream.Collectors;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        System.out.println("<-----Inside handleAllExceptions---->" + ex.getMessage());
        ResponseDTO responseDTO = ResponseDTO.builder()
                .status(ex.getMessage())
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .build();
        return new ResponseEntity<Object>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        System.out.println("<----Inside handleMethodArgumentNotValid---->" + ex.getMessage());
        String message = ex.getBindingResult().getAllErrors().stream().map(s -> s.getDefaultMessage())
                .collect(Collectors.joining("|"));
        ResponseDTO responseDTO = ResponseDTO.builder()
                .status(message)
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .build();
        return new ResponseEntity<Object>(responseDTO, HttpStatus.BAD_REQUEST);
    }
}
