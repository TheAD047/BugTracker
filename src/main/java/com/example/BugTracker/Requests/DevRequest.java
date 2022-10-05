package com.example.BugTracker.Requests;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class DevRequest {
    private String firstName;
    private String lastName;
    private String devEmail;
}
