package com.contact.test.repository;

import com.contact.test.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User , Integer> {
}
