package com.contact.test.service;

import com.contact.test.entities.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserContactService {
    User CreateUser(User u);

}
