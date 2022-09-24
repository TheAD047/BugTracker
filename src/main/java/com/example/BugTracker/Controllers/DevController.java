package com.example.BugTracker.Controllers;

import com.example.BugTracker.Models.Devs;
import com.example.BugTracker.Models.ProjectDevsConnectorModel;
import com.example.BugTracker.Repositories.DevRepository;
import com.example.BugTracker.Repositories.ProjectsDevsConnectorRepository;
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
@RequestMapping("/Devs")
public class DevController {
    private final DevRepository devRepository;
    private final ProjectsDevsConnectorRepository projectsDevsConnectorRepository;

    @GetMapping
    public String getAllUsers(Model model) {
        Iterable<Devs> devsIterable = this.devRepository.findAll();
        List<Devs> devs = new ArrayList<Devs>();
        devsIterable.forEach(devs::add);
        devs.sort(new Comparator<Devs>() {
            @Override
            public int compare(Devs o1, Devs o2) {
                return o1.getDevID().compareTo(o2.getDevID());
            }
        });
        model.addAttribute("devs", devs);
        model.addAttribute("module", devs);
        return "Devs";
    }

    @GetMapping(path = "/{id}")
    public String getDetailedDevs(@PathVariable("id") long devID, Principal principal, Model model) {
        Optional<Devs> dev = this.devRepository.findById(devID);
        if(dev.isEmpty()){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }
        else {
            List<ProjectDevsConnectorModel> projects = new ArrayList<>();
            Iterable<ProjectDevsConnectorModel> projectEntities = this.projectsDevsConnectorRepository.findAllByDevID(devID);
            projectEntities.forEach(projects::add);
            model.addAttribute("projects", projects);
            model.addAttribute("dev", dev.get());
            model.addAttribute("module", projects);
        }
        return "Dev_Details";
    }
}
