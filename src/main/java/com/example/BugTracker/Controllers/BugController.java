package com.example.BugTracker.Controllers;

import com.example.BugTracker.Models.ErrorEntity;
import com.example.BugTracker.Models.ProjectEntity;
import com.example.BugTracker.Repositories.ErrorRepository;
import com.example.BugTracker.Repositories.ProjectRepository;
import com.example.BugTracker.Repositories.TesterRepository;
import com.example.BugTracker.Requests.BugRequest;
import com.example.BugTracker.Services.AddBugService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Controller
@AllArgsConstructor
public class BugController {
    private final ErrorRepository errorRepository;
    private final ProjectRepository projectRepository;
    private final TesterRepository testerRepository;
    private final AddBugService bugService;

    @RequestMapping(value = "/Bugs", method = RequestMethod.GET)
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

    @RequestMapping(value = "api/bt/bugs/add", method = RequestMethod.POST)
    public String addBug(@RequestBody BugRequest bug) {
        return bugService.addBug(bug);
    }

    @RequestMapping(value = "/addBug" , method = RequestMethod.GET)
    public String getAddBugForm(Model model) {

        Iterable<ProjectEntity> projectEntities = projectRepository.findAll();
        List<ProjectEntity> projects = new ArrayList<>();
        projectEntities.forEach(projects::add);
        projects.sort(new Comparator<ProjectEntity>() {
            @Override
            public int compare(ProjectEntity o1, ProjectEntity o2) {
                return o1.getProjectID().compareTo(o2.getProjectID());
            }
        });
        model.addAttribute("projects", projects);
        model.addAttribute("model", projects);



        return "addBug";
    }
}
