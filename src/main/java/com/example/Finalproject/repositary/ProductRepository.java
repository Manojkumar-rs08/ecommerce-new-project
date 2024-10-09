package com.example.Finalproject.repositary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.Finalproject.model.Product;

@Repository
@EnableJpaRepositories
public interface ProductRepository extends JpaRepository<Product, Long> {

	// Search by product name or description
    List<Product> findByName(String name);
	
	
	
}
