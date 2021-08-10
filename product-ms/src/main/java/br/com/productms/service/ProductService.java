package br.com.productms.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.productms.model.Product;
import br.com.productms.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	
	public Product insertProduct(Product product) throws Exception {
		try {
			validarEntidade(product);
			return productRepository.save(product);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public Product getAllProductById(String id) {
		return productRepository.findById(id).get();
	}
	
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	public void deleteProduct(String id) {
		productRepository.deleteById(id);;
	}
	
	public void validarEntidade(Product product) throws Exception {
		if(product.getName() == null || product.getName().isEmpty()) {
			throw new Exception("O Campo 'NAME' deve ser preenchido");
		}
		if(product.getDescription() == null || product.getDescription().isEmpty()) {
			throw new Exception("O Campo 'DESCRIPTION' deve ser preenchido");
		}
		if(product.getPrice() == null) {
			throw new Exception("O Campo 'PRICE' deve ser preenchido");
		}
		if (product.getPrice().compareTo(BigDecimal.ZERO) < 0) {
			throw new Exception("O Campo 'PRICE' não pode ser negativo");
		}
	}
}
