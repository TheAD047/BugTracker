package com.example.BugTracker.Repositories;

import com.example.BugTracker.Models.Devs;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DevRepository extends CrudRepository<Devs, Long> {
    Optional<Devs> findByDevEmail(String email);
}
