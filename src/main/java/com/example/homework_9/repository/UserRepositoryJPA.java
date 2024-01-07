package com.example.homework_9.repository;

import com.example.homework_9.domain.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoryJPA extends JpaRepository<User, String> {

}
