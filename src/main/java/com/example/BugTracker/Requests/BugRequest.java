package com.example.BugTracker.Requests;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class BugRequest {
    private String errorType;
    private String severity;
    private String errorNotes;
    private String projectID;
    private long testerID;
    private String devsAssigned;
    private boolean activeIndicator;
}
