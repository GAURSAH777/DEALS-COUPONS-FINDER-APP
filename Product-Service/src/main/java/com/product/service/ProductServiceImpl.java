package com.product.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Override
	public Product addProduct(Product product) {
		LOGGER.info("Add Product-START!");
		Product savedProduct = productRepository.save(product);
		LOGGER.info("Product added successfully!!");
		LOGGER.info("Add Product-END!");
		return savedProduct;

	}

	@Override
	public List<Product> getAllProduct() {
		LOGGER.info("Get Product-START!");
		List<Product> products = productRepository.findAll();
		if (products == null) {
			LOGGER.info("Product Not Found");
			throw new ProductNotFoundException("Products not found");
		} else {
			LOGGER.info("Displaying Product!");
			LOGGER.info("Get Product-END!");
			return products;
		}

	}

	@Override
	public Product getProductById(String productId) {
		LOGGER.info("Get Product-START!");
		Optional<Product> optionalProduct = productRepository.findById(productId);
		if (optionalProduct.isEmpty()) {
			LOGGER.info("Product Not Found");
			throw new ProductNotFoundException("Product not found with Id: " + productId);
		} else {
			Product product = optionalProduct.get();
			LOGGER.info("Displaying Product!");
			LOGGER.info("Add Product-END!");
			return product;
		}

	}

	@Override
	public Product updateProduct(Product product) {
		LOGGER.info("Update Product -START!");
		Optional<Product> optionalProduct = productRepository.findById(product.getProductId());
		if (optionalProduct == null) {
			LOGGER.info("Product Not Found");
			throw new ProductNotFoundException("Product not Found");
		} else {
			Product updatedProduct = productRepository.save(product);
			LOGGER.info("Updating Product ");
			LOGGER.info("Update Product -END!");
			return updatedProduct;
		}

	}

	@Override
	public void deleteProductById(String productId) {
		LOGGER.info("Delete Product -START!");
		Optional<Product> optionalProduct = productRepository.findById(productId);
		if (optionalProduct.isPresent()) {
			Product product = optionalProduct.get();
			LOGGER.info("Delete Product -End!");
			productRepository.delete(product);

		} else {
			LOGGER.info("Product Not Found");
			throw new ProductNotFoundException("Product not found with id: " + productId);
		}

	}

}
