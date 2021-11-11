package com.materialmanagement.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class RegistrationRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String password;

}
