package com.example.BugTracker.Services;

import com.example.BugTracker.Repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Service
@AllArgsConstructor
public class UsernameValidator implements Predicate<String> {

    private final UserRepository userRepository;

    @Override
    public boolean test(String test) {
        if(userRepository.findByUsername(test).isPresent()) {
            return true;
        }
        else {
            return false;
        }
    }
}
