package com.pursuit.springclass.services;

import com.pursuit.springclass.entities.User;
import com.pursuit.springclass.repositories.UserRepository;
import com.pursuit.springclass.resources.exceptions.ResourceExceptionHandler;
import com.pursuit.springclass.services.exceptions.DatabaseException;
import com.pursuit.springclass.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.PersistenceException;
import jakarta.servlet.http.HttpServletRequest;
import org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

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

        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User obj) {
        User user = this.userRepository.save(obj);
        return user;
    }

    public void deleteById(Long id) {
        if(this.userRepository.findById(id).isEmpty()) {
            throw new ResourceNotFoundException(id);
        }

        try {
            this.userRepository.deleteById(id);
        } catch(RuntimeException e) {
            throw new DatabaseException("It is not possible to delete that user, because there is another entity containing a foreign key that points to the specified user.");
        }
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
