package com.revature.RCUbackend.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="address_id_seq")
    @Column(name="id", columnDefinition="int")
    @SequenceGenerator(name="address_id_seq", sequenceName="address_id_seq",  allocationSize=1)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column
    private ERole name;

    // Constructors

    public Role() {
    }

    public Role(ERole name) {
        this.name = name;
    }

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ERole getName() {
        return name;
    }

    public void setName(ERole name) {
        this.name = name;
    }


    // toString Method here


    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}
