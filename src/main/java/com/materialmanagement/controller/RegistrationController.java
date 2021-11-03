package com.materialmanagement.controller;

import com.materialmanagement.model.Registration;

import com.materialmanagement.repository.IRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/Registration")
public class RegistrationController {

    @Autowired
    IRegistrationRepository iRegistrationRepository;

    @PostMapping()
    public Registration createRegistration(@RequestBody Registration registration) {
        return iRegistrationRepository.save(registration);
    }

}
