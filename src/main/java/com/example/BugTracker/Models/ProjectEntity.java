package com.example.BugTracker.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "projects")
@Getter
@Setter
public class ProjectEntity {
    @Id
    @Column(name = "PROJECT_ID")
    private String projectID;

    @Column(name = "CLIENT")
    private String clientName;

    @Column(name = "DATE_STARTED")
    private Date startDate;

    @Column(name = "IN_PROGRESS_INDICATOR")
    private boolean inProgressIndicator;

    @Column(name = "DEADLINE")
    private Date deadline;

    @Column(name = "MARKED_FOR_ITERATION")
    private boolean iterationIndicator;

    @Column(name = "COMPLETION_DATE")
    private Date completionDate;

    @Override
    public String toString() {
        return "ProjectEntity{" +
                "projectID='" + projectID + '\'' +
                ", clientName='" + clientName + '\'' +
                ", startDate=" + startDate +
                ", inProgressIndicator=" + inProgressIndicator +
                ", deadline=" + deadline +
                ", iterationIndicator=" + iterationIndicator +
                ", completionDate=" + completionDate +
                '}';
    }
}
