package com.materialmanagement.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Locality {

    @Id
    private Integer localityId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String neighborhood;

    //rl
    @OneToMany(mappedBy = "locality", cascade = CascadeType.ALL)
    private Set <User> users;

}
