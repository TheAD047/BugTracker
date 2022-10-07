package com.example.BugTracker.Controllers;

import com.example.BugTracker.Requests.TesterRequest;
import com.example.BugTracker.Services.TesterService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/bt/testers/add")
@AllArgsConstructor
public class addTesterController {
    private final TesterService testerService;

    @PostMapping
    public String addTesterRequest(@RequestBody TesterRequest request) {
        return testerService.addTester(request);
    }
}
