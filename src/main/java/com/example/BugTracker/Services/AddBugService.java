package com.example.BugTracker.Services;

import com.example.BugTracker.Models.ErrorEntity;
import com.example.BugTracker.Models.Tester;
import com.example.BugTracker.Repositories.ErrorRepository;
import com.example.BugTracker.Repositories.TesterRepository;
import com.example.BugTracker.Requests.BugRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AddBugService {
    private final TesterRepository testers;
    private final ErrorRepository errors;

    public String addBug(BugRequest request) {
        Optional<Tester> findTester = testers.findById(request.getTesterID());

        if(findTester.isPresent()) {
            Tester tester = findTester.get();
            ErrorEntity error = new ErrorEntity(
                    request.getErrorType(),
                    request.getSeverity(),
                    request.getErrorNotes(),
                    request.getProjectID(),
                    tester.getTesterFirstName() + tester.getTesterLastName(),
                    request.getTesterID()
                    );

            errors.save(error);
            return "Bugs";
        }
        else {
            return "error";
        }
    }
}
