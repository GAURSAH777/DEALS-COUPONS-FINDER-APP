package com.cart.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cart.model.Cart;
import com.cart.model.Product;

@Repository
public interface CartRepository extends MongoRepository<Cart, Integer> {

	Cart findProductById(Product list);

}
