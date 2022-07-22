package com.product.service;

import java.util.List;

import com.product.model.Product;

public interface ProductService {

	Product addProduct(Product product);

	List<Product> getAllProduct();

	Product getProductById(String productId);

	Product updateProduct(Product product);

	void deleteProductById(String productId);

}
