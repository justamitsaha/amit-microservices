package com.saha.amit.authenticationservices.service;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saha.amit.authenticationservices.DAO.AuthenticationDAO;
import com.saha.amit.authenticationservices.DTO.LoginDTO;
import com.saha.amit.authenticationservices.DTO.PasswordEncryptionDTO;
import com.saha.amit.authenticationservices.DTO.RegisteredCustomersDTO;
import com.saha.amit.authenticationservices.model.RegisterationModel;
import com.saha.amit.authenticationservices.util.AuthenticationUtil;

@Service
public class AuthenticationService {

    @Autowired
    AuthenticationDAO authenticationDAO;

    public boolean register(RegisteredCustomersDTO registerUser) throws NoSuchAlgorithmException, InvalidKeySpecException {
        PasswordEncryptionDTO pe = AuthenticationUtil.generateHash(registerUser.getPassword());
        RegisterationModel rm = RegisterationModel.builder()
                .emailId(registerUser.getEmailId())
                .firstName(registerUser.getFirstName())
                .lastName(registerUser.getLastName())
                .password(pe.getPassword())
                .salt(pe.getSalt()).build();
//        rm.setEmailId(registerUser.getEmailId());
//        rm.setFirstName(registerUser.getFirstName());
//        rm.setLastName(registerUser.getLastName());
//
//        rm.setPassword(pe.getPassword());
//        rm.setSalt(pe.getSalt());
        if (authenticationDAO.existsById(rm.getEmailId())) {
            throw new RuntimeException("Email Already Registered");
        } else {
            authenticationDAO.save(rm);
            return true;
        }
    }


    public boolean login(LoginDTO logindto) throws NoSuchAlgorithmException, InvalidKeySpecException {
        var loginStatus = false;
        Optional<RegisterationModel> opt = authenticationDAO.findById(logindto.getEmail());
        if (opt.isPresent()) {
            RegisterationModel registerUser = opt.get();
            System.out.println("Login hashed password" + registerUser.getPassword());
            System.out.println("Login hashed password" + registerUser.getSalt());
            try {
                loginStatus = AuthenticationUtil.validatePassword(logindto.getPassword(), registerUser.getPassword(), registerUser.getSalt());
                System.out.println("Login status --> " + loginStatus);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (InvalidKeySpecException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("User Not found");
        }
        return loginStatus;
    }


}
