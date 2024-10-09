package com.example.Finalproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Finalproject.model.Product;
import com.example.Finalproject.service.Cartservice;
import com.example.Finalproject.service.ProductService;

@RestController 
public class ProductController {

	
	  @Autowired
	     ProductService productService;
	 
	  
	  @Autowired
	    private Cartservice cartService;


	    // Get all products
	    @GetMapping("/products")
	    public List<Product> getProductsList() {
	        return productService.getAllProducts();
	    }

	    // Get a single product by ID
	    @GetMapping("/product/{id}")
	    public Product getProductById(@PathVariable("id") Long id) {
	        return productService.getProductById(id);
	    }

	    // Create a new product
	    @PostMapping("/product")
	    public ResponseEntity<String> createProduct(@RequestBody Product product) {
	        productService.addProduct(product);
	        return ResponseEntity.ok("Product created successfully");
	    }

	    // Delete a product by ID
	    @DeleteMapping("/product/{id}")
	    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long id) {
	        productService.deleteProduct(id);
	        return ResponseEntity.ok("Product deleted successfully");
	    }

	    // Update a product by ID
	    @PutMapping("/product/{id}")
	    public ResponseEntity<String> updateProduct(@PathVariable("id") Long id, @RequestBody Product updatedProduct) {
	        productService.updateProduct(id, updatedProduct);
	        return ResponseEntity.ok("Product updated successfully");
	    }

	    // Search for products by query
	    @GetMapping("/product/search")
	    public List<Product> searchProducts(@RequestParam("query") String query) {
	        return productService.searchProducts(query);
	    }

	
	    
	    
	    
	    
	    @PostMapping("/add/{id}")
	    public ResponseEntity<String> addProductToCart(@PathVariable("id") Long productId) {
	        try {
	            cartService.addProductToCart(productId);
	            return ResponseEntity.ok("Product added to cart successfully");
	        } catch (IllegalArgumentException e) {
	            return ResponseEntity.status(404).body(e.getMessage());  // Return 404 if product not found
	        }
	    }

	    // Get all cart items
	    @GetMapping("/items")
	    public ResponseEntity<List<Product>> getCartItems() {
	        List<Product> cartItems = cartService.getCartItems();
	        return ResponseEntity.ok(cartItems);
	    }

	    // Remove a product from the cart by ID
	    @DeleteMapping("/remove/{id}")
	    public ResponseEntity<String> removeFromCart(@PathVariable("id") Long productId) {
	        cartService.removeFromCart(productId);
	        return ResponseEntity.ok("Product removed from cart successfully");
	    }

	    // Clear the cart
	    @DeleteMapping("/clear")
	    public ResponseEntity<String> clearCart() {
	        cartService.clearCart();
	        return ResponseEntity.ok("Cart cleared successfully");
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    
	
}
