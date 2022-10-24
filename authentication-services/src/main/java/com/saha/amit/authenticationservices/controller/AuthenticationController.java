package com.saha.amit.authenticationservices.controller;


import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.saha.amit.authenticationservices.DTO.LoginDTO;
import com.saha.amit.authenticationservices.DTO.RegisteredCustomersDTO;
import com.saha.amit.authenticationservices.DTO.ResponseDTO;
import com.saha.amit.authenticationservices.service.AuthenticationService;


@RestController
@Api(tags = "Authentications")
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;

    @ApiOperation(value = "Login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> login(@Valid @RequestBody LoginDTO loginDTO) throws NoSuchAlgorithmException, InvalidKeySpecException {
        HttpHeaders responseHeaders = new HttpHeaders();
        Boolean result = authenticationService.login(loginDTO);
        ResponseDTO rs = ResponseDTO.builder()
                .statusCode(HttpStatus.OK.value())
                .status("Success")
                .response(result)
                .build();
//        rs.setStatusCode(HttpStatus.OK.value());
//        rs.setStatus("SUCCESS");
//        rs.setResponse(result);
        return ResponseEntity.status(HttpStatus.OK).headers(responseHeaders).body(rs);
    }

    @ApiOperation(value = "Register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/register")
    public ResponseEntity<ResponseDTO> register(@Valid @RequestBody RegisteredCustomersDTO registerationDTO) throws NoSuchAlgorithmException, InvalidKeySpecException {
        System.out.println(registerationDTO.toString());
        Boolean result = authenticationService.register(registerationDTO);
        HttpHeaders responseHeaders = new HttpHeaders();
        ResponseDTO rs = ResponseDTO.builder()
                .statusCode(HttpStatus.OK.value())
                .status("Success")
                .response(result)
                .build();
//        ResponseDTO rs = new ResponseDTO();
//        rs.setStatusCode(HttpStatus.OK.value());
//        rs.setStatus("SUCCESS");
//        rs.setResponse(result);
        return ResponseEntity.status(HttpStatus.OK).headers(responseHeaders).body(rs);
    }


}
