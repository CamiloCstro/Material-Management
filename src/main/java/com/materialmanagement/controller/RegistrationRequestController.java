package com.materialmanagement.controller;


import com.materialmanagement.model.RegistrationRequest;
import com.materialmanagement.service.RegistrationRequestService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/registrationUser")
@AllArgsConstructor
public class RegistrationRequestController {

    private RegistrationRequestService registrationRequestService;

    @PostMapping()
    public String register(@RequestBody RegistrationRequest request){
        return registrationRequestService.register(request);
    }

}
