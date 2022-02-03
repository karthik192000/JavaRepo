package com.bfdltraining.crud.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bfdltraining.crud.Entities.Products;

public interface ProductRepository extends JpaRepository<Products, Integer> {

}
