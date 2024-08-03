package com.contact.test.service;

import com.contact.test.entities.User;
import com.contact.test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;
@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> op_User= userRepository.findByEmail(username);
        if(op_User.isEmpty())
        {
            throw new UsernameNotFoundException("User not found!");
        }
        return new CustomUserDetails(op_User.get());
    }
}
