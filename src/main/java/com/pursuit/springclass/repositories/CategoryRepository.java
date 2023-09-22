package com.pursuit.springclass.repositories;

import com.pursuit.springclass.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
