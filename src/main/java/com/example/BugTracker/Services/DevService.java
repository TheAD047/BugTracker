package com.example.BugTracker.Services;

import com.example.BugTracker.Models.Devs;
import com.example.BugTracker.Repositories.DevRepository;
import com.example.BugTracker.Requests.DevRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DevService {
    private final DevRepository devRepository;

    public String addDev(DevRequest request) {
        Optional<Devs> dev = devRepository.findByDevEmail(request.getDevEmail());

        if(dev.isEmpty()) {
            Devs developer = new Devs(
                    request.getFirstName(),
                    request.getLastName(),
                    request.getDevEmail()
                    );

            devRepository.save(developer);
            return "Devs";
        }
        else {
            return "error";
        }
    }
}
