package com.pursuit.springclass.services;

import com.pursuit.springclass.entities.Product;
import com.pursuit.springclass.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> obj = this.productRepository.findById(id);
        return obj.isPresent() ? obj.get() : null;
    }
}
