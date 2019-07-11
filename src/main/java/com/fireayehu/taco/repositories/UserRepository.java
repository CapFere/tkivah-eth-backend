package com.fireayehu.taco.repositories;

import com.fireayehu.taco.domains.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer>{
    Iterable<User> findUsersByRole(String role);
    Optional<User> findUserByEmail(String email);
}
