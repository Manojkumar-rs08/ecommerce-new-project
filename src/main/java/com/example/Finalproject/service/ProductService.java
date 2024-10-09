package com.example.Finalproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Finalproject.model.Product;
import com.example.Finalproject.repositary.ProductRepository;


@Service
public class ProductService {

	
	 @Autowired
	    private ProductRepository productRepository;

	    public List<Product> getAllProducts() {
	        return productRepository.findAll();
	    }

	    public Product getProductById(Long id) {
	        return productRepository.findById(id).orElse(null);
	    }

	    public void addProduct(Product product) {
	        productRepository.save(product);
	    }

	    public void deleteProduct(Long id) {
	        productRepository.deleteById(id);
	    }
	    
	    
	    

	    // Update product
	    public void updateProduct(Long id, Product updatedProduct) {
	        Product existingProduct = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
	        existingProduct.setName(updatedProduct.getName());
	        existingProduct.setPrice(updatedProduct.getPrice());
	       
	        // Set other fields as necessary
	        productRepository.save(existingProduct);
	    }
 
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    // Search products by name or description
	    public List<Product> searchProducts(String query) {
	        return productRepository.findByName(query);
	    }
	    
	    
	    
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

