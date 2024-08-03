package com.contact.test.repository;

import com.contact.test.entities.Contact;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepositories extends CrudRepository<Contact, Integer> {
}
