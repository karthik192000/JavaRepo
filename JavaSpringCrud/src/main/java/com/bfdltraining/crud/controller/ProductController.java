package com.bfdltraining.crud.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import com.bfdltraining.crud.Entities.Products;
import com.bfdltraining.crud.repos.ProductRepository;

@RestController
public class ProductController {
	
	@Autowired
	ProductRepository repo;
	
	
	@RequestMapping(value = "/products/",method = RequestMethod.GET)
	public List<Products> getProducts() {
		return repo.findAll();
	}
	
	@RequestMapping(value = "/products/{id}",method = RequestMethod.GET)
	public Products getProduct(@PathVariable("id") int id ) {
		try {
		return repo.findById(id).get();
		}
		catch(Exception ex) {
			ex.getMessage();		}
		return new Products();
	} 
	
	@RequestMapping(value = "/products/",method = RequestMethod.POST)
	public Products createProduct(@RequestBody Products products) {
		return repo.save(products);
	}
	
	
	@RequestMapping(value = "/products/",method = RequestMethod.PUT)
	public Products updateProduct(@RequestBody Products products) {
		return repo.save(products);
	}
	
	@RequestMapping(value = "/product/{id}",method = RequestMethod.DELETE)
	public void deleteProduct(@PathVariable("id") int id) {
		repo.deleteById(id);
	}

}
