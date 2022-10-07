package com.example.BugTracker.Repositories;

import com.example.BugTracker.Models.Tester;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TesterRepository extends CrudRepository<Tester, Long> {
    Optional<Tester> findByTesterEmail(String email);
}
