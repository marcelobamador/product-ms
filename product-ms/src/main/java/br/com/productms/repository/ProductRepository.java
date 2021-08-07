package br.com.productms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.productms.model.Product;

public interface ProductRepository extends JpaRepository<Product, String>{

}
