package com.example.BugTracker.Repositories;

import com.example.BugTracker.Models.ProjectEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectRepository extends CrudRepository<ProjectEntity, String> {
    Iterable<ProjectEntity> findAllByClientName(String clientName);

    Optional<ProjectEntity> getAllByClientName(String clientName);
}
