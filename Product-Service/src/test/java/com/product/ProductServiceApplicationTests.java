package com.product;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import com.product.model.Product;
import com.product.repository.ProductRepository;
import com.product.service.ProductService;

@SpringBootTest
class ProductServiceApplicationTests {

	@Autowired
	private ProductService productService;

	@MockBean
	private ProductRepository productRepository;

	@Test
	public void saveTest() {
		Product product = new Product("2", "Zomato", "199", "https://images.app.goo.gl/XNQ5gnCidxDjRGVb8");
		when(productRepository.save(product)).thenReturn(product);
		assertEquals(product, productService.addProduct(product));
	}

	@Test
	public void findByIdTest() {
		Product product = new Product("2", "Zomato", "199", "https://images.app.goo.gl/XNQ5gnCidxDjRGVb8");
		Mockito.when(productRepository.findById(product.getProductId()).get()).thenReturn(product);
		assertThat(productService.getProductById("2")).isEqualTo(product);

	}

	@Test
	public void findallTest() {
		Product p1 = new Product("1", "Zomato", "199", "https://images.app.goo.gl/XNQ5gnCidxDjRGVb8");
		Product p2 = new Product("2", "Zomato", "149", "https://images.app.goo.gl/XNQ5gnCidxDjRGVb8");
		Product p3 = new Product("3", "Zomato", "299", "https://images.app.goo.gl/XNQ5gnCidxDjRGVb8");
		Product p4 = new Product("4", "Zomato", "169", "https://images.app.goo.gl/XNQ5gnCidxDjRGVb8");
		List<Product> cou = new ArrayList<>();
		cou.add(p1);
		cou.add(p2);
		cou.add(p3);
		cou.add(p4);

		when(productRepository.findAll()).thenReturn(cou);
		assertEquals(productService.getAllProduct().size(), 4);
	}

	@Test
	public void findByNameTest() {
		Product product = new Product("2", "Zomato", "199", "https://images.app.goo.gl/XNQ5gnCidxDjRGVb8");
		Mockito.when(productRepository.findProductByProductName(product.getProductName())).thenReturn(product);
		assertThat(productService.getProductByName("Zomato")).isEqualTo(product);

	}

	@Test
	public void deleteProductTest() {

		Product product = new Product("2", "Zomato", "199", "https://images.app.goo.gl/XNQ5gnCidxDjRGVb8");

		Mockito.when(productRepository.findById("2").get()).thenReturn(product);
		Mockito.when(productRepository.existsById(product.getProductId())).thenReturn(false);
		assertFalse(productRepository.existsById(product.getProductId()));
	}

}
