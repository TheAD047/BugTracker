package com.example.BugTracker.Controllers;

import com.example.BugTracker.Requests.BugRequest;
import com.example.BugTracker.Services.AddBugService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class addBugController {
    private final AddBugService bugService;

    @RequestMapping(value = "api/bt/bugs/add", method = RequestMethod.POST)
    public String addBug(@RequestBody BugRequest bug) {
        return bugService.addBug(bug);
    }
}
