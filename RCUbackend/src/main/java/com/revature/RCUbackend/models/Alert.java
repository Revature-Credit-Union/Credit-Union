package com.revature.RCUbackend.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

public class Alert {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="address_id_seq")
    @Column(name="id", columnDefinition="int")
    @SequenceGenerator(name="address_id_seq", sequenceName="address_id_seq",  allocationSize=1)
    private int id;

    private int user_id;

    private Date date;//java.sql.Date

    private String email;
}
