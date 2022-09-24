package com.example.BugTracker.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "errors")
@Getter
@Setter
public class ErrorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ERR_ID")
    private Long errorID;

    @Column(name = "ERR_TYPE")
    private String errorType;

    @Column(name = "ERR_SEVERITY")
    private String severity;

    @Column(name = "ERR_NOTES")
    private String errorNotes;

    @Column(name = "PROJECT_ID")
    private String projectID;

    @Column(name = "DATE_FOUND")
    private Date dateFound;

    @Column(name = "FOUND_BY_TESTER")
    private String foundByTester;

    @Column(name = "TESTER_ID")
    private long testerID;

    @Column(name = "DEVS_ASSIGNED")
    private String devsAssigned;

    @Column(name = "ACTIVE_INDICATOR")
    private boolean activeIndicator;

    @Override
    public String toString() {
        return "ErrorEntity{" +
                "errorID=" + errorID +
                ", errorType='" + errorType + '\'' +
                ", severity='" + severity + '\'' +
                ", errorNotes='" + errorNotes + '\'' +
                ", projectID='" + projectID + '\'' +
                ", dateFound=" + dateFound +
                ", foundByTester='" + foundByTester + '\'' +
                ", devsAssigned='" + devsAssigned + '\'' +
                ", activeIndicator=" + activeIndicator +
                '}';
    }
}
