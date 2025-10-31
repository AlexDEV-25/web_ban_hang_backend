package com.example.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.app.entity.ProductCategoty;

@RepositoryRestResource(path = "categories")
public interface ProductCategoryRepository extends JpaRepository<ProductCategoty, Long> {

}
