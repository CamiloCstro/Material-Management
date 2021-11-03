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
public class Registration {

    @Id
    @Column(nullable = false)
    private Integer registrationID;

    @Column(nullable = false)
    private String date;

    @OneToOne(mappedBy = "registration")
    @JsonIgnore
    private RecycleObject recycleObject;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    @JsonIgnore
    private User user;

}
