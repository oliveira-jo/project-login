package com.oliveira.project_login.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oliveira.project_login.domain.user.User;

public interface UserRepository extends JpaRepository<User, String> {

  Optional<User> findByEmail(String email);

}
