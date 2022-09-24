package com.example.BugTracker.Repositories;

import com.example.BugTracker.Models.Devs;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevRepository extends CrudRepository<Devs, Long> {
}
