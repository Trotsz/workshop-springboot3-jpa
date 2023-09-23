package com.pursuit.springclass.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pursuit.springclass.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
