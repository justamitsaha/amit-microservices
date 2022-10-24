package com.saha.amit.authenticationservices.controller;

import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.saha.amit.authenticationservices.DTO.ResponseDTO;

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

    /*
     * @ExceptionHandler(EmployeeResponseNotFoundException.class) public final
     * ResponseEntity<Object>
     * handleUserNotFoundException(EmployeeResponseNotFoundException ex, WebRequest
     * request) {
     * System.out.println("<----Inside handleUserNotFoundException---->");
     * CustomeResponse exceptionResponse = new CustomeResponse(new Date(),
     * ex.getMessage(), request.getDescription(false)); return new
     * ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND); }
     */

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
