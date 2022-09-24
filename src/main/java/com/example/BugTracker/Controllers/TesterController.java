package com.example.BugTracker.Controllers;

import com.example.BugTracker.Models.ErrorEntity;
import com.example.BugTracker.Models.Tester;
import com.example.BugTracker.Repositories.ErrorRepository;
import com.example.BugTracker.Repositories.TesterRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping("/Testers")
public class TesterController {

    private final TesterRepository testerRepository;
    private final ErrorRepository errorRepository;

    @GetMapping
    public String getTesters(Model model) {
        Iterable<Tester> testersIterable = testerRepository.findAll();
        List<Tester> testers = new ArrayList<>();
        testersIterable.forEach(testers::add);
        testers.sort(new Comparator<Tester>() {
            @Override
            public int compare(Tester o1, Tester o2) {
                return o1.getTesterID().compareTo(o2.getTesterID());
            }
        });
        model.addAttribute("testers", testers);
        model.addAttribute("module", testers);

        return "Testers";
    }

    @GetMapping(path ="/{id}")
    public String getTesterDetails(@PathVariable("id") long testerID, Principal principal, Model model) {
        Optional<Tester> tester = this.testerRepository.findById(testerID);
        if(tester.isEmpty()){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }
        else {
            List<ErrorEntity> bugs = new ArrayList<>();
            Iterable<ErrorEntity> errorEntities = this.errorRepository.findAllByTesterID(testerID);
            errorEntities.forEach(bugs::add);
            model.addAttribute("bugs", bugs);
            model.addAttribute("tester", tester.get());
            model.addAttribute("module", bugs);
        }
        return "TesterDetails";
    }
}
