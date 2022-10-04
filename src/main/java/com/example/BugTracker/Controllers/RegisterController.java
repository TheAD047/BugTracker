package com.example.BugTracker.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegisterController {

    @RequestMapping(value = "/Register", method = RequestMethod.GET)
    public String getRegister() {
        return "Register";
    }

}
