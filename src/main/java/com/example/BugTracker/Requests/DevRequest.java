package com.example.BugTracker.Requests;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class DevRequest {
    private final String firstName;
    private final String lastName;
    private final String devEmail;
}
