package com.example.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.app.entity.Cart;

@RepositoryRestResource(path = "carts")
public interface CartRepository extends JpaRepository<Cart, Long> {

}
