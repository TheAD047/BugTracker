package com.example.BugTracker.Requests;

import com.example.BugTracker.Roles.UserRole;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {
    private final String username;
    private final String password;
    private final UserRole userRole;
}
