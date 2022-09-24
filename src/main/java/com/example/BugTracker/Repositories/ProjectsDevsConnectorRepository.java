package com.example.BugTracker.Repositories;


import com.example.BugTracker.Models.ProjectDevsConnectorModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectsDevsConnectorRepository extends CrudRepository<ProjectDevsConnectorModel, Long> {
    Iterable<ProjectDevsConnectorModel> findAllByDevID(long devID);
}

