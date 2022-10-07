package com.example.BugTracker.Requests;


import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@ToString
public class TesterRequest {
    private final String firstName;
    private final String lastName;
    private final String testerEmail;
}
