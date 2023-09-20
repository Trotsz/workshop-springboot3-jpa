package com.pursuit.springclass.repositories;

import com.pursuit.springclass.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
