package com.example.BugTracker.Repositories;

import com.example.BugTracker.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUsername(String username);
}
