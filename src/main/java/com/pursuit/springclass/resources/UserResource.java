package com.pursuit.springclass.resources;

import com.pursuit.springclass.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll() {
        User user = new User(1L, "Joao Pedro", "jpviolao@hotmail.com", "2312938472", "12345678");

        return ResponseEntity.ok().body(user);
    }
}
