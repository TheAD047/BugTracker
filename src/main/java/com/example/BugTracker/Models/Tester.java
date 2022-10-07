package com.example.BugTracker.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "testers")
@Getter
@Setter
public class Tester {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TESTER_ID")
    private Long testerID;

    @Column(name = "TESTER_FIRST_NAME")
    private String testerFirstName;

    @Column(name = "TESTER_LAST_NAME")
    private String testerLastName;

    @Column(name = "TESTER_EMAIL")
    private String testerEmail;

    public Tester() {}

    public Tester(String testerFirstName, String testerLastName, String testerEmail) {
        this.testerFirstName = testerFirstName;
        this.testerLastName = testerLastName;
        this.testerEmail = testerEmail;
    }

    @Override
    public String toString() {
        return "Tester{" +
                "testerID=" + testerID +
                ", testerFirstName='" + testerFirstName + '\'' +
                ", testerLastName='" + testerLastName + '\'' +
                ", testerEmail='" + testerEmail + '\'' +
                '}';
    }
}
