package com.materialmanagement.service;

import com.materialmanagement.model.RegistrationRequest;
import com.materialmanagement.model.User;
import com.materialmanagement.model.UserRole;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class RegistrationRequestService {

    private UserService userService;
    private EmailValidatorService emailValidatorService;

    public String register(RegistrationRequest request){
        boolean isValidEmail = emailValidatorService.test(request.getEmail());
        if (!isValidEmail){
            throw new IllegalStateException("Email no valido");
        }
       return userService.singUpUser(new User(
               request.getFirstName(),
               request.getLastName(),
               request.getEmail(),
               request.getPassword(),
               UserRole.USER
       ));
    }
}
