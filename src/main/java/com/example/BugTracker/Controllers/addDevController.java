package com.example.BugTracker.Controllers;

import com.example.BugTracker.Requests.DevRequest;
import com.example.BugTracker.Services.DevService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class addDevController {
    private final DevService devService;

    @RequestMapping(value = "/api/bt/dev/add", method = RequestMethod.POST)
    public String addDev(@RequestBody DevRequest dev){
        return devService.addDev(dev);
    }
}
