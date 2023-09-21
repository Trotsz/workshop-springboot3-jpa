package com.pursuit.springclass.services;

import com.pursuit.springclass.entities.User;
import com.pursuit.springclass.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> obj = this.userRepository.findById(id);

        return obj.isPresent() ? obj.get() : null;
    }
}
