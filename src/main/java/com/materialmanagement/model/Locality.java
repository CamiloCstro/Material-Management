package com.materialmanagement.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Locality {

    @Id
    private Integer id_locality;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String neighborhood;


}
