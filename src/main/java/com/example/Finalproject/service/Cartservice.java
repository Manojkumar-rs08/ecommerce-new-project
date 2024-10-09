package com.example.Finalproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Finalproject.model.Product;
import com.example.Finalproject.repositary.ProductRepository;



@Service
public class Cartservice {

	
	 @Autowired
	    private ProductRepository productRepository;

	    private static List<Product> cartItems = new ArrayList<>();

	    public void addProductToCart(Long productId) {
	        Optional<Product> product = productRepository.findById(productId);  // Fetch product by ID
	        if (product.isPresent()) {
	            cartItems.add(product.get());  // Add product to the cart
	        } else {
	            throw new IllegalArgumentException("Product not found for ID: " + productId);
	        }
	    }

	    
	    
	    
	    public List<Product> getCartItems() {
	        return new ArrayList<>(cartItems);  // Return a copy to avoid direct manipulation
	    }

	    
	    
	    public void removeFromCart(Long productId) {
	        cartItems.removeIf(product -> product.getId().equals(productId));
	    }

	    
	    
	    
	    public void clearCart() {
	        cartItems.clear();
	    }
	}
	
	
	
	
	
	
	
	

