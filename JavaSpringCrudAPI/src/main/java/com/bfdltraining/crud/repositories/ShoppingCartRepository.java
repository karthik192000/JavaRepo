package com.bfdltraining.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bfdltraining.crud.Entities.ShoppingCart;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {

}
