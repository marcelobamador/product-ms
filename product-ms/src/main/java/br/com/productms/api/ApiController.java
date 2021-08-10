package br.com.productms.api;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.productms.dto.ReturnProduct;
import br.com.productms.model.Product;
import br.com.productms.service.ProductService;
import br.com.productms.util.ProductUtil;


@RestController
public class ApiController {

	@Autowired
	ProductService productService;

	@PostMapping("/products")
	public ResponseEntity<ReturnProduct> insertProduct(@RequestBody Product product) throws Exception {
		ReturnProduct returnProduct = new ReturnProduct();
		try {
			Product pro = productService.insertProduct(product);
			returnProduct = ProductUtil.parseProductReturn(pro);
			return new ResponseEntity<ReturnProduct>(returnProduct, HttpStatus.CREATED);
		} catch (Exception e) {
			returnProduct.setStatus_code(400);
			returnProduct.setMessage(e.getMessage());
			return new ResponseEntity<ReturnProduct>(returnProduct, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getAllProductById(@PathVariable String id) {
		Product product = new Product();
		try {
			product = productService.getAllProductById(id);
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping("/products")
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	@DeleteMapping("/products/{id}")
	public ResponseEntity<Product> deleteProduct(@PathVariable String id) {
		try {
			productService.deleteProduct(id);
			return new ResponseEntity<Product>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
	}
	
}
