package com.bfdltraining.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bfdltraining.crud.Entities.Products;
import com.bfdltraining.crud.repositories.ProductsRepository;

@RestController
public class ProductsRestController {

	@Autowired
	ProductsRepository repo;

	@RequestMapping(value = "/products/",method = RequestMethod.GET)
	public List<Products> getProducts(){
		return repo.findAll();
	}
	
	@RequestMapping(value = "/product/{id}",method = RequestMethod.GET)
	public Products getProduct(@PathVariable("id")int id) {
		return repo.findById(id).get();
	}
	
	@RequestMapping(value = "/products/",method = RequestMethod.POST)
	public Products createProduct(@RequestBody Products product) {
		return repo.save(product);
	}
	
	@RequestMapping(value = "/products/",method = RequestMethod.PUT)
	public Products updateProduct(@RequestBody Products product) {
		return repo.save(product);
	}
	
	@RequestMapping(value = "/product/{id}",method = RequestMethod.DELETE)
	public void deleteProduct(@PathVariable("id") int id) {
		repo.deleteById(id);
	}
}

