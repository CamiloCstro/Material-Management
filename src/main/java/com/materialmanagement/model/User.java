package com.materialmanagement.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private Integer userId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean active;

    //rl
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Locality> localities;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Registration> registrations;

}
