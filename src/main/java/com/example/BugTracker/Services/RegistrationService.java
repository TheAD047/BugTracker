package com.example.BugTracker.Services;

import com.example.BugTracker.Requests.RegistrationRequest;
import com.example.BugTracker.Models.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final UserService userService;
    private final UsernameValidator validator;

    public String register(RegistrationRequest request) {
        if(validator.test(request.getUsername())) {
            throw new IllegalArgumentException("Email Already exists");
        }
        else {
            return userService.signUpUser(
                    new User(
                            request.getUsername(),
                            request.getPassword(),
                            request.getUserRole()
                    )
            );
        }
    }
}
