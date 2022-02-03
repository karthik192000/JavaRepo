package com.bfdltraining.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bfdltraining.crud.Entities.Products;

public interface ProductsRepository extends JpaRepository<Products, Integer> {

}
