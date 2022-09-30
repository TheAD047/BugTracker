package com.example.BugTracker.Controllers;

import com.example.BugTracker.Models.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController {

    @RequestMapping(value = "/Register", method = RequestMethod.GET)
    public String getRegister() {
        return "Register";
    }

}
