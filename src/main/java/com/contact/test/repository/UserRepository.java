package com.contact.test.repository;

import com.contact.test.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User , Integer> {

    Optional<User> findByEmail(String email);
}
