package com.example.BugTracker.Requests;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class BugRequest {
    private final String errorType;
    private final String severity;
    private final String errorNotes;
    private final String projectID;
    private final long testerID;
    private final String devsAssigned;
    private final boolean activeIndicator;
}
