package br.com.productms.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.productms.model.Product;
import br.com.productms.repository.ProductRepository;

@RestController
public class ApiController {

	@Autowired
	ProductRepository productRepository;

	@PostMapping("/products")
	public Product insertProduct(@Valid @RequestBody Product product) {
		return productRepository.save(product);
	}

	@GetMapping("/products/{id}")
	public Product getAllProductById(@PathVariable String id) {
		return productRepository.findById(id).get();
	}

	@GetMapping("/products")
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@DeleteMapping("/products/{id}")
	public void deleteProduct(@PathVariable String id) {
		productRepository.deleteById(id);
	}
}
