package com.starter.app.db.repository;

import com.starter.app.db.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findOneByUsername(String username);
}
