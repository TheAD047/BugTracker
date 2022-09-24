package com.example.BugTracker.Controllers;

import com.example.BugTracker.Models.ErrorEntity;
import com.example.BugTracker.Repositories.ErrorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/Bugs")
public class BugController {
    public final ErrorRepository errorRepository;

    @GetMapping
    public String getBugs(Model model) {
        Iterable<ErrorEntity> errorEntities = errorRepository.findAll();
        List<ErrorEntity> bugs = new ArrayList<>();
        errorEntities.forEach(bugs::add);
        bugs.sort(new Comparator<ErrorEntity>() {
            @Override
            public int compare(ErrorEntity o1, ErrorEntity o2) {
                return o1.getErrorID().compareTo(o2.getErrorID());
            }
        });
        model.addAttribute("bugs", bugs);
        model.addAttribute("module", bugs);

        return "Bugs";
    }
}
