package com.example.BugTracker.Services;

import com.example.BugTracker.Models.Tester;
import com.example.BugTracker.Repositories.TesterRepository;
import com.example.BugTracker.Requests.TesterRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class TesterService {

    private final TesterRepository testerRepository;

    public String addTester(TesterRequest request) {
        Optional<Tester> tester = testerRepository.findByTesterEmail(request.getTesterEmail());

        if(tester.isEmpty()) {
            Tester testerToAdd = new Tester(
                    request.getFirstName(),
                    request.getLastName(),
                    request.getTesterEmail()
            );

            testerRepository.save(testerToAdd);
            return "Testers";
        }
        else{
            return "error";
        }
    }
}
