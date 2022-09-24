package com.example.BugTracker.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "admins")
@Getter
@Setter
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ADMIN_ID")
    private Long adminID;

    @Column(name = "ADMIN_FIRST_NAME")
    private String adminFirstName;

    @Column(name = "ADMIN_LAST_NAME")
    private String adminLastName;

    @Column(name = "ADMIN_EMAIL")
    private String adminEmail;

    @Column(name = "ADMIN_PHONE_NUM")
    private BigInteger phoneNumber;

    @Override
    public String toString() {
        return "Admin{" +
                "adminID=" + adminID +
                ", adminFirstName='" + adminFirstName + '\'' +
                ", adminLastName='" + adminLastName + '\'' +
                ", adminEmail='" + adminEmail + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
