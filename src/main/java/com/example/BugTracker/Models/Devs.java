package com.example.BugTracker.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "developers")
@Getter
@Setter
public class Devs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DEV_ID")
    private Long devID;

    @Column(name = "DEV_FIRST_NAME")
    private String devFirstName;

    @Column(name = "DEV_LAST_NAME")
    private String devLastName;

    @Column(name = "DEV_EMAIL")
    private String devEmail;

    public Devs() {}

    public Devs(String devFirstName, String devLastName, String devEmail) {
        this.devFirstName = devFirstName;
        this.devLastName = devLastName;
        this.devEmail = devEmail;
    }

    @Override
    public String toString() {
        return "Devs{" +
                "devID=" + devID +
                ", devFirstName='" + devFirstName + '\'' +
                ", devLastName='" + devLastName + '\'' +
                ", devEmail='" + devEmail + '\'' +
                '}';
    }
}
