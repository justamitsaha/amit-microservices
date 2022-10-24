package com.saha.amit.authenticationservices.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.saha.amit.authenticationservices.model.RegisterationModel;

@Repository
public interface AuthenticationDAO extends CrudRepository<RegisterationModel, String> {

}
