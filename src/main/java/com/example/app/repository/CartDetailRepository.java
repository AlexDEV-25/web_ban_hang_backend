package com.example.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.app.entity.CartDetail;

@RepositoryRestResource(path = "cart-details")
public interface CartDetailRepository extends JpaRepository<CartDetail, Long> {

}
