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

    public User insert(User obj) {
        User user = this.userRepository.save(obj);
        return user;
    }

    public void deleteById(Long id) {
        this.userRepository.deleteById(id);
    }

    public User update(Long id, User obj) {
        User user = this.userRepository.getReferenceById(id);
        this.updateData(user, obj);
        return this.userRepository.save(user);
    }

    private void updateData(User user, User obj) {
        user.setName(obj.getName());
        user.setEmail(obj.getEmail());
        user.setPhone(obj.getPhone());
    }
}
