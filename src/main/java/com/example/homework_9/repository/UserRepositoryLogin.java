package com.example.homework_9.repository;

import com.example.homework_9.domain.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepositoryLogin extends JpaRepository<User, String> {
    boolean existsByUserid(String userid);

    boolean existsByName(String name);

    Optional<User> findByUserid(String userid);
}
