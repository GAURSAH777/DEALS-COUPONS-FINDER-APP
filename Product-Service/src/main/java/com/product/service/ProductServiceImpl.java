package com.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.exception.ProductAlreadyExistException;
import com.product.exception.ProductNotFoundException;
import com.product.model.Product;
import com.product.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product addProduct(Product product) {
//		Optional<Product> optionalProduct = productRepository.findById(product.getProductId());
//		if (optionalProduct.isEmpty()) {
		Product savedProduct = productRepository.save(product);
		return savedProduct;

//		} else {
//			throw new ProductAlreadyExistException("Product Already Exist with id: " + product.getProductId());
//		}
	}

	@Override
	public List<Product> getAllProduct() {
		List<Product> products = productRepository.findAll();
		if (products == null) {
			throw new ProductNotFoundException("Products not found");
		} else {
			return products;
		}

	}

	@Override
	public Product getProductById(String productId) {
		Optional<Product> optionalProduct = productRepository.findById(productId);
		if (optionalProduct.isEmpty()) {
			throw new ProductNotFoundException("Product not found with Id: " + productId);
		} else {
			Product product = optionalProduct.get();
			return product;
		}

	}

	@Override
	public Product updateProduct(Product product) {
		Optional<Product> optionalProduct = productRepository.findById(product.getProductId());
		if (optionalProduct == null) {
			throw new ProductNotFoundException("Product not Found");
		} else {
			Product updatedProduct = productRepository.save(product);
			return updatedProduct;
		}

	}

	@Override
	public void deleteProductById(String productId) {
		Optional<Product> optionalProduct = productRepository.findById(productId);
		if (optionalProduct.isPresent()) {
			Product product = optionalProduct.get();
			productRepository.delete(product);

		} else {
			throw new ProductNotFoundException("Product not found with id: " + productId);
		}

	}

}
