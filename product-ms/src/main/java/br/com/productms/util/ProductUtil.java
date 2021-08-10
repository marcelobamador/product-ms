package br.com.productms.util;

import br.com.productms.dto.ReturnProduct;
import br.com.productms.model.Product;

public class ProductUtil {
	public static ReturnProduct parseProductReturn(Product product) {
		ReturnProduct returnProduct = new ReturnProduct();
		returnProduct.setId(product.getId());
		returnProduct.setName(product.getName());
		returnProduct.setDescription(product.getDescription());
		returnProduct.setPrice(product.getPrice());
		return returnProduct;
	}
}
