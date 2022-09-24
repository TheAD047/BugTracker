package com.example.BugTracker.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "PROJECT_DEVS")
@Getter
@Setter
public class ProjectDevsConnectorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ENTRY_ID")
    private long entryID;

    @Column(name = "PROJECT_ID")
    private String projectID;

    @Column(name = "DEV_ID")
    private long devID;

    @Override
    public String toString() {
        return "ProjectDevsConnectorModel{" +
                "entryID=" + entryID +
                ", projectID='" + projectID + '\'' +
                ", devID=" + devID +
                '}';
    }
}
