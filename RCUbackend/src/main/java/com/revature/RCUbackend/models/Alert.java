package com.revature.RCUbackend.models;

import javax.persistence.*;
import java.sql.Date;

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
