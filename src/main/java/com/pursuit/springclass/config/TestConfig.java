package com.pursuit.springclass.config;

import com.pursuit.springclass.entities.User;
import com.pursuit.springclass.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    // database seeding
    @Override
    public void run(String... args) throws Exception {
        User user1 = new User(null, "Ronaldo Fenomeno", "ronaldo@gmail.com", "229869584", "123321");
        User user2 = new User(null, "Maria Julia", "maria@gmail.com", "22949139043", "1234323");

        this.userRepository.saveAll(Arrays.asList(user1, user2));
    }
}
