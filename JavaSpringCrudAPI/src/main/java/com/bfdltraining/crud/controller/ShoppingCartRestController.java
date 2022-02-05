package com.bfdltraining.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bfdltraining.crud.Entities.Products;
import com.bfdltraining.crud.Entities.ShoppingCart;
import com.bfdltraining.crud.repositories.ProductsRepository;
import com.bfdltraining.crud.repositories.ShoppingCartRepository;

@RestController
public class ShoppingCartRestController {
	
	@Autowired
	private ShoppingCartRepository shoppingRepo;
	
	@Autowired
	private ProductsRepository repo;
	
	@RequestMapping(value = "/shoppingcart/",method = RequestMethod.GET)
	public List<ShoppingCart> getCartContent() {
		return shoppingRepo.findAll();
	}
	
	@RequestMapping(value = "/addToCart/{id}",method = RequestMethod.POST)
	public ShoppingCart buyProduct(@PathVariable("id") int id) {
		
		Products product = repo.findById(id).get();
		return shoppingRepo.save(new ShoppingCart(product.getId(),product.getName(),product.getPrice()));
		
	} 

}
