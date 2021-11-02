package com.materialmanagement.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecycleObject {

    @Id
    @Column(nullable = false)
    private Integer idRecycleObject;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double weight;

    @Column(nullable = false)
    private String typeObject;

    @ManyToOne
    @JoinColumn(name = "LOCALITY_ID")
    @JsonIgnore
    private Locality locality;

}
