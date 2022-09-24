package com.example.BugTracker.Controllers;

import com.example.BugTracker.Models.ProjectEntity;
import com.example.BugTracker.Repositories.ProjectRepository;
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
@RequestMapping("/Projects")
@AllArgsConstructor
public class ProjectController {
    private final ProjectRepository projectRepository;

    @GetMapping
    public String getProjects(Model model) {
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

        return "Projects";
    }

    @GetMapping(path="/projectID/{id}")
    public String getSingleProjectDetails(@PathVariable("id") String projectID, Principal principal, Model model) {
        Optional<ProjectEntity> project = this.projectRepository.findById(projectID);
        if(project.isEmpty()){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }
        else {
            model.addAttribute("project", project.get());
        }
        return "Project_Details";
    }

    @GetMapping(path = "/{client}")
    public String getClientProjects(@PathVariable("client") String clientName, Principal principal, Model model){
        Optional<ProjectEntity> project = this.projectRepository.getAllByClientName(clientName);
        if(project.isEmpty()){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }
        else {
            Iterable<ProjectEntity> projectEntities = this.projectRepository.findAllByClientName(clientName);
            List<ProjectEntity> projects = new ArrayList<>();
            projectEntities.forEach(projects::add);
            model.addAttribute("projects", projects);
            model.addAttribute("client", clientName);
            model.addAttribute("module", projects);
        }
        return "ClientDetails";
    }

}
