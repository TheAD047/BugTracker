package com.example.BugTracker.Repositories;

import com.example.BugTracker.Models.ErrorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ErrorRepository extends CrudRepository<ErrorEntity, Long> {
    Iterable<ErrorEntity> findAllByTesterID(long testerID);

}
